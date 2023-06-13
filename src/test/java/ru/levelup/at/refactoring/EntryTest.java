package ru.levelup.at.refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class EntryTest extends SeleniumBaseTest {

    @Test
    public void successfulEntryTest() {

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
        inboxPage.clickSaveButton();
        inboxPage.clickLookDraftsButton();
        var verifySubjectFound = inboxPage.verifySubjectFound();

        System.out.println(
            "Drafts. Target subject is found: " + verifySubjectFound);

        inboxPage.clickOnSubject();
        inboxPage.clickSendButton();
        inboxPage.clickCloseModalWindowButton();
        var verifySubjectNotFound = inboxPage.verifySubjectNotFound();

        System.out.println("Drafts. Target subject is not found: " + verifySubjectNotFound);

        inboxPage.clickSentMessagesButton();
        verifySubjectFound = inboxPage.verifySelfSubjectFound();

        System.out.println(
            "Sent. Target subject is found: " + verifySubjectFound);

        inboxPage.clickProfileButton();
        inboxPage.clickExitButton();
    }
}
