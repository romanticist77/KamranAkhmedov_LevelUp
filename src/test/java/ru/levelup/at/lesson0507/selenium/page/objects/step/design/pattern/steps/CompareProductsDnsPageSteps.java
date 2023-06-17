package ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.steps.CompareProductsDnsPage;

public class CompareProductsDnsPageSteps {

    private final CompareProductsDnsPage compareProductsPage;

    public CompareProductsDnsPageSteps(final WebDriver driver) {
        compareProductsPage = new CompareProductsDnsPage(driver);
    }

    public void assertThatCompareProductShouldBeAddedToCompareList(List<String> expectedProductTitles) {
        var actualTitles = compareProductsPage.getTitles();
        assertThat(actualTitles)
            .as("Не все продукты отображены на странице")
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
