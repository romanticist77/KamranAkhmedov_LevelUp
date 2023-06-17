package ru.levelup.at.homework4;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CustomRulesTest extends SeleniumBaseTest {

    @Test(dataProvider = "Email data provider", dataProviderClass = BaseDataProvider.class)
    public void successfulRoutingTest(String recipientData, String subjectId, String loremText) {

        var entryPage = new EntryPage(driver)
            .open()
            .clickSignInButton();

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
                 .fillTestSubject(subjectId)
                 .fillBody(loremText)
                 .clickSendButton()
                 .clickCloseModalWindowButton()
                 .clickSentMessagesButton();

        var verifySubject = inboxPage.verifySelfTestSubjectFound(subjectId);

        System.out.println("Sent. Target subject is found: " + verifySubject);

        inboxPage.clickTestMessagesButton();

        verifySubject = inboxPage.verifyTestSubjectFound(subjectId);
        verifySubject.click();

        var verifyRecipient = inboxPage.verifyRecipientFound(recipientData);
        var verifyBody = inboxPage.verifyBodyFound(loremText);

        System.out.println("Test. Target subject is found: " + verifySubject);
        System.out.println("Test. Target recipient is found: " + verifyRecipient);
        System.out.println("Test. Target body is found: " + verifyBody);

        inboxPage.clickProfileButton()
                 .clickExitButton();
    }
}
