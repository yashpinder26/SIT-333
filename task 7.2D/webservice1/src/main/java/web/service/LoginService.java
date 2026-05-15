package web.service;

public class LoginService {

    private static final String VALID_USERNAME = "ahsan";
    private static final String VALID_PASSWORD = "ahsan_pass";
    private static final String VALID_DOB      = "1990-01-01";

    public static boolean login(String username, String password, String dob) {

        if (username == null || username.trim().isEmpty()) return false;
        if (password == null || password.trim().isEmpty()) return false;
        if (dob == null || dob.trim().isEmpty())           return false;
        if (!isValidDateFormat(dob))                       return false;

        return VALID_USERNAME.equals(username)
                && VALID_PASSWORD.equals(password)
                && VALID_DOB.equals(dob);
    }

    static boolean isValidDateFormat(String dob) {
        if (dob == null) return false;
        return dob.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}