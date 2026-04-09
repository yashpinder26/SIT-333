package sit707_tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DateUtilTest {

    // Student details
    @Test
    public void testStudentIdentity() {
        String studentId = "225159515";
        assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Yashpinder Saini";
        assertNotNull("Student name is null", studentName);
    }

    // Given January sample tests
    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("testMaxJanuary31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(1, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("testMaxJanuary31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(30, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(2, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31PreviousYear() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldDecrementToDecember31PreviousYear > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(31, date.getDay());
        assertEquals(12, date.getMonth());
        assertEquals(2023, date.getYear());
    }

    // PREVIOUS DATE TEST CASES FROM TABLE (1A - 13A)
    // 1A: 1/6/1994 -> 31/5/1994
    @Test
    public void test1A_PreviousDate() {
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("test1A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(31, date.getDay());
        assertEquals(5, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 2A: 2/6/1994 -> 1/6/1994
    @Test
    public void test2A_PreviousDate() {
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("test2A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(1, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 3A: 15/6/1994 -> 14/6/1994
    @Test
    public void test3A_PreviousDate() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("test3A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 4A: 30/6/1994 -> 29/6/1994
    @Test
    public void test4A_PreviousDate() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("test4A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(29, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 5A: 31/6/1994 -> Invalid Date
    @Test(expected = RuntimeException.class)
    public void test5A_InvalidDate() {
        DateUtil date = new DateUtil(31, 6, 1994);
        System.out.println("test5A_InvalidDate > " + date);
    }

    // 6A: 15/1/1994 -> 14/1/1994
    @Test
    public void test6A_PreviousDate() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("test6A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 7A: 15/2/1994 -> 14/2/1994
    @Test
    public void test7A_PreviousDate() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("test7A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 8A: 15/11/1994 -> 14/11/1994
    @Test
    public void test8A_PreviousDate() {
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("test8A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(11, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 9A: 15/12/1994 -> 14/12/1994
    @Test
    public void test9A_PreviousDate() {
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("test9A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(12, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 10A: 15/6/1700 -> 14/6/1700
    @Test
    public void test10A_PreviousDate() {
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("test10A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1700, date.getYear());
    }

    // 11A: 15/6/1701 -> 14/6/1701
    @Test
    public void test11A_PreviousDate() {
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("test11A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1701, date.getYear());
    }

    // 12A: 15/6/2023 -> 14/6/2023
    @Test
    public void test12A_PreviousDate() {
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("test12A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2023, date.getYear());
    }

    // 13A: 15/6/2024 -> 14/6/2024
    @Test
    public void test13A_PreviousDate() {
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("test13A_PreviousDate > " + date);
        date.decrement();
        System.out.println(date);

        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    // NEXT DATE TEST CASES FROM TABLE + REMAINING ONES (1B - 13B)
    // 1B: 1/6/1994 -> 2/6/1994
    @Test
    public void test1B_NextDate() {
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("test1B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(2, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 2B: 2/6/1994 -> 3/6/1994
    @Test
    public void test2B_NextDate() {
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("test2B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(3, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 3B: 15/6/1994 -> 16/6/1994
    @Test
    public void test3B_NextDate() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("test3B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 4B: 30/6/1994 -> 1/7/1994
    @Test
    public void test4B_NextDate() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("test4B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(1, date.getDay());
        assertEquals(7, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 5B: 31/6/1994 -> Invalid Date
    @Test(expected = RuntimeException.class)
    public void test5B_InvalidDate() {
        DateUtil date = new DateUtil(31, 6, 1994);
        System.out.println("test5B_InvalidDate > " + date);
    }

    // 6B: 15/1/1994 -> 16/1/1994
    @Test
    public void test6B_NextDate() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("test6B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 7B: 15/2/1994 -> 16/2/1994
    @Test
    public void test7B_NextDate() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("test7B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 8B: 15/11/1994 -> 16/11/1994
    @Test
    public void test8B_NextDate() {
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("test8B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(11, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 9B: 15/12/1994 -> 16/12/1994
    @Test
    public void test9B_NextDate() {
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("test9B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(12, date.getMonth());
        assertEquals(1994, date.getYear());
    }

    // 10B: 15/6/1700 -> 16/6/1700
    @Test
    public void test10B_NextDate() {
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("test10B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1700, date.getYear());
    }

    // 11B: 15/6/1701 -> 16/6/1701
    @Test
    public void test11B_NextDate() {
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("test11B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1701, date.getYear());
    }

    // 12B: 15/6/2023 -> 16/6/2023
    @Test
    public void test12B_NextDate() {
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("test12B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2023, date.getYear());
    }

    // 13B: 15/6/2024 -> 16/6/2024
    @Test
    public void test13B_NextDate() {
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("test13B_NextDate > " + date);
        date.increment();
        System.out.println(date);

        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2024, date.getYear());
    }
}