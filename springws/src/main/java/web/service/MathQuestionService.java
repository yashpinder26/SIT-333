package web.service;

public class MathQuestionService {

    public static Double q1Addition(String number1, String number2) {
        if (number1 == null || number1.trim().isEmpty()
                || number2 == null || number2.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.valueOf(number1.trim()) + Double.valueOf(number2.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double q2Subtraction(String number1, String number2) {
        if (number1 == null || number1.trim().isEmpty()
                || number2 == null || number2.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.valueOf(number1.trim()) - Double.valueOf(number2.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double q3Multiplication(String number1, String number2) {
        if (number1 == null || number1.trim().isEmpty()
                || number2 == null || number2.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.valueOf(number1.trim()) * Double.valueOf(number2.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}