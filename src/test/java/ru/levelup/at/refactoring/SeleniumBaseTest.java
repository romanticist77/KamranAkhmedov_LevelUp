package ru.levelup.at.refactoring;

import com.github.javafaker.Faker;
import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SeleniumBaseTest {

    protected static final String MAIL_RU = "https://mail.ru";

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        uuid = UUID.randomUUID();
        uuidAsString = uuid.toString();
        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
