package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testLogin_ValidAllFields_ReturnsTrue() {
        Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLogin_WrongUsername_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("wrong_user", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLogin_WrongPassword_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "wrong_pass", "1990-01-01"));
    }

    @Test
    public void testLogin_WrongDob_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "2000-12-31"));
    }

    @Test
    public void testLogin_NullUsername_ReturnsFalse() {
        Assert.assertFalse(LoginService.login(null, "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLogin_EmptyUsername_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLogin_WhitespaceUsername_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("   ", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLogin_NullPassword_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", null, "1990-01-01"));
    }

    @Test
    public void testLogin_EmptyPassword_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "", "1990-01-01"));
    }

    @Test
    public void testLogin_NullDob_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
    }

    @Test
    public void testLogin_EmptyDob_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
    }

    @Test
    public void testLogin_DobWrongFormat_Slash_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "01/01/1990"));
    }

    @Test
    public void testLogin_DobNoSeparator_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "19900101"));
    }

    @Test
    public void testLogin_DobTooShort_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "1990-1-1"));
    }

    @Test
    public void testLogin_AllNull_ReturnsFalse() {
        Assert.assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testLogin_AllEmpty_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testLogin_UsernameUpperCase_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("AHSAN", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLogin_PasswordUpperCase_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "AHSAN_PASS", "1990-01-01"));
    }

    @Test
    public void testIsValidDateFormat_Valid_ReturnsTrue() {
        Assert.assertTrue(LoginService.isValidDateFormat("1990-01-01"));
    }

    @Test
    public void testIsValidDateFormat_Null_ReturnsFalse() {
        Assert.assertFalse(LoginService.isValidDateFormat(null));
    }

    @Test
    public void testIsValidDateFormat_SlashFormat_ReturnsFalse() {
        Assert.assertFalse(LoginService.isValidDateFormat("01/01/1990"));
    }

    @Test
    public void testIsValidDateFormat_WithLetters_ReturnsFalse() {
        Assert.assertFalse(LoginService.isValidDateFormat("abcd-ef-gh"));
    }
}