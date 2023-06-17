package ru.levelup.at.homework4;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class EntryTest extends SeleniumBaseTest {

    @Test(dataProvider = "Email data provider", dataProviderClass = BaseDataProvider.class)
    public void successfulEntryTest(String recipientData, String subjectId, String loremText) {

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
        inboxPage.fillRecipient(recipientData);
        inboxPage.fillSubject(subjectId);
        inboxPage.fillBody(loremText);
        inboxPage.clickSaveButton();
        inboxPage.clickLookDraftsButton();
        var verifySubjectFound = inboxPage.verifySubjectFound(subjectId);

        System.out.println(
            "Drafts. Target subject is found: " + verifySubjectFound);

        inboxPage.clickOnSubject(subjectId);
        inboxPage.clickSendButton();
        inboxPage.clickCloseModalWindowButton();
        var verifySubjectNotFound = inboxPage.verifySubjectNotFound(subjectId);

        System.out.println("Drafts. Target subject is not found: " + verifySubjectNotFound);

        inboxPage.clickSentMessagesButton();
        verifySubjectFound = inboxPage.verifySelfSubjectFound(subjectId);

        System.out.println(
            "Sent. Target subject is found: " + verifySubjectFound);

        inboxPage.clickProfileButton();
        inboxPage.clickExitButton();
    }
}
