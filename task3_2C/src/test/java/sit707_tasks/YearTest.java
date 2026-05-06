package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class YearTest {

    @Test
    public void testValidYear() {
        System.out.println("YearTest - testValidYear: Creating date with day=5, month=3, year=1990");
        DateUtil date = new DateUtil(5, 3, 1990);
        System.out.println("YearTest - testValidYear: Created date -> " + date.toString());
        assertEquals(1990, date.getYear());
        System.out.println("YearTest - testValidYear: PASSED");
    }

    @Test(expected = RuntimeException.class)
    public void testYearBelowMin() {
        System.out.println("YearTest - testYearBelowMin: Creating date with year=1699, expecting RuntimeException");
        new DateUtil(5, 3, 1699);
    }

    @Test(expected = RuntimeException.class)
    public void testYearAboveMax() {
        System.out.println("YearTest - testYearAboveMax: Creating date with year=2025, expecting RuntimeException");
        new DateUtil(5, 3, 2025);
    }

    @Test(expected = RuntimeException.class)
    public void testYearWayBelowMin() {
        System.out.println("YearTest - testYearWayBelowMin: Creating date with year=0, expecting RuntimeException");
        new DateUtil(5, 3, 0);
    }
}