package ru.levelup.at.homework3;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EntrySeleniumTest extends BaseSeleniumTest {

    @Test
    public void successfulEntryTest() {
        var entryPage = new EntryPage(driver);
        driver.navigate().to(MAIL_RU);
        entryPage.clickSignInButton();

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

        var signInButton = wait.until(
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

        var saveButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='save']")));
        saveButton.click();

        var lookDraftsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
            "//span[@class='notify__Посмотреть']")));
        lookDraftsButton.click();

        var verifySubject = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(text(),'%s')]".formatted(uuidAsString))));
        System.out.println(
            "Drafts. Target subject is found: " + verifySubject);
        verifySubject.click();

        var sendButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='send']")));
        sendButton.click();

        var closeModalWindowButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer__controls']/span")));
        closeModalWindowButton.click();

        var verifyMessageSent =
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//span[text()='%s']".formatted(uuidAsString))));

        System.out.println("Drafts. Target subject is not found: " + verifyMessageSent);

        var sentMessagesButton =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Отправленные']")));
        sentMessagesButton.click();

        verifySubject = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Self: %s']".formatted(uuidAsString))));

        System.out.println(
            "Sent. Target subject is found: " + verifySubject);

        var profileButton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'ph-avatar-img')]")));
        profileButton.click();

        var exitButton = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Выйти']"))));
        exitButton.click();
    }
}
