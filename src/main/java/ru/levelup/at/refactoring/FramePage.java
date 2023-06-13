package ru.levelup.at.refactoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramePage extends MailBasePage {

    //        var framePage = wait.until((ExpectedConditions.visibilityOfElementLocated(
    //            By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"))));
    //        var frame = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framePage));
    //
    //        var username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
    //        username.sendKeys("test94.00@mail.ru");
    //
    //        var enterPasswordButton = wait.until(
    //            ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='next-button']")));
    //        enterPasswordButton.click();
    //
    //        var password =
    //            wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))));
    //        password.sendKeys("S{Txf7X8-U$SgiJ");
    //
    //        var signInButton = wait.until(
    //            ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='submit-button']")));
    //        signInButton.click();

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

    public void fillUsername() {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("test94.00@mail.ru");
    }

    public void clickEnterPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(enterPasswordButton)).click();
    }

    public void fillPassword() {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("S{Txf7X8-U$SgiJ");
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.navigate().to("/");
    }
}
