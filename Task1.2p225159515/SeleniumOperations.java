package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

/**
 * Selenium Operations for Week 1
 */
public class SeleniumOperations {

    // Sleep function to pause execution
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ Set your ChromeDriver path (Windows)
    public static void setDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\yashp\\Desktop\\chromedriver-win64\\chromedriver.exe");
    }

    // 1. Open Chrome and close
    public static void open_chrome_and_close() {

        System.out.println("Hello from 225159515, Yashpinder Saini");

        setDriverPath();

        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(5);

        driver.close();
    }

    // 2. Open Chrome, maximize and close
    public static void open_chrome_maximize_close() {

        System.out.println("Hello from 225159515, Yashpinder Saini");

        setDriverPath();

        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        sleep(2);

        driver.manage().window().maximize();

        sleep(5);

        driver.close();
    }

    // 3. Load web page and close
    public static void load_web_page_close() {

        System.out.println("Hello from 225159515, Yashpinder Saini");

        setDriverPath();

        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        sleep(2);

        driver.get("https://www.google.com");

        sleep(5);

        driver.close();
    }

    // 4. Open Chrome, load page, resize, close
    public static void open_chrome_loadpage_resize_close() {

        System.out.println("Hello from 225159515, Yashpinder Saini");

        setDriverPath();

        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        sleep(2);

        // Load Google
        driver.get("https://www.google.com");

        sleep(2);

        // Resize to 640x480
        driver.manage().window().setSize(new Dimension(640, 480));

        sleep(2);

        // Resize to 1280x960
        driver.manage().window().setSize(new Dimension(1280, 960));

        sleep(5);

        driver.close();
    }
}