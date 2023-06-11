package ru.levelup.at.lesson0507.selenium.basic.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class AttributeTest {

    public static final String URL_MAIL_RU = "https://mail.ru";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void elementAttributes() {
        driver.navigate().to(URL_MAIL_RU);
        SleepUtils.sleep(3000);

        var button = driver.findElement(By.cssSelector(".resplash-btn"));
        SleepUtils.sleep(3000);
        System.out.println("Color: " + button.getCssValue("color"));
        System.out.println("Background color: " + button.getCssValue("background-color"));
    }
}
