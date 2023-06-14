package ru.levelup.at.refactoring;

import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MailBasePage {

    protected static final String MAIL_RU = "https://mail.ru";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected UUID uuid;
    protected final String uuidAsString;

    public MailBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        uuid = UUID.randomUUID();
        uuidAsString = uuid.toString();
        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeURL) {
        driver.navigate().to(MAIL_RU + relativeURL);
    }

    public abstract void open();
}
