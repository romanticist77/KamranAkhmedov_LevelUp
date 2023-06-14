package ru.levelup.at.refactoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;

public class EntryPage extends MailBasePage {

    @FindBy(xpath = "//button[contains(@class, 'ph-login')]")
    private WebElement signInButton;

    public EntryPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    @Override
    public void open() {
        open("/");
    }
}
