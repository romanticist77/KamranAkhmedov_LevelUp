package ru.levelup.at.homework5;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import ru.levelup.at.homework4.EntryPage;
import ru.levelup.at.homework4.FramePage;
import ru.levelup.at.homework4.InboxPage;

public class IncomingToTrashBinTest extends SeleniumBaseTest {

    @Test(dataProvider = "Email data provider", dataProviderClass = BaseDataProvider.class)
    public void successfulRoutingTest(String recipientData, String subjectId, String loremText) {

        var entryPage = new EntryPage(driver);

        entryPage.open();
        entryPage.clickSignInButton();

        var framePage = new FramePage(driver);
        var switchToFrame = framePage.switchToFrame();

        framePage.fillUsername()
                 .clickEnterPasswordButton()
                 .fillPassword()
                 .clickSignInButton();
        switchToFrame.switchTo().defaultContent();

        var inboxPage = new InboxPage(driver);
        var incomingMessagesButton = inboxPage.getIncomingMessagesButton();

        assertThat(incomingMessagesButton.getText()).as("Нет ожидаемой вкладки на странице").contains("Входящие");

        inboxPage.clickWriteLetterButton()
                 .fillRecipient(recipientData)
                 .fillSubject(subjectId)
                 .fillBody(loremText)
                 .clickSendButton()
                 .clickCloseModalWindowButton()
                 .clickToYourselfButton();

        var verifySubject = inboxPage.verifySubjectFound(subjectId);
        inboxPage.clickOnSubject(subjectId);

        System.out.println("Incoming. Target subject is found: " + verifySubject);

        var verifyRecipient = inboxPage.verifyRecipientFound(recipientData);
        var verifyBody = inboxPage.verifyBodyFound(loremText);

        System.out.println("Incoming. Target recipient is found: " + verifyRecipient);
        System.out.println("Incoming. Target body is found: " + verifyBody);

        inboxPage.clickRemoveButton()
                 .clickTrashBinButton();

        verifySubject = inboxPage.verifySubjectFound(subjectId);

        System.out.println("Trash bin. Target body is found: " + verifySubject);

        inboxPage.clickProfileButton()
                 .clickExitButton();
    }
}
