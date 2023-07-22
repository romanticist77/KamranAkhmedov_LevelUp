package ru.levelup.at.lesson1011.cicd.allure;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.time.Duration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseSeleniumTest {

    protected static final String USER_BUG_RED_URL = "http://users.bugred.ru/user/login/index.html";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;
    URL url;

    @BeforeMethod
    @Step("Инициализация браузера")
    public void setUp(ITestContext context) {

        try {
            url = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        faker = new Faker();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new RemoteWebDriver(url, options);
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    @Step("Закрытие браузера")
    public void tearDown() {
        driver.quit();
    }
}
