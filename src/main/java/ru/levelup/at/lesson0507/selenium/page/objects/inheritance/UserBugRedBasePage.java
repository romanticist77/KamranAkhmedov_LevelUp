package ru.levelup.at.lesson0507.selenium.page.objects.inheritance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class UserBugRedBasePage {

    protected static final String USER_BUG_RED_URL = "http://users.bugred.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UserBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeURL) {
        driver.navigate().to(USER_BUG_RED_URL + relativeURL);
    }

    public abstract void open();
}
