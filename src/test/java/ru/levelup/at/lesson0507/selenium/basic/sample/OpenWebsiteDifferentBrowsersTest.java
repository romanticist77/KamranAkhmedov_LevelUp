package ru.levelup.at.lesson0508.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class OpenWebsiteDifferentBrowsersTest {

    public static final String URL = "https://mvnrepository.com/";

    @DataProvider
    static Object[][] browserDataProvider() {
        return new Object[][] {
            {new ChromeDriver()},
            {new EdgeDriver()}
        };
    }

    private WebDriver driver;

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "browserDataProvider")
    public void openWebsiteTest(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to(URL);
        SleepUtils.sleep(3000);
        assertThat(driver.getTitle())
            .as("Название сайта не совпадает с ожидаемым")
            .isEqualTo("Maven Repository: Search/Browse/Explore");
    }
}
