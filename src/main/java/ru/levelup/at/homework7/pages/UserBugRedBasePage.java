package ru.levelup.at.homework7.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UserBugRedBasePage {

    protected static final String USER_BUG_RED_URL = "http://users.bugred.ru";

    protected final WebDriver driver;
    protected WebDriverWait wait;

    public UserBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeUrl) {
        driver.navigate().to(USER_BUG_RED_URL + relativeUrl);
    }

    public abstract void open();
}
