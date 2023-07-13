package ru.levelup.at.homework5.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.homework4.InboxPage;

public class WriteLetterSteps {

    private final InboxPage inboxPage;

    public WriteLetterSteps(final WebDriver driver) {
        inboxPage = new InboxPage(driver);
    }

    public void saveLetter() {
        inboxPage.clickSaveButton();
    }

    public void writeLetter(String recipientData, String subjectId, String loremText) {
        inboxPage.clickWriteLetterButton()
                 .fillRecipient(recipientData)
                 .fillSubject(subjectId)
                 .fillBody(loremText);
    }

    public void sendLetter() {
        inboxPage.clickSendButton();
    }

    public void sendFilledLetter(String recipientData, String subjectId, String loremText) {
        inboxPage.clickWriteLetterButton()
                 .fillRecipient(recipientData)
                 .fillSubject(subjectId)
                 .fillBody(loremText)
                 .clickSendButton();
    }

    public void sendCustomFilledLetter(String recipientData, String subjectId, String loremText) {
        inboxPage.clickWriteLetterButton()
                 .fillRecipient(recipientData)
                 .fillTestSubject(subjectId)
                 .fillBody(loremText)
                 .clickSendButton();
    }
}
