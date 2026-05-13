package web.functional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumFunctionalTest {

    private static final String BASE = "http://127.0.0.1:8081";
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\yashp\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        driver = new ChromeDriver(opts);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    private void sleep() {
        try { Thread.sleep(1500); } catch (InterruptedException e) {}
    }

    private void clickSubmit() {
        WebElement btn = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit']")));
        btn.click();
        sleep();
    }

    private void solveAddition() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("number1")));
        sleep();

        WebElement n1 = driver.findElement(By.id("number1"));
        WebElement n2 = driver.findElement(By.id("number2"));

        n1.clear();
        n1.sendKeys("3");
        n2.clear();
        n2.sendKeys("4");

        sleep();
        String val1 = driver.findElement(By.id("number1")).getAttribute("value");
        String val2 = driver.findElement(By.id("number2")).getAttribute("value");
        System.out.println("DEBUG Q1 number1=" + val1 + " number2=" + val2);

        double answer = Double.parseDouble(val1.trim()) + Double.parseDouble(val2.trim());
        int answerInt = (int) answer;
        System.out.println("DEBUG Q1 answer=" + answerInt);

        WebElement result = driver.findElement(By.id("result"));
        result.clear();
        result.sendKeys(String.valueOf(answerInt));

        String resultVal = driver.findElement(By.id("result")).getAttribute("value");
        System.out.println("DEBUG Q1 result field=" + resultVal);

        clickSubmit();
    }

    private void solveSubtraction() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("number1")));
        sleep();

        WebElement n1 = driver.findElement(By.id("number1"));
        WebElement n2 = driver.findElement(By.id("number2"));

        n1.clear();
        n1.sendKeys("9");
        n2.clear();
        n2.sendKeys("3");

        sleep();
        String val1 = driver.findElement(By.id("number1")).getAttribute("value");
        String val2 = driver.findElement(By.id("number2")).getAttribute("value");
        System.out.println("DEBUG Q2 number1=" + val1 + " number2=" + val2);

        double answer = Double.parseDouble(val1.trim()) - Double.parseDouble(val2.trim());
        int answerInt = (int) answer;
        System.out.println("DEBUG Q2 answer=" + answerInt);

        WebElement result = driver.findElement(By.id("result"));
        result.clear();
        result.sendKeys(String.valueOf(answerInt));

        String resultVal = driver.findElement(By.id("result")).getAttribute("value");
        System.out.println("DEBUG Q2 result field=" + resultVal);

        clickSubmit();
    }

    private void solveMultiplication() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("number1")));
        sleep();

        WebElement n1 = driver.findElement(By.id("number1"));
        WebElement n2 = driver.findElement(By.id("number2"));

        n1.clear();
        n1.sendKeys("3");
        n2.clear();
        n2.sendKeys("4");

        sleep();
        String val1 = driver.findElement(By.id("number1")).getAttribute("value");
        String val2 = driver.findElement(By.id("number2")).getAttribute("value");
        System.out.println("DEBUG Q3 number1=" + val1 + " number2=" + val2);

        double answer = Double.parseDouble(val1.trim()) * Double.parseDouble(val2.trim());
        int answerInt = (int) answer;
        System.out.println("DEBUG Q3 answer=" + answerInt);

        WebElement result = driver.findElement(By.id("result"));
        result.clear();
        result.sendKeys(String.valueOf(answerInt));

        String resultVal = driver.findElement(By.id("result")).getAttribute("value");
        System.out.println("DEBUG Q3 result field=" + resultVal);

        clickSubmit();
    }

    private void doValidLogin() {
        driver.get(BASE + "/login");
        sleep();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
        clickSubmit();
        wait.until(ExpectedConditions.urlContains("/q1"));
        sleep();
    }

    private void passQ1() {
        wait.until(ExpectedConditions.urlContains("/q1"));
        solveAddition();
        wait.until(ExpectedConditions.urlContains("/q2"));
        sleep();
    }

    private void passQ2() {
        wait.until(ExpectedConditions.urlContains("/q2"));
        solveSubtraction();
        wait.until(ExpectedConditions.urlContains("/q3"));
        sleep();
    }

    @Test
    public void testWelcomePageLoads() {
        driver.get(BASE + "/");
        sleep();
        Assert.assertTrue("Welcome page should load",
                driver.getPageSource().contains("Welcome"));
    }

    @Test
    public void testLoginPageLoads() {
        driver.get(BASE + "/login");
        sleep();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        Assert.assertTrue("Username field present",
                driver.findElements(By.id("username")).size() > 0);
        Assert.assertTrue("Password field present",
                driver.findElements(By.id("passwd")).size() > 0);
    }

    @Test
    public void testValidLoginRedirectsToQ1() {
        doValidLogin();
        Assert.assertTrue("Should be on /q1",
                driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testInvalidLoginShowsError() {
        driver.get(BASE + "/login");
        sleep();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("wrong");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("wrong");
        clickSubmit();
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue("Should stay on /login",
                driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue("Error message shown",
                driver.getPageSource().contains("Incorrect credentials"));
    }

    @Test
    public void testQ1CorrectAnswerGoesToQ2() {
        doValidLogin();
        solveAddition();
        wait.until(ExpectedConditions.urlContains("/q2"));
        Assert.assertTrue("Should be on /q2",
                driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1WrongAnswerShowsError() {
        doValidLogin();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("number1")));
        sleep();
        WebElement n1 = driver.findElement(By.id("number1"));
        WebElement n2 = driver.findElement(By.id("number2"));
        n1.clear(); n1.sendKeys("3");
        n2.clear(); n2.sendKeys("4");
        WebElement result = driver.findElement(By.id("result"));
        result.clear(); result.sendKeys("99");
        clickSubmit();
        wait.until(ExpectedConditions.urlContains("/q1"));
        Assert.assertTrue("Should stay on /q1",
                driver.getCurrentUrl().contains("/q1"));
        Assert.assertTrue("Error message shown",
                driver.getPageSource().contains("Wrong answer"));
    }

    @Test
    public void testQ1EmptySubmissionNoCrash() {
        doValidLogin();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[type='submit']")));
        sleep();
        clickSubmit();
        wait.until(ExpectedConditions.urlContains("/q1"));
        Assert.assertTrue("Should stay on /q1",
                driver.getCurrentUrl().contains("/q1"));
        Assert.assertFalse("No exception on page",
                driver.getPageSource().contains("NumberFormatException"));
    }

    @Test
    public void testQ2CorrectAnswerGoesToQ3() {
        doValidLogin();
        passQ1();
        solveSubtraction();
        wait.until(ExpectedConditions.urlContains("/q3"));
        Assert.assertTrue("Should be on /q3",
                driver.getCurrentUrl().contains("/q3"));
    }

    @Test
    public void testQ2WrongAnswerShowsError() {
        doValidLogin();
        passQ1();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("number1")));
        sleep();
        WebElement n1 = driver.findElement(By.id("number1"));
        WebElement n2 = driver.findElement(By.id("number2"));
        n1.clear(); n1.sendKeys("10");
        n2.clear(); n2.sendKeys("4");
        WebElement result = driver.findElement(By.id("result"));
        result.clear(); result.sendKeys("100");
        clickSubmit();
        wait.until(ExpectedConditions.urlContains("/q2"));
        Assert.assertTrue("Should stay on /q2",
                driver.getCurrentUrl().contains("/q2"));
        Assert.assertTrue("Error message shown",
                driver.getPageSource().contains("Wrong answer"));
    }

    @Test
    public void testQ3PageLoads() {
        driver.get(BASE + "/q3");
        sleep();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("form")));
        Assert.assertTrue("Q3 heading present",
                driver.getPageSource().contains("Q3"));
        Assert.assertTrue("Form present",
                driver.findElements(By.cssSelector("form")).size() > 0);
    }

    @Test
    public void testQ3EmptySubmissionNoCrash() {
        driver.get(BASE + "/q3");
        sleep();
        clickSubmit();
        wait.until(ExpectedConditions.urlContains("/q3"));
        Assert.assertTrue("Should stay on /q3",
                driver.getCurrentUrl().contains("/q3"));
        Assert.assertFalse("No exception on page",
                driver.getPageSource().contains("NumberFormatException"));
    }

    @Test
    public void testFullGameCompletion() {
        doValidLogin();
        passQ1();
        passQ2();
        solveMultiplication();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("/q3")));
        Assert.assertTrue("Game completed, back at /",
                driver.getCurrentUrl().endsWith("/") ||
                driver.getCurrentUrl().endsWith(":8081/"));
    }
}