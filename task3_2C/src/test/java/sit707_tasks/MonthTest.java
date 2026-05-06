package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonthTest {

    @Test
    public void testValidMonth() {
        System.out.println("MonthTest - testValidMonth: Creating date with day=10, month=9, year=2015");
        DateUtil date = new DateUtil(10, 9, 2015);
        System.out.println("MonthTest - testValidMonth: Created date -> " + date.toString());
        assertEquals(9, date.getMonth());
        System.out.println("MonthTest - testValidMonth: PASSED");
    }

    @Test(expected = RuntimeException.class)
    public void testMonthBelowMin() {
        System.out.println("MonthTest - testMonthBelowMin: Creating date with month=0, expecting RuntimeException");
        new DateUtil(10, 0, 2015);
    }

    @Test(expected = RuntimeException.class)
    public void testMonthAboveMax() {
        System.out.println("MonthTest - testMonthAboveMax: Creating date with month=13, expecting RuntimeException");
        new DateUtil(10, 13, 2015);
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeMonth() {
        System.out.println("MonthTest - testNegativeMonth: Creating date with month=-1, expecting RuntimeException");
        new DateUtil(10, -1, 2015);
    }
}