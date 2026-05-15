package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSeleniumTest {

    private static final String CHROME_DRIVER_PATH =
            "C:\\Users\\yashp\\Desktop\\chromedriver-win64\\chromedriver.exe";

    private static final String REGISTER_HTML_PATH =
            "file:///C:/Users/yashp/Desktop/task%207.1P/pages/register.html";

    private void sleep(long sec) {
        try { Thread.sleep(sec * 1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    private WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    private void fillField(WebDriver driver, String id, String value) {
        WebElement el = driver.findElement(By.id(id));
        el.clear();
        el.sendKeys(value);
    }

    // TC-F-01: Successful registration with required fields
    @Test
    public void testRegistrationSuccess_AllRequiredFields() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "Alice");
            fillField(driver, "lname",    "Smith");
            fillField(driver, "username", "alice_selenium1");
            fillField(driver, "email",    "alice@example.com");
            fillField(driver, "passwd",   "pass123");
            fillField(driver, "dob",      "2000-05-15");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertEquals("success", driver.getTitle());
        } finally { driver.close(); }
    }

    // TC-F-02: Successful registration with all fields
    @Test
    public void testRegistrationSuccess_AllFieldsFilled() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "Bob");
            fillField(driver, "lname",    "Jones");
            fillField(driver, "username", "bobjones_selenium");
            fillField(driver, "email",    "bob@example.com");
            fillField(driver, "passwd",   "secureP1");
            fillField(driver, "phone",    "0412345678");
            fillField(driver, "dob",      "1995-08-20");
            fillField(driver, "address",  "42 Main St");
            fillField(driver, "city",     "Melbourne");
            fillField(driver, "country",  "Australia");
            driver.findElement(By.id("gender"))
                  .findElement(By.xpath("//option[@value='male']")).click();
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertEquals("success", driver.getTitle());
        } finally { driver.close(); }
    }

    // TC-F-03: Fail – missing first name
    @Test
    public void testRegistrationFail_MissingFirstName() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "lname",    "Doe");
            fillField(driver, "username", "jdoe_selenium");
            fillField(driver, "email",    "jdoe@example.com");
            fillField(driver, "passwd",   "pass123");
            fillField(driver, "dob",      "1990-01-01");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertTrue(driver.getTitle().startsWith("fail"));
        } finally { driver.close(); }
    }

    // TC-F-04: Fail – invalid email
    @Test
    public void testRegistrationFail_InvalidEmail() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "Carol");
            fillField(driver, "lname",    "White");
            fillField(driver, "username", "carol_selenium");
            fillField(driver, "email",    "not-an-email");
            fillField(driver, "passwd",   "pass123");
            fillField(driver, "dob",      "1998-03-12");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertTrue(driver.getTitle().startsWith("fail"));
        } finally { driver.close(); }
    }

    // TC-F-05: Fail – password too short
    @Test
    public void testRegistrationFail_ShortPassword() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "Dave");
            fillField(driver, "lname",    "Brown");
            fillField(driver, "username", "dave_selenium");
            fillField(driver, "email",    "dave@example.com");
            fillField(driver, "passwd",   "abc");
            fillField(driver, "dob",      "2000-07-07");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertTrue(driver.getTitle().startsWith("fail"));
        } finally { driver.close(); }
    }

    // TC-F-06: Fail – duplicate username
    @Test
    public void testRegistrationFail_DuplicateUsername() {
        WebDriver driver = createDriver();
        try {
            // First registration
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "Eve");
            fillField(driver, "lname",    "Green");
            fillField(driver, "username", "eve_dup_test");
            fillField(driver, "email",    "eve@example.com");
            fillField(driver, "passwd",   "pass123");
            fillField(driver, "dob",      "1997-11-11");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(4);

            // Second registration – same username
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "Emily");
            fillField(driver, "lname",    "Gray");
            fillField(driver, "username", "eve_dup_test");
            fillField(driver, "email",    "emily@example.com");
            fillField(driver, "passwd",   "pass456");
            fillField(driver, "dob",      "1998-12-12");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertTrue(driver.getTitle().startsWith("fail"));
        } finally { driver.close(); }
    }

    // TC-F-07: Page loads with correct title
    @Test
    public void testRegistrationPageLoads() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            Assert.assertTrue(driver.getTitle().contains("Registration"));
        } finally { driver.close(); }
    }

    // TC-F-08: All required fields are present on page
    @Test
    public void testRegistrationFormFieldsPresent() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            for (String id : new String[]{"fname","lname","username","email","passwd","dob"}) {
                Assert.assertNotNull(driver.findElement(By.id(id)));
            }
        } finally { driver.close(); }
    }

    // TC-F-09: Fail – missing date of birth
    @Test
    public void testRegistrationFail_MissingDob() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "Frank");
            fillField(driver, "lname",    "Black");
            fillField(driver, "username", "frank_selenium");
            fillField(driver, "email",    "frank@example.com");
            fillField(driver, "passwd",   "pass123");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertTrue(driver.getTitle().startsWith("fail"));
        } finally { driver.close(); }
    }

    // TC-F-10: Fail – first name contains digits
    @Test
    public void testRegistrationFail_FirstNameWithDigits() {
        WebDriver driver = createDriver();
        try {
            driver.navigate().to(REGISTER_HTML_PATH);
            sleep(3);
            fillField(driver, "fname",    "John123");
            fillField(driver, "lname",    "Doe");
            fillField(driver, "username", "john_selenium2");
            fillField(driver, "email",    "john@example.com");
            fillField(driver, "passwd",   "pass123");
            fillField(driver, "dob",      "1988-06-06");
            driver.findElement(By.cssSelector("[type=submit]")).submit();
            sleep(5);
            Assert.assertTrue(driver.getTitle().startsWith("fail"));
        } finally { driver.close(); }
    }
}