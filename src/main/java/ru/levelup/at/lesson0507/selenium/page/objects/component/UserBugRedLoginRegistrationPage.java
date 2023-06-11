package ru.levelup.at.lesson0507.selenium.page.objects.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelup.at.lesson0507.selenium.page.objects.component.elements.LoginComponent;
import ru.levelup.at.lesson0507.selenium.page.objects.component.elements.RegistrationComponent;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    public static final String PAGE_URL = "/user/login/index.html";

    private final LoginComponent login;
    private final RegistrationComponent registration;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
        login = new LoginComponent(driver);
        registration = new RegistrationComponent(driver);
    }

    public LoginComponent login() {
        return login;
    }

    public RegistrationComponent registration() {
        return registration;
    }

    @Override
    public void open() {
        open(PAGE_URL);
    }
}
