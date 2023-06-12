package ru.levelup.at.homework3;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.UUID;

public class BaseSeleniumTest {

    protected static final String MAIL_RU = "https://mail.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UUID uuid;
    protected String uuidAsString;
    protected Faker faker;

    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
        uuid = UUID.randomUUID();
        uuidAsString = uuid.toString();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
