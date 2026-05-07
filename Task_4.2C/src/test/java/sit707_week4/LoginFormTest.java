package sit707_week4;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class LoginFormTest {

    private static final String STUDENT_ID   = "225159515";
    private static final String STUDENT_NAME = "Yashpinder Saini";

    private static final String VALID_EMAIL = "yashpindersaini@gmail.com";
    private static final String VALID_PASS  = "VJSBVSDdnvsl327y42()";

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    private void openLoginPage() {
        driver.get("https://www.bunnings.com.au/login");
    }

    private void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performLogin(String email, String password) {
        openLoginPage();
        sleep(2);
        WebElement emailField    = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement signInButton  = driver.findElement(By.id("login-submit"));
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        sleep(3);
    }

    @Test
    public void testStudentIdentity() {
        Assert.assertNotNull("Student ID is null", STUDENT_ID);
        Assert.assertFalse("Student ID is empty", STUDENT_ID.trim().isEmpty());
    }

    @Test
    public void testStudentName() {
        Assert.assertNotNull("Student name is null", STUDENT_NAME);
        Assert.assertFalse("Student name is empty", STUDENT_NAME.trim().isEmpty());
    }

    @Test
    public void testFailNoEmailNoPass() {
        performLogin("", "");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testFailNoEmailWrongPass() {
        performLogin("", "WrongPass123!");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testFailWrongEmailNoPass() {
        performLogin("fakeuser@example.com", "");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testFailWrongEmailWrongPass() {
        performLogin("fakeuser@example.com", "WrongPass123!");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testFailCorrectEmailWrongPass() {
        performLogin(VALID_EMAIL, "WrongPass123!");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testPassCorrectEmailCorrectPass() {
        performLogin(VALID_EMAIL, VALID_PASS);
        sleep(4);
        Assert.assertFalse(driver.getCurrentUrl().contains("login"));
    }
}
