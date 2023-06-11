package ru.levelup.at.lesson0508.selenium.basic.sample;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class WindowHandleTest {

    public static final String URL_MVN_COM = "https://mvnrepository.com/";
    public static final String URL_ADOBE_COM = "https://get.adobe.com/";
    public static final String URL_VISUALSTUDIO_COM = "https://visualstudio.microsoft.com/";

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
        System.out.println("Открываем URL_VISUALSTUDIO_COM");
        driver.navigate().to(URL_VISUALSTUDIO_COM);
        SleepUtils.sleep(2000);
        System.out.println(driver.getWindowHandles());
        System.out.println();

        System.out.println("Открываем URL_ADOBE_COM");
        driver = driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(URL_ADOBE_COM);
        SleepUtils.sleep(2000);
        System.out.println(driver.getWindowHandles());
        System.out.println();

        System.out.println("Закрываем URL_ADOBE_COM");
        driver.close();
        SleepUtils.sleep(2000);
        System.out.println(driver.getWindowHandles());
        System.out.println();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if ("Visual Studio: IDE and Code Editor for Software Developers and Teams".equalsIgnoreCase(
                driver.getTitle())) {
                break;
            }
        }

        System.out.println("Открываем URL_MVN_COM");
        driver = driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(URL_MVN_COM);
        SleepUtils.sleep(3000);
        System.out.println(driver.getWindowHandles());
        System.out.println();
    }
}
