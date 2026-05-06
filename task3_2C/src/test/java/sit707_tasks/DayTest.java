package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class DayTest {

    @Test
    public void testValidDay() {
        System.out.println("DayTest - testValidDay: Creating date with day=20, month=8, year=2010");
        DateUtil date = new DateUtil(20, 8, 2010);
        System.out.println("DayTest - testValidDay: Created date -> " + date.toString());
        assertEquals(20, date.getDay());
        System.out.println("DayTest - testValidDay: PASSED");
    }

    @Test(expected = RuntimeException.class)
    public void testDayBelowMin() {
        System.out.println("DayTest - testDayBelowMin: Creating date with day=0, expecting RuntimeException");
        new DateUtil(0, 8, 2010);
    }

    @Test(expected = RuntimeException.class)
    public void testDayAboveMax() {
        System.out.println("DayTest - testDayAboveMax: Creating date with day=32, expecting RuntimeException");
        new DateUtil(32, 8, 2010);
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeDay() {
        System.out.println("DayTest - testNegativeDay: Creating date with day=-1, expecting RuntimeException");
        new DateUtil(-1, 8, 2010);
    }
}