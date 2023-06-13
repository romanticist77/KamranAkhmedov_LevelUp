package ru.levelup.at.refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomRulesTest extends SeleniumBaseTest {

    @Test
    public void successfulRoutingTest() {

        var entryPage = new EntryPage(driver);
        entryPage.open();
        entryPage.clickSignInButton();
        var framePage = new FramePage(driver);
        var switchToFrame = framePage.switchToFrame();
        framePage.fillUsername();
        framePage.clickEnterPasswordButton();
        framePage.fillPassword();
        framePage.clickSignInButton();
        switchToFrame.switchTo().defaultContent();
        var inboxPage = new InboxPage(driver);
        var incomingMessagesButton = inboxPage.getIncomingMessagesButton();

        assertThat(incomingMessagesButton.getText()).as("Нет ожидаемой вкладки на странице").contains("Входящие");

        inboxPage.clickWriteLetterButton();
        inboxPage.fillRecipient();
        inboxPage.fillTestSubject();
        inboxPage.fillBody();
        inboxPage.clickSendButton();
        inboxPage.clickCloseModalWindowButton();
        inboxPage.clickSentMessagesButton();
        var verifySubject = inboxPage.verifySelfTestSubjectFound();

        System.out.println("Sent. Target subject is found: " + verifySubject);

        inboxPage.clickTestMessagesButton();
        verifySubject = inboxPage.verifyTestSubjectFound();
        verifySubject.click();
        var verifyRecipient = inboxPage.verifyRecipientFound();
        var verifyBody = inboxPage.verifyBodyFound();

        System.out.println("Test. Target subject is found: " + verifySubject);
        System.out.println("Test. Target recipient is found: " + verifyRecipient);
        System.out.println("Test. Target body is found: " + verifyBody);

        inboxPage.clickProfileButton();
        inboxPage.clickExitButton();
    }
}
