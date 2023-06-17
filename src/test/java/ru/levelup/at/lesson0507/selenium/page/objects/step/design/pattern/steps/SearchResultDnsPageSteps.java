package ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.steps.SearchResultDnsPage;

public class SearchResultDnsPageSteps {

    private SearchResultDnsPage searchResultPage;

    public SearchResultDnsPageSteps(final WebDriver driver) {
        searchResultPage = new SearchResultDnsPage(driver);
    }

    public List<String> addToCompareProducts(int... productNumbers) {
        var productTitles = Arrays.stream(productNumbers)
                                  .mapToObj(number -> searchResultPage.getProductCard(number))
                                  .map(product -> {
                                      product.clickCompareButton();
                                      return product.getTitle();
                                  })
                                  .collect(Collectors.toList());

        searchResultPage.clickCompareButton();
        return productTitles;
    }
}
