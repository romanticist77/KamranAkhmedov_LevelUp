package ru.levelup.at.homework3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.levelup.at.homework3.MailBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class EntryPage extends MailBaseTest {

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
