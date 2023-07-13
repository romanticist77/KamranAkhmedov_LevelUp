package ru.levelup.at.homework4;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MailBasePage {

    protected static final String MAIL_RU = "https://mail.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;

    public MailBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeURL) {
        driver.navigate().to(MAIL_RU + relativeURL);
    }

    public abstract MailBasePage open();
}
