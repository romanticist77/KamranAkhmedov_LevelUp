package ru.levelup.at.homework5.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.homework4.InboxPage;

public class ProfileSteps {

    private final InboxPage inboxPage;

    public ProfileSteps(final WebDriver driver) {
        inboxPage = new InboxPage(driver);
    }

    //        inboxPage.clickProfileButton()
    //                 .clickExitButton();
    public void openProfileMenu() {
        inboxPage.clickProfileButton();
    }

    public void exit() {
        inboxPage.clickExitButton();
    }

}
