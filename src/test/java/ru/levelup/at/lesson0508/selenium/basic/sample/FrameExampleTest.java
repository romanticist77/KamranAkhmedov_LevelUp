package ru.levelup.at.lesson0508.selenium.basic.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class FrameExampleTest {

    public static final String URL = "https://mail.ru";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        SleepUtils.sleep(1500);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void frameTest() {
        driver.findElement(By.cssSelector("[data-testid='enter-mail-primary']")).click();
        SleepUtils.sleep(2000);

        var framePage = driver.findElement(By.cssSelector(".ag-popup__frame__layout__iframe"));
        var frame = driver.switchTo().frame(framePage);
        SleepUtils.sleep(6000);

        frame.findElement(By.cssSelector("[name='username']")).sendKeys("romanticist77@mail.ru");
        SleepUtils.sleep(2000);

        frame.switchTo().defaultContent();
    }
}
