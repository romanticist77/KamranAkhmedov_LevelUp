package ru.levelup.at.homework5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.levelup.at.homework4.EntryPage;
import ru.levelup.at.homework4.FramePage;
import ru.levelup.at.homework4.InboxPage;

public class CommonSteps {

    private final EntryPage entryPage;
    private final FramePage framePage;
    private final InboxPage inboxPage;
    private WebDriver frame;

    public CommonSteps(final WebDriver driver) {
        entryPage = new EntryPage(driver);
        framePage = new FramePage(driver);
        inboxPage = new InboxPage(driver);
    }

    public void openWebsite() {
        entryPage.open();
    }

    public void clickSignInButton() {
        entryPage.clickSignInButton();
    }

    public void switchToFrame() {
        frame = framePage.switchToFrame();
    }

    public void logIn() {
        framePage.fillUsername()
                 .clickEnterPasswordButton()
                 .fillPassword()
                 .clickSignInButton();
    }

    public void switchToDefault() {
        frame.switchTo().defaultContent();
    }

    public WebElement getIncomingMessages() {
        return inboxPage.getIncomingMessagesButton();
    }

    public void assertSuccessfulEntry(WebElement incomingMessagesButton) {
        assertThat(incomingMessagesButton.getText()).as("Нет ожидаемой вкладки на странице").contains("Входящие");
    }

    public void clickSubject(String subjectId) {
        inboxPage.clickOnSubject(subjectId);
    }

    public void closeModalWindow() {
        inboxPage.clickCloseModalWindowButton();
    }

    public void removeLetter() {
        inboxPage.clickRemoveButton();
    }
}
