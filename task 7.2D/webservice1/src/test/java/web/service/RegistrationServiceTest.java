package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationServiceTest {

    @After
    public void tearDown() {
        RegistrationService.clearRegistrations();
    }

    @Test
    public void testRegisterSuccess_AllFieldsValid() {
        String result = RegistrationService.register(
                "Alice", "Smith", "alice123", "alice@example.com", "pass123",
                "0412345678", "2000-05-15", "female", "10 Main St", "Melbourne", "Australia");
        Assert.assertEquals("success", result);
    }

    @Test
    public void testRegisterFail_BlankFirstName() {
        String result = RegistrationService.register(
                "", "Smith", "bob123", "bob@example.com", "pass123",
                null, "1999-01-01", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterFail_BlankLastName() {
        String result = RegistrationService.register(
                "Bob", "", "bob123", "bob@example.com", "pass123",
                null, "1999-01-01", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterFail_BlankUsername() {
        String result = RegistrationService.register(
                "Bob", "Jones", "", "bob@example.com", "pass123",
                null, "1999-01-01", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterFail_InvalidEmail() {
        String result = RegistrationService.register(
                "Carol", "White", "carol1", "not-an-email", "pass123",
                null, "1995-07-20", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterFail_EmailNoDomain() {
        String result = RegistrationService.register(
                "Carol", "White", "carol2", "carol@", "pass123",
                null, "1995-07-20", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterSuccess_SubdomainEmail() {
        String result = RegistrationService.register(
                "Dave", "Brown", "dave99", "dave@mail.deakin.edu.au", "securePass1",
                null, "1998-03-10", null, null, null, null);
        Assert.assertEquals("success", result);
    }

    @Test
    public void testRegisterFail_PasswordTooShort() {
        String result = RegistrationService.register(
                "Eve", "Green", "eve1", "eve@example.com", "abc",
                null, "2001-11-30", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterSuccess_PasswordExactlyMinLength() {
        String result = RegistrationService.register(
                "Frank", "Black", "frank1", "frank@example.com", "abcdef",
                null, "1990-06-15", null, null, null, null);
        Assert.assertEquals("success", result);
    }

    @Test
    public void testRegisterFail_BlankDob() {
        String result = RegistrationService.register(
                "Grace", "Hill", "grace1", "grace@example.com", "pass123",
                null, "", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterFail_NullEmail() {
        String result = RegistrationService.register(
                "Henry", "Lake", "henry1", null, "pass123",
                null, "1985-09-09", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterFail_DuplicateUsername() {
        RegistrationService.register(
                "Ivy", "Stone", "ivy_user", "ivy@example.com", "pass123",
                null, "1993-04-20", null, null, null, null);
        String result = RegistrationService.register(
                "Irene", "Rock", "ivy_user", "irene@example.com", "pass456",
                null, "1994-05-21", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterFail_InvalidFirstName_ContainsNumbers() {
        String result = RegistrationService.register(
                "John123", "Doe", "johndoe", "john@example.com", "pass123",
                null, "1990-01-01", null, null, null, null);
        Assert.assertTrue(result.startsWith("fail"));
    }

    @Test
    public void testRegisterSuccess_HyphenatedFirstName() {
        String result = RegistrationService.register(
                "Mary-Jane", "Watson", "mj_watson", "mj@example.com", "spidey1",
                null, "1992-08-14", null, null, null, null);
        Assert.assertEquals("success", result);
    }

    @Test
    public void testIsValidEmail() {
        Assert.assertTrue(RegistrationService.isValidEmail("user@domain.com"));
        Assert.assertFalse(RegistrationService.isValidEmail("userdomain.com"));
        Assert.assertFalse(RegistrationService.isValidEmail("user@"));
        Assert.assertFalse(RegistrationService.isValidEmail(""));
        Assert.assertFalse(RegistrationService.isValidEmail(null));
    }

    @Test
    public void testIsValidPassword() {
        Assert.assertTrue(RegistrationService.isValidPassword("abcdef"));
        Assert.assertTrue(RegistrationService.isValidPassword("a1B2c3D4"));
        Assert.assertFalse(RegistrationService.isValidPassword("abc"));
        Assert.assertFalse(RegistrationService.isValidPassword(""));
        Assert.assertFalse(RegistrationService.isValidPassword(null));
    }

    @Test
    public void testIsBlank() {
        Assert.assertTrue(RegistrationService.isBlank(null));
        Assert.assertTrue(RegistrationService.isBlank(""));
        Assert.assertTrue(RegistrationService.isBlank("   "));
        Assert.assertFalse(RegistrationService.isBlank("text"));
    }

    @Test
    public void testRegisterSuccess_OptionalFieldsNull() {
        String result = RegistrationService.register(
                "Kim", "Lee", "kimlee", "kim@example.com", "passok1",
                null, "2002-12-01", null, null, null, null);
        Assert.assertEquals("success", result);
    }
}