package ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.steps.DnsMainPage;

public class CommonDnsSteps {

    private final DnsMainPage mainPage;

    public CommonDnsSteps(final WebDriver driver) {
        mainPage = new DnsMainPage(driver);
    }

    public void openWebsite() {
        mainPage.open();
    }

    public void searchProduct(final String searchText) {
        mainPage.searchProduct(searchText);
    }
}
