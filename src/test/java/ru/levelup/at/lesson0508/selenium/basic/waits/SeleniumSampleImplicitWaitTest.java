package ru.levelup.at.lesson0508.selenium.waits;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSampleImplicitWaitTest {

    public static final String GOOGLE_URL = "https://google.com";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to(GOOGLE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTest() {
        var startTime = System.currentTimeMillis();
        try {
            var searchTextBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
            searchTextBox.sendKeys("Нариман Нариманов");

            var searchButton = driver.findElement(By.xpath("//div[contains(@class, 'LLD4me ')]"));
            searchButton.click();
            searchButton = driver.findElement(By.xpath("//div[contains(@class, 'FPdoLc')]//input[@class='gNO89b']"));
            searchButton.click();

            var searchResults = driver.findElements(By.xpath("//div/a/h3"));
            assertThat(searchResults)
                .as("Не найдено результатов")
                .hasSizeGreaterThan(12);
        } finally {
            var endTime = System.currentTimeMillis();
            System.out.println("Время выполнения: " + (endTime - startTime) + "ms");
        }
    }

    @Test
    public void searchFailTest() {
        var startTime = System.currentTimeMillis();
        try {
            var searchTextBox = driver.findElement(By.xpath("//textarea[@class='gLFyf1']"));
            searchTextBox.sendKeys("Нариман Нариманов");

            var searchButton = driver.findElement(By.xpath("//div[contains(@class, 'LLD4me ')]"));
            searchButton.click();
            searchButton = driver.findElement(By.xpath("//div[contains(@class, 'FPdoLc')]//input[@class='gNO89b']"));
            searchButton.click();

            var searchResults = driver.findElements(By.xpath("//div/a/h31"));
            assertThat(searchResults)
                .as("Не найдено результатов")
                .hasSizeGreaterThan(12);
        } finally {
            var endTime = System.currentTimeMillis();
            System.out.println("Время выполнения: " + (endTime - startTime) + "ms");
        }
    }
}
