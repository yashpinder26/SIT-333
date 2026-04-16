package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * Student: Yashpinder Saini
 * ID: 225159515
 */
public class LoginFormTest {

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
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordButEmptyValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode(null));
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordButWrongValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode("wrong_code"));
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode(status.getErrorMsg()));
    }
}