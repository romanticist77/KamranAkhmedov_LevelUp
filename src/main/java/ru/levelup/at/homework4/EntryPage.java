package ru.levelup.at.homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EntryPage extends MailBasePage {

    @FindBy(xpath = "//button[contains(@class, 'ph-login')]")
    private WebElement signInButton;

    public EntryPage(WebDriver driver) {
        super(driver);
    }

    public EntryPage clickSignInButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(signInButton)).click();
        return this;
    }

    @Override
    public EntryPage open() {
        open("/");
        return this;
    }
}
