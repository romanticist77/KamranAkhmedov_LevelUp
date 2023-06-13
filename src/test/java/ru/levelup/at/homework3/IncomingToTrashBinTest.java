package ru.levelup.at.homework3;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.UUID;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IncomingToTrashBinTest {

    public static final String MAIL_RU = "https://mail.ru/";

    private WebDriver driver;
    private WebDriverWait wait;

    private UUID uuid;
    String uuidAsString;

    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(MAIL_RU);

        uuid = UUID.randomUUID();
        uuidAsString = uuid.toString();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successfulRoutingTest() {
        var signInButton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'ph-login')]")));
        signInButton.click();

        var framePage = wait.until((ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"))));
        var frame = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framePage));

        var username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        username.sendKeys("test94.00@mail.ru");

        var enterPasswordButton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='next-button']")));
        enterPasswordButton.click();

        var password =
            wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))));
        password.sendKeys("S{Txf7X8-U$SgiJ");

        signInButton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='submit-button']")));
        signInButton.click();

        frame.switchTo().defaultContent();
        var incomingMessagesButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-folder-link-id='0']")));

        assertThat(incomingMessagesButton.getText()).as("Нет ожидаемой вкладки на странице").contains("Входящие");

        var writeLetterButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-title-shortcut='N']")));
        writeLetterButton.click();

        var recipient = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input--3slxg']//div//input")));
        recipient.sendKeys("test94.00@mail.ru");
        var subject = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='subject__container--HWnat']//div//input")));
        subject.sendKeys(uuidAsString);
        var body = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class, 'editable-container-')]/div[contains(@class, 'editable-')]")));
        body.sendKeys("Hello, this is a testing letter.");

        var sendButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='send']")));
        sendButton.click();

        var closeModalWindowButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer__controls']/span")));
        closeModalWindowButton.click();

        var toYourSelf =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Письма себе']")));
        toYourSelf.click();

        var verifySubject = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='%s']".formatted(uuidAsString))));
        verifySubject.click();

        System.out.println("Incoming. Target subject is found: " + verifySubject);

        var verifyRecipient = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@title,'test94.00@mail.ru')]")));
        var verifyBody = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[text()='Hello, this is a testing letter.']")));
        //
        System.out.println("Incoming. Target recipient is found: " + verifyRecipient);
        System.out.println("Incoming. Target body is found: " + verifyBody);

        var removeButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Удалить']/parent::span")));
        removeButton.click();

        var trashBin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Корзина']")));
        trashBin.click();

        verifySubject = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='%s']".formatted(uuidAsString))));

        System.out.println("Trash bin. Target body is found: " + verifySubject);

        var profileButton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'ph-avatar-img')]")));
        profileButton.click();

        var exitButton = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Выйти']"))));
        exitButton.click();
    }
}
