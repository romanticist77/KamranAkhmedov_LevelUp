package ru.levelup.at.lesson0507.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class OpenWebsiteTest {

    public static final String URL = "https://mvnrepository.com/";

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
    public void openWebsiteTest() {
        driver.navigate().to(URL);
        SleepUtils.sleep(3000);
        assertThat(driver.getTitle())
            .as("Название сайта не совпадает с ожидаемым")
            .isEqualTo("Maven Repository: Search/Browse/Explore");
    }
}
