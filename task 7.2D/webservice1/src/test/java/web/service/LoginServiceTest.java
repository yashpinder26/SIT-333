package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginServiceTest {

    private static final String CHROMEDRIVER_PATH =
            "C:\\Users\\yashp\\Desktop\\chromedriver-win64\\chromedriver.exe";

    private static final String LOGIN_HTML_PATH =
            "file:///C:/Users/yashp/Desktop/task%207.1P/pages/login.html";

    private void sleep(long sec) {
        try { Thread.sleep(sec * 1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    private WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        return new ChromeDriver(new ChromeOptions());
    }

    private String submitLoginForm(WebDriver driver, String username, String password, String dob) {
        driver.navigate().to(LOGIN_HTML_PATH);
        sleep(3);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        if (username != null) ele.sendKeys(username);

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        if (password != null) ele.sendKeys(password);

        if (dob != null && !dob.isEmpty()) {
            ele = driver.findElement(By.id("dob"));
            ele.clear();
            ele.sendKeys(dob);
        }

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);
        return driver.getTitle();
    }

    @Test
    public void testLoginSuccess_ValidCredentials() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "ahsan", "ahsan_pass", "1990-01-01");
            System.out.println("[TC-F01] Title: " + title);
            Assert.assertEquals("success", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_WrongUsername() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "wronguser", "ahsan_pass", "1990-01-01");
            System.out.println("[TC-F02] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_WrongPassword() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "ahsan", "wrongpassword", "1990-01-01");
            System.out.println("[TC-F03] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_WrongDoB() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "ahsan", "ahsan_pass", "2000-12-31");
            System.out.println("[TC-F04] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_EmptyUsername() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "", "ahsan_pass", "1990-01-01");
            System.out.println("[TC-F05] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_EmptyPassword() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "ahsan", "", "1990-01-01");
            System.out.println("[TC-F06] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_NoDoB() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "ahsan", "ahsan_pass", "");
            System.out.println("[TC-F07] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_AllEmpty() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "", "", "");
            System.out.println("[TC-F08] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_SqlInjection() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, "' OR '1'='1", "ahsan_pass", "1990-01-01");
            System.out.println("[TC-F09] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }

    @Test
    public void testLoginFail_UsernameWithSpaces() {
        WebDriver driver = createDriver();
        try {
            String title = submitLoginForm(driver, " ahsan ", "ahsan_pass", "1990-01-01");
            System.out.println("[TC-F10] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally { driver.close(); }
    }
}