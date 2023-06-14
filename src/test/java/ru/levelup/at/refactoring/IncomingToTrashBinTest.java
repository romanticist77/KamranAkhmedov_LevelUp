package ru.levelup.at.refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import java.io.IOException;

public class IncomingToTrashBinTest extends SeleniumBaseTest {

    @Test
    public void successfulRoutingTest()  {

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
        inboxPage.fillSubject();
        inboxPage.fillBody();
        inboxPage.clickSendButton();
        inboxPage.clickCloseModalWindowButton();
        inboxPage.clickToYourselfButton();

        var verifySubject = inboxPage.verifySubjectFound();
        inboxPage.clickOnSubject();

        System.out.println("Incoming. Target subject is found: " + verifySubject);

        var verifyRecipient = inboxPage.verifyRecipientFound();
        var verifyBody = inboxPage.verifyBodyFound();

        System.out.println("Incoming. Target recipient is found: " + verifyRecipient);
        System.out.println("Incoming. Target body is found: " + verifyBody);

        inboxPage.clickRemoveButton();
        inboxPage.clickTrashBinButton();
        verifySubject = inboxPage.verifySubjectFound();

        System.out.println("Trash bin. Target body is found: " + verifySubject);

        inboxPage.clickProfileButton();
        inboxPage.clickExitButton();
    }
}
