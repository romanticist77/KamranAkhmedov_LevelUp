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

    //        var verifySubjectFound = inboxPage.verifySubjectFound(subjectId);
    //
    //        System.out.println(
    //            "Drafts. Target subject is found: " + verifySubjectFound);
    //
    //        inboxPage.clickOnSubject(subjectId)
    //                 .clickSendButton()
    //                 .clickCloseModalWindowButton();
    //
    //        var verifySubjectNotFound = inboxPage.verifySubjectNotFound(subjectId);
    //
    //        System.out.println("Drafts. Target subject is not found: " + verifySubjectNotFound);
    //
    //        inboxPage.clickSentMessagesButton();
    //        verifySubjectFound = inboxPage.verifySelfSubjectFound(subjectId);
    //
    //        System.out.println(
    //            "Sent. Target subject is found: " + verifySubjectFound);
    //
}
