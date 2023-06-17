package ru.levelup.at.lesson0507.selenium.step.design.pattern.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.lesson0507.selenium.BaseSeleniumTest;
import ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.CommonDnsSteps;
import ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.CompareProductsDnsPageSteps;
import ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.SearchResultDnsPageSteps;

public class DnsCompareProductsTests extends BaseSeleniumTest {

    public static final String DNS_URL = "";

    private CommonDnsSteps commonDnsSteps;
    private SearchResultDnsPageSteps searchResultPageSteps;
    private CompareProductsDnsPageSteps compareProductsPageSteps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        commonDnsSteps = new CommonDnsSteps(driver);
        searchResultPageSteps = new SearchResultDnsPageSteps(driver);
        compareProductsPageSteps = new CompareProductsDnsPageSteps(driver);
    }

    @Test
    public void addToCompareTest() {



        // 1. Открываем страницу DNS магазина
        commonDnsSteps.openWebsite();

        // 2. Ищем товар
        commonDnsSteps.searchProduct("Keychron");

        // 3. Добавляем товары к сравнению
        var addedProducts = searchResultPageSteps.addToCompareProducts(1,2,3);

        // 4. Проверка добавления продуктов
        compareProductsPageSteps.assertThatCompareProductShouldBeAddedToCompareList(addedProducts);

    }



}
