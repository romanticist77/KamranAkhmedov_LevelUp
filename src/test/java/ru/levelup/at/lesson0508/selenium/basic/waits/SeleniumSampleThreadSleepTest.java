package ru.levelup.at.lesson0508.selenium.basic.waits;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class SeleniumSampleThreadSleepTest {

    public static final String GOOGLE_URL = "https://google.com";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
        SleepUtils.sleep(1000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void SearchTest() {
        var startTime = System.currentTimeMillis();
        try {
            var searchTextBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
            searchTextBox.sendKeys("Нариман Нариманов");

            var searchButton = driver.findElement(By.xpath("//div[contains(@class, 'LLD4me ')]"));
            searchButton.click();
            searchButton = driver.findElement(By.xpath("//div[contains(@class, 'FPdoLc')]//input[@class='gNO89b']"));
            searchButton.click();

            SleepUtils.sleep(3000);
            var searchResults = driver.findElements(By.xpath("//div/a/h3"));
            assertThat(searchResults)
                .as("Не найдено результатов")
                .hasSizeGreaterThan(12);
        } finally {
            var endTime = System.currentTimeMillis();
            System.out.println("Время выполнения: " + (endTime - startTime) + "ms");
        }
    }
}
