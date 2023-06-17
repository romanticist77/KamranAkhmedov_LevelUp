package ru.levelup.at.homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramePage extends MailBasePage {

    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement frameModalWindow;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;
    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement enterPasswordButton;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement signInButton;

    public WebDriver switchToFrame() {
        return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameModalWindow));
    }

    public FramePage fillUsername() {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(UtilCreds.username);
        return this;
    }

    public FramePage clickEnterPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(enterPasswordButton)).click();
        return this;
    }

    public FramePage fillPassword() {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(UtilCreds.password);
        return this;
    }

    public FramePage clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return this;
    }

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FramePage open() {
        driver.navigate().to("/");
        return this;
    }
}
