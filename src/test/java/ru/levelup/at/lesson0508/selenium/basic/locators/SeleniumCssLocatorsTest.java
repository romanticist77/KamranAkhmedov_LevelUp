package ru.levelup.at.lesson0508.selenium.basic.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class SeleniumCssLocatorsTest {

    public static final String URL_WIKI_ORG = "https://ru.wikipedia.org/";

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
    public void idLocatorTest() {
        driver.navigate().to(URL_WIKI_ORG);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.id("searchInput"));                  //DOM
        // var textBox = driver.findElement(By.cssSelector("[id='searchInput']"));  //CSS
        var textBox = driver.findElement(By.cssSelector("#searchInput"));           //CSS
        textBox.sendKeys("Ночь, улица, фонарь");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void classLocatorTest() {
        driver.navigate().to(URL_WIKI_ORG);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.className("vector-search-box-input"));               //DOM
        // var textBox = driver.findElement(By.cssSelector("[class='vector-search-box-input']"));   //CSS
        var textBox = driver.findElement(By.cssSelector(".vector-search-box-input"));               //CSS
        textBox.sendKeys("Александр Блок");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void nameLocatorTest() {
        driver.navigate().to(URL_WIKI_ORG);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.name("search"));                 //DOM
        var textBox = driver.findElement(By.cssSelector("[name='search']"));    //CSS
        textBox.sendKeys("Владимир Маяковский");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagNameLocatorTest() {
        driver.navigate().to(URL_WIKI_ORG);
        SleepUtils.sleep(500);

        // var link = driver.findElements(By.tagName("a"));     //DOM
        var link = driver.findElements(By.cssSelector("a"));    //CSS

        SleepUtils.sleep(3000);
        System.out.println("Links size: " + link.size());
    }

    @Test
    public void otherAttributesLocatorTest() {
        driver.navigate().to(URL_WIKI_ORG);
        SleepUtils.sleep(500);

        var textBox = driver.findElement(By.cssSelector("[placeholder='Искать в Википедии']"));    //CSS
        textBox.sendKeys("Максим Горький");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_ORG);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.cssSelector("div[id='mw-customcollapsible-potd']"));    //CSS
        var button = driver.findElement(By.cssSelector("div#mw-customcollapsible-potd"));       //CSS
        button.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void parentTagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_ORG);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.cssSelector("div[id='main-cur'] > h2.main-header")); //CSS
        var textBox = driver.findElement(By.cssSelector("div#main-cur > h2.main-header"));          //CSS
        System.out.println(textBox.getText());
        SleepUtils.sleep(3000);
    }
}
