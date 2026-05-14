package sit707_week6;

/**
 * Utility class providing weather advisory and mathematical helper functions.
 *
 * Bug fixed in isPrime(): original code called isEven(n) inside the loop
 * instead of isEven(i), causing odd composites (e.g. 9, 15) to be wrongly
 * reported as prime.
 */
public class WeatherAndMathUtils {

    public static final double DANGEROUS_WINDSPEED  = 70.0;
    public static final double DANGEROUS_RAINFALL   = 6.0;
    public static final double CONCERNING_WINDSPEED = 45.0;
    public static final double CONCERNING_RAINFALL  = 4.0;

    public static String weatherAdvice(double windSpeed, double precipitation) {
        if (windSpeed < 0 || precipitation < 0) {
            throw new IllegalArgumentException(
                "Wind speed and precipitation must be non-negative.");
        }
        if (windSpeed > DANGEROUS_WINDSPEED
                || precipitation > DANGEROUS_RAINFALL
                || (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
            return "CANCEL";
        }
        if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
            return "WARN";
        }
        return "ALL CLEAR";
    }

    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    /**
     * FIX: original used isEven(n) in loop — should be n % i == 0.
     * Also fixed: 1 is NOT prime by mathematical convention.
     */
    public static boolean isPrime(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be >= 1");
        }
        if (n == 1) { return false; }
        if (n == 2) { return true;  }
        if (isEven(n)) { return false; }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) { return false; }
        }
        return true;
    }
}