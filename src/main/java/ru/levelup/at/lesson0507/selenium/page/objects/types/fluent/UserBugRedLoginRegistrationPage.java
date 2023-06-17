package ru.levelup.at.lesson0507.selenium.page.objects.types.fluent;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserBugRedLoginRegistrationPage {

    protected static final String USER_BUG_RED_URL = "http://users.bugred.ru/user/login/index.html";

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement loginField;
    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;
    @FindBy(xpath = "//form[contains(@action, 'register')]/p")
    private WebElement errorMessageLabel;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    public UserBugRedLoginRegistrationPage open() {
        driver.navigate().to(USER_BUG_RED_URL);
        return this;
    }

    public UserBugRedLoginRegistrationPage fillLoginField(final String login) {
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
        return this;
    }

    public UserBugRedLoginRegistrationPage fillPasswordField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        return this;
    }

    public UserBugRedLoginRegistrationPage fillEmailField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        return this;
    }

    public UserBugRedMainPage successClickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new UserBugRedMainPage(driver);
    }

    public UserBugRedLoginRegistrationPage failClickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return this;
    }

    public String getErrorMessageLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}