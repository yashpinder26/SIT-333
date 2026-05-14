package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for WeatherAndMathUtils following Right-BICEP:
 *   B – Boundary conditions
 *   I – Inverse relationships
 *   C – Cross-check / Consistency
 *   E – Error conditions
 */
public class WeatherAndMathUtilsTest {

    // -------------------------------------------------------
    // Required identity tests (from task6_1P, now passing)
    // -------------------------------------------------------

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
    public void testEvenNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testOddNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(7));
    }

    @Test
    public void testZeroIsEven() {
        Assert.assertTrue("Zero should be even", WeatherAndMathUtils.isEven(0));
    }

    @Test
    public void testNegativeEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(-2));
    }

    // -------------------------------------------------------
    // isEven – Boundary condition (B)
    // -------------------------------------------------------

    @Test
    public void testBoundaryEvenOne() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(1));
    }

    // -------------------------------------------------------
    // isEven – Inverse relationship (I)
    // Even(n) must always be the opposite of Even(n+1)
    // -------------------------------------------------------

    @Test
    public void testInverseEvenOddConsecutive() {
        for (int n = -5; n <= 5; n++) {
            Assert.assertNotEquals(
                "isEven(" + n + ") and isEven(" + (n + 1) + ") must differ",
                WeatherAndMathUtils.isEven(n),
                WeatherAndMathUtils.isEven(n + 1));
        }
    }

    // -------------------------------------------------------
    // isPrime – Right results (R)
    // -------------------------------------------------------

    @Test
    public void testPrimeTwo() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testPrimeThree() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }

    @Test
    public void testPrimeSeven() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
    }

    @Test
    public void testNotPrimeFour() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testNotPrimeOne() {
        Assert.assertFalse("1 should not be prime", WeatherAndMathUtils.isPrime(1));
    }

    // -------------------------------------------------------
    // isPrime – Boundary conditions (B)
    // -------------------------------------------------------

    @Test
    public void testBoundaryPrimeLargeKnownPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(97));
    }

    @Test
    public void testBoundaryPrimeOddComposite() {
        // 9 = 3x3 — the ORIGINAL buggy code returned true here
        Assert.assertFalse("9 is not prime (3x3)", WeatherAndMathUtils.isPrime(9));
    }

    @Test
    public void testBoundaryPrime15() {
        // 15 = 3x5 — also failed with the original bug
        Assert.assertFalse("15 is not prime (3x5)", WeatherAndMathUtils.isPrime(15));
    }

    // -------------------------------------------------------
    // isPrime – Inverse / Cross-check (I + C)
    // Product of two primes must NOT be prime
    // -------------------------------------------------------

    @Test
    public void testInversePrimeProduct() {
        int p1 = 11, p2 = 13;
        Assert.assertTrue(WeatherAndMathUtils.isPrime(p1));
        Assert.assertTrue(WeatherAndMathUtils.isPrime(p2));
        Assert.assertFalse("Product of two primes must not be prime",
                WeatherAndMathUtils.isPrime(p1 * p2));
    }

    // -------------------------------------------------------
    // isPrime – Error condition (E)
    // -------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void testPrimeNegativeInput() {
        WeatherAndMathUtils.isPrime(-1);
    }

    // -------------------------------------------------------
    // weatherAdvice – Right results (R)
    // -------------------------------------------------------

    @Test
    public void testAllClearWeather() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 0.0));
    }

    @Test
    public void testCancelWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testCancelHighRainfall() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }

    @Test
    public void testWarnWindOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 0.0));
    }

    @Test
    public void testWarnRainfallOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 5.0));
    }

    // -------------------------------------------------------
    // weatherAdvice – Boundary conditions (B)
    // -------------------------------------------------------

    @Test
    public void testBoundaryWindExactlyDangerous() {
        // Exactly 70.0 is NOT above the threshold — must not be CANCEL
        Assert.assertNotEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.0, 0.0));
    }

    @Test
    public void testBoundaryWindJustAboveDangerous() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.001, 0.0));
    }

    @Test
    public void testBoundaryRainfallExactlyDangerous() {
        Assert.assertNotEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.0));
    }

    @Test
    public void testBoundaryRainfallJustAboveDangerous() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.001));
    }

    @Test
    public void testBoundaryConcerningWindExactly() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 0.0));
    }

    @Test
    public void testBoundaryConcerningWindJustAbove() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.001, 0.0));
    }

    @Test
    public void testBoundaryConcerningRainfallExactly() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 4.0));
    }

    @Test
    public void testBoundaryConcerningRainfallJustAbove() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 4.001));
    }

    // -------------------------------------------------------
    // weatherAdvice – Cross-check / Consistency (C)
    // Two individually-WARN inputs combined must escalate to CANCEL
    // -------------------------------------------------------

    @Test
    public void testCrossCheckWarnPlusWarnEqualsCancel() {
        String r1 = WeatherAndMathUtils.weatherAdvice(46.0, 0.0);  // WARN
        String r2 = WeatherAndMathUtils.weatherAdvice(0.0,  4.1);  // WARN
        String r3 = WeatherAndMathUtils.weatherAdvice(46.0, 4.1);  // CANCEL

        Assert.assertEquals("WARN",   r1);
        Assert.assertEquals("WARN",   r2);
        Assert.assertEquals("CANCEL", r3);
    }

    // -------------------------------------------------------
    // weatherAdvice – Error conditions (E)
    // -------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWindSpeedThrowsException() {
        WeatherAndMathUtils.weatherAdvice(-1.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrecipitationThrowsException() {
        WeatherAndMathUtils.weatherAdvice(0.0, -0.1);
    }
}