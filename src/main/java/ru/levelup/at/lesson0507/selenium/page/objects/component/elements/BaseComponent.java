package ru.levelup.at.lesson0507.selenium.page.objects.component.elements;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }
}
