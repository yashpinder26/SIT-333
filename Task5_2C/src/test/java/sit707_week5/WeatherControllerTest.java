package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "225159515"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Yashpinder Saini";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();

        // Act
        double minTemperature = 1000;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (minTemperature > temperatureVal)
                minTemperature = temperatureVal;
        }

        // Assert
        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
        wController.close();
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();

        // Act
        double maxTemperature = -1;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (maxTemperature < temperatureVal)
                maxTemperature = temperatureVal;
        }

        // Assert
        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
        wController.close();
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();

        // Act
        double sumTemp = 0;
        for (int i = 0; i < nHours; i++)
            sumTemp += wController.getTemperatureForHour(i + 1);
        double averageTemp = sumTemp / nHours;

        // Assert
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
        wController.close();
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();

        // Inject a frozen clock so time cannot drift during the sleep delay.
        // Both persistTemperature() and this test read the exact same Date object.
        final Date frozenInstant = new Date();
        WeatherClock fixedClock = () -> frozenInstant;
        wController.setClock(fixedClock);

        String expectedTime = new SimpleDateFormat("H:m:s").format(frozenInstant);

        // Act
        String persistTime = wController.persistTemperature(10, 19.5);
        System.out.println("Persist time: " + persistTime + ", expected: " + expectedTime);

        // Assert
        Assert.assertEquals(
            "Persist timestamp must match the frozen clock instant",
            expectedTime, persistTime);

        wController.close();
    }
}