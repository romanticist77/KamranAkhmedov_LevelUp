package ru.levelup.at.lesson1011.cicd.allure.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedMainPage extends UserBugRedBasePage {

    @FindBy(xpath = "//li[@id='fat-menu']/a[@class='dropdown-toggle']")
    private WebElement userDropdown;

    public UserBugRedMainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем имя зарегистрированного пользователя")
    public String getUserNameText() {
        return wait.until(ExpectedConditions.visibilityOf(userDropdown)).getText();
    }

    @Override
    @Step("Открываем главную страницу")
    public void open() {
        open("/");
    }
}
