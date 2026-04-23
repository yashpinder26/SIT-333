package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("=== @BeforeClass: Initialising WeatherController (runs once) ===");

        // Arrange -- create the single shared controller instance (slow, happens once)
        wController = WeatherController.getInstance();

        // Arrange -- fetch all hourly temperatures once and store locally (slow, happens once)
        int nHours = wController.getTotalHours();
        hourlyTemperatures = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }

        System.out.println("Pre-fetched hourly temperatures stored locally for reuse.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== @AfterClass: Closing WeatherController (runs once) ===");
        if (wController != null) {
            wController.close();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s225159515";
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

        // Arrange -- calculate expected min from pre-fetched local array (fast)
        double expectedMin = 1000;
        for (double temp : hourlyTemperatures) {
            if (temp < expectedMin) expectedMin = temp;
        }

        // Act
        double cachedMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertTrue(
            "Cached min (" + cachedMin + ") does not match expected (" + expectedMin + ")",
            cachedMin == expectedMin
        );
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange -- calculate expected max from pre-fetched local array (fast)
        double expectedMax = -1;
        for (double temp : hourlyTemperatures) {
            if (temp > expectedMax) expectedMax = temp;
        }

        // Act
        double cachedMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertTrue(
            "Cached max (" + cachedMax + ") does not match expected (" + expectedMax + ")",
            cachedMax == expectedMax
        );
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange -- calculate expected average from pre-fetched local array (fast)
        double sum = 0;
        for (double temp : hourlyTemperatures) {
            sum += temp;
        }
        double expectedAverage = sum / hourlyTemperatures.length;

        // Act
        double cachedAverage = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertTrue(
            "Cached avg (" + cachedAverage + ") does not match expected (" + expectedAverage + ")",
            cachedAverage == expectedAverage
        );
    }

    @Test
    public void testTemperaturePersist() {
        // Leave commented -- only uncomment for 5.3C task
//      WeatherController wController = WeatherController.getInstance();
//      String persistTime = wController.persistTemperature(10, 19.5);
//      String now = new SimpleDateFormat("H:m:s").format(new Date());
//      Assert.assertTrue(persistTime.equals(now));
//      wController.close();
    }
}