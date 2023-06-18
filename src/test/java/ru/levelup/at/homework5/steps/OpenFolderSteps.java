package ru.levelup.at.homework5.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.homework4.InboxPage;

public class OpenFolderSteps {

    private final InboxPage inboxPage;

    public OpenFolderSteps(final WebDriver driver) {
        inboxPage = new InboxPage(driver);
    }

    public void lookDrafts() {
        inboxPage.clickLookDraftsButton();
    }

    public void openSentMessages() {
        inboxPage.clickSentMessagesButton();
    }

    public void openTestMessages() {
        inboxPage.clickTestMessagesButton();
    }

    public void openToYourselfMessages() {
        inboxPage.clickToYourselfButton();
    }

    public void openTrashBin() {
        inboxPage.clickTrashBinButton();
    }
}
