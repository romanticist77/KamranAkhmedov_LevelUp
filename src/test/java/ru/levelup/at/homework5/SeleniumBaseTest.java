package ru.levelup.at.homework5;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.at.homework5.steps.CommonSteps;
import ru.levelup.at.homework5.steps.OpenFolderSteps;
import ru.levelup.at.homework5.steps.ProfileSteps;
import ru.levelup.at.homework5.steps.VerifySteps;
import ru.levelup.at.homework5.steps.WriteLetterSteps;

public class SeleniumBaseTest {

    protected CommonSteps commonSteps;
    protected WriteLetterSteps writeLetterSteps;
    protected OpenFolderSteps openFolderSteps;
    protected VerifySteps verifySteps;
    protected ProfileSteps profileSteps;
    protected static final String MAIL_RU = "https://mail.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonSteps = new CommonSteps(driver);
        writeLetterSteps = new WriteLetterSteps(driver);
        openFolderSteps = new OpenFolderSteps(driver);
        verifySteps = new VerifySteps(driver);
        profileSteps = new ProfileSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
