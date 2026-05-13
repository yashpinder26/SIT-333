package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1Addition_ValidPositiveNumbers() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.001);
    }

    @Test
    public void testQ1Addition_ValidDecimalNumbers() {
        Assert.assertEquals(5.5, MathQuestionService.q1Addition("2.5", "3.0"), 0.001);
    }

    @Test
    public void testQ1Addition_ZeroValues() {
        Assert.assertEquals(0.0, MathQuestionService.q1Addition("0", "0"), 0.001);
    }

    @Test
    public void testQ1Addition_NegativeNumbers() {
        Assert.assertEquals(-3.0, MathQuestionService.q1Addition("-1", "-2"), 0.001);
    }

    @Test
    public void testQ1Addition_Number1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }

    @Test
    public void testQ1Addition_Number2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("1", ""));
    }

    @Test
    public void testQ1Addition_BothEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }

    @Test
    public void testQ1Addition_Number1Null() {
        Assert.assertNull(MathQuestionService.q1Addition(null, "2"));
    }

    @Test
    public void testQ1Addition_Number2Null() {
        Assert.assertNull(MathQuestionService.q1Addition("1", null));
    }

    @Test
    public void testQ1Addition_BothNull() {
        Assert.assertNull(MathQuestionService.q1Addition(null, null));
    }

    @Test
    public void testQ1Addition_NonNumericInput() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
    }

    @Test
    public void testQ1Addition_WhitespaceInput() {
        Assert.assertNull(MathQuestionService.q1Addition("   ", "2"));
    }

    @Test
    public void testQ2Subtraction_ValidPositiveNumbers() {
        Assert.assertEquals(3.0, MathQuestionService.q2Subtraction("5", "2"), 0.001);
    }

    @Test
    public void testQ2Subtraction_ResultIsNegative() {
        Assert.assertEquals(-2.0, MathQuestionService.q2Subtraction("3", "5"), 0.001);
    }

    @Test
    public void testQ2Subtraction_ZeroResult() {
        Assert.assertEquals(0.0, MathQuestionService.q2Subtraction("4", "4"), 0.001);
    }

    @Test
    public void testQ2Subtraction_DecimalNumbers() {
        Assert.assertEquals(1.5, MathQuestionService.q2Subtraction("4.5", "3.0"), 0.001);
    }

    @Test
    public void testQ2Subtraction_Number1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
    }

    @Test
    public void testQ2Subtraction_Number2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("5", ""));
    }

    @Test
    public void testQ2Subtraction_BothNull() {
        Assert.assertNull(MathQuestionService.q2Subtraction(null, null));
    }

    @Test
    public void testQ2Subtraction_NonNumericInput() {
        Assert.assertNull(MathQuestionService.q2Subtraction("xyz", "2"));
    }

    @Test
    public void testQ3Multiplication_ValidPositiveNumbers() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0.001);
    }

    @Test
    public void testQ3Multiplication_MultiplyByZero() {
        Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("5", "0"), 0.001);
    }

    @Test
    public void testQ3Multiplication_MultiplyByOne() {
        Assert.assertEquals(7.0, MathQuestionService.q3Multiplication("7", "1"), 0.001);
    }

    @Test
    public void testQ3Multiplication_NegativeNumbers() {
        Assert.assertEquals(-6.0, MathQuestionService.q3Multiplication("-2", "3"), 0.001);
    }

    @Test
    public void testQ3Multiplication_BothNegative() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("-2", "-3"), 0.001);
    }

    @Test
    public void testQ3Multiplication_DecimalNumbers() {
        Assert.assertEquals(7.5, MathQuestionService.q3Multiplication("2.5", "3.0"), 0.001);
    }

    @Test
    public void testQ3Multiplication_Number1Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "3"));
    }

    @Test
    public void testQ3Multiplication_Number2Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("2", ""));
    }

    @Test
    public void testQ3Multiplication_BothEmpty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", ""));
    }

    @Test
    public void testQ3Multiplication_Number1Null() {
        Assert.assertNull(MathQuestionService.q3Multiplication(null, "3"));
    }

    @Test
    public void testQ3Multiplication_Number2Null() {
        Assert.assertNull(MathQuestionService.q3Multiplication("2", null));
    }

    @Test
    public void testQ3Multiplication_NonNumericInput() {
        Assert.assertNull(MathQuestionService.q3Multiplication("two", "3"));
    }
}