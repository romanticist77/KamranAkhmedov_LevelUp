package ru.levelup.at.homework3;

import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class SeleniumBaseTest {

    public static final String MAIL_RU = "https://mail.ru/";
    private WebDriver driver;
    protected WebDriverWait wait;

    private UUID uuid;
    String uuidAsString;

    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(MAIL_RU);
        uuid = UUID.randomUUID();
        uuidAsString = uuid.toString();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
