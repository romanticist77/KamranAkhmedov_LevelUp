package ru.levelup.at.homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    protected static final String USER_BUG_RED_URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement loginField;
    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[@action='/user/register/index.html']/p")
    private WebElement errorText;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Открываем страницу регистрации")
    public void open() {
        open(USER_BUG_RED_URL);
    }

    @Step("Заполняем поле login - {login}")
    public void fillLoginField(final String login) {
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
    }

    @Step("Заполняем поле login - {password}")
    public void fillPasswordField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    @Step("Заполняем поле login - {email}")
    public void fillEmailField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }

    @Step("Нажимаем на кнопку регистрации")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    @Step("Получаем текст ошибки")
    public String getErrorText() {
        return wait.until((ExpectedConditions.visibilityOf(errorText))).getText();
    }
}
