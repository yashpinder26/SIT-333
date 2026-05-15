package web.service;

/**
 * Business logic to handle user registration.
 */
public class RegistrationService {

    private static final java.util.Set<String> registeredUsernames = new java.util.HashSet<>();

    public static String register(
            String fName, String lName, String username,
            String email, String password,
            String phone, String dob,
            String gender, String address, String city, String country) {

        System.out.println("[RegistrationService] Attempting registration for: " + username);

        if (isBlank(fName))    return "fail: first name is required";
        if (isBlank(lName))    return "fail: last name is required";
        if (isBlank(username)) return "fail: username is required";
        if (isBlank(email))    return "fail: email is required";
        if (isBlank(password)) return "fail: password is required";
        if (isBlank(dob))      return "fail: date of birth is required";

        if (!isValidEmail(email))       return "fail: invalid email format";
        if (!isValidPassword(password)) return "fail: password too short (min 6 chars)";
        if (!isValidName(fName))        return "fail: first name contains invalid characters";
        if (!isValidName(lName))        return "fail: last name contains invalid characters";

        if (registeredUsernames.contains(username.toLowerCase())) {
            return "fail: username already taken";
        }

        registeredUsernames.add(username.toLowerCase());
        System.out.println("[RegistrationService] Registered: "
                + fName + " " + lName + " | " + username + " | " + email + " | DOB: " + dob);

        return "success";
    }

    // Backward-compatible overload matching original 7.1P signature
    public static boolean register(String fName, String lName, String email, String dob) {
        String result = register(fName, lName, fName + "_user", email, "default1",
                null, dob, null, null, null, null);
        return "success".equals(result);
    }

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        if (isBlank(email)) return false;
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    public static boolean isValidPassword(String password) {
        if (isBlank(password)) return false;
        return password.length() >= 6;
    }

    public static boolean isValidName(String name) {
        if (isBlank(name)) return false;
        return name.matches("^[a-zA-Z\\s'\\-]+$");
    }

    public static void clearRegistrations() {
        registeredUsernames.clear();
    }
}