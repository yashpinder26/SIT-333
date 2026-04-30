package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

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
    public void testCancelWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testCancel_HighPrecipitation() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }

    @Test
    public void testCancel_CombinedWindAndRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(45.1, 4.1));
    }

    @Test
    public void testWarn_HighWindOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.1, 0.0));
    }

    @Test
    public void testWarn_HighRainOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 4.1));
    }

    @Test
    public void testAllClear_NoWeather() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 0.0));
    }

    @Test
    public void testAllClear_AtBoundary() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));
    }

    @Test
    public void testAllClear_NormalConditions() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
    }


    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }

    @Test
    public void testIsEven_EvenNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testIsEven_Zero() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }

    @Test
    public void testIsEven_NegativeEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(-2));
    }

    @Test
    public void testIsEven_NegativeOdd() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(-3));
    }


    @Test
    public void testIsPrime_One() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testIsPrime_Two() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testIsPrime_EvenNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testIsPrime_OddPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }

    @Test
    public void testIsPrime_LargerOddPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
    }
}