package ru.levelup.at.homework5.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.homework4.InboxPage;

public class WriteLetterSteps {

    private final InboxPage inboxPage;

    public WriteLetterSteps(final WebDriver driver) {
        inboxPage = new InboxPage(driver);
    }

    public void writeLetter() {
        inboxPage.clickWriteLetterButton();
    }

    public void fillLetterFields(String recipientData, String subjectId, String loremText) {
        inboxPage.fillRecipient(recipientData)
                 .fillSubject(subjectId)
                 .fillBody(loremText);
    }

    public void fillCustomLetterFields(String recipientData, String subjectId, String loremText) {
        inboxPage.fillRecipient(recipientData)
                 .fillTestSubject(subjectId)
                 .fillBody(loremText);
    }

    public void saveLetter() {
        inboxPage.clickSaveButton();
    }

    public void sendLetter() {
        inboxPage.clickSendButton();
    }

}
