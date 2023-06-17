package ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.steps.component.DnsProductComponent;

public class SearchResultDnsPage extends DnsBasePage {

    public static final String PRODUCTS_LIST_XPATH = "//div[@data-id='product']";

    public SearchResultDnsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Метод не имплементирован");
    }

    public DnsProductComponent getProductCard(final int number) {
        final var index = number - 1;
        var products = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(PRODUCTS_LIST_XPATH),
            3));
        return new DnsProductComponent(driver, products.get(index));
    }


}
