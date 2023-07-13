package ru.levelup.at.homework5.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.levelup.at.homework4.InboxPage;

public class VerifySteps {

    private final InboxPage inboxPage;

    public VerifySteps(final WebDriver driver) {
        inboxPage = new InboxPage(driver);
    }

    public WebElement subject;
    public WebElement recipient;
    public WebElement body;
    public boolean noSubject;

    public void verifySubject(String subjectId) {
        subject = inboxPage.verifySubjectFound(subjectId);
    }

    public void verifySelfSubject(String subjectId) {
        subject = inboxPage.verifySelfSubjectFound(subjectId);
    }

    public void verifyTestSubject(String subjectId) {
        subject = inboxPage.verifyTestSubjectFound(subjectId);
    }

    public void verifySelfTestSubject(String subjectId) {
        subject = inboxPage.verifySelfTestSubjectFound(subjectId);
    }

    public void verifyNoSubject(String subjectId) {
        noSubject = inboxPage.verifySubjectNotFound(subjectId);
    }

    public void verifyRecipient(String recipientData) {
        subject = inboxPage.verifyRecipientFound(recipientData);
    }

    public void verifyBody(String loremText) {
        subject = inboxPage.verifyBodyFound(loremText);
    }
}
