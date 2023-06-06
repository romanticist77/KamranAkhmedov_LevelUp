package ru.levelup.at.lesson0508.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.utils.SleepUtils;

public class SeleniumXpathLocatorsTest {

    private static final String URL_WIKI_RU = "https://ru.wikipedia.org/";
    private static final String URL_WILLIAM_GELL = "https://ru.wikipedia.org/wiki/%D0%93%D0%B5%D0%BB%D0%BB,_%D0%A3%D0%B8%D0%BB%D1%8C%D1%8F%D0%BC";

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
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.id("searchInput"));                    // DOM
        // var textBox = driver.findElement(By.cssSelector("[id='searchInput']"));    // CSS
        // var textBox = driver.findElement(By.cssSelector("#searchInput"));             // CSS
        var textBox = driver.findElement(By.xpath("//*[@id='searchInput']")); // XPath
        textBox.sendKeys("Ночь, улица, фонарь");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void classNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.className("vector-search-box-input"));                  // DOM
        // var textBox = driver.findElement(By.className("[class='vector-search-box-input']"));        // CSS
        // var textBox = driver.findElement(By.cssSelector(".vector-search-box-input"));               // CSS
        var textBox = driver.findElement(By.xpath("//*[@class='vector-search-box-input']"));         //Xpath
        textBox.sendKeys("Александр Блок");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void containsClassNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var button = driver.findElement(By.xpath("//div[contains(@class, 'main-footer-actions')]"));  //Xpath
        button.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void nameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.name("search"));                 // DOM
        // var textBox = driver.findElement(By.cssSelector("[name='search']"));    // CSS
        var textBox = driver.findElement(By.xpath("//*[@name='search']"));    // Xpath
        textBox.sendKeys("Владимир Маяковский");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var links = driver.findElements(By.tagName("a"));            // DOM
        // var links = driver.findElements(By.cssSelector("a"));        // CSS
        var links = driver.findElements(By.xpath("//a")); // Xpath
        SleepUtils.sleep(3000);
        System.out.println("links sise -> " + links.size());
    }

    @Test
    public void otherAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.cssSelector("[placeholder='Искать в Википедии']"));          // CSS
        var textBox = driver.findElement(By.xpath("//*[@placeholder='Искать в Википедии']")); // Xpath
        textBox.sendKeys("Александр Пушкин");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.cssSelector("div[class='main-footer-menu']"));
        // var button = driver.findElement(By.cssSelector("div.main-footer-menu"));
        var button = driver.findElement(By.xpath("//p[@class='main-top-articleCount']"));  // XPath
        System.out.println("Text: " + button.getText());
        SleepUtils.sleep(3000);
    }

    @Test
    public void parentTagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        //var button = driver.findElement(By
        //    .cssSelector("a[title='Гелл, Уильям'] > span.mw-ui-button")); //CSS
        var button = driver.findElement(By
            .xpath("//a[@title='Гелл, Уильям']"
                + "/span[@class='mw-ui-button']")); //XPath
        button.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void linkTextLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var link = driver.findElement(By.linkText("Доверие Александра Македонского к врачу Филиппу"));  //DOM
        var text = driver.findElement(By
            .xpath("//*[text() ='Знаете ли вы?']"));  // XPath
        System.out.println("id: " + text.getAttribute("id"));
        SleepUtils.sleep(3000);
    }

    @Test
    public void partialLinkTextLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var link = driver.findElement(By.partialLinkText("Доверие Александра Македонского"));           //DOM
        var text = driver.findElement(By
            .xpath("//*[contains(text(), 'Знаете ли')]"));  // XPath
        System.out.println("id: " + text.getAttribute("id"));
        SleepUtils.sleep(3000);
    }

    @Test
    public void parentSearchTest() {
        driver.navigate().to(URL_WILLIAM_GELL);
        SleepUtils.sleep(500);

        var link = driver.findElement(By.xpath("//a[text() ='1777']/../../../../../../../h3"));
        System.out.println("Text: " + link.getText());
    }
}
