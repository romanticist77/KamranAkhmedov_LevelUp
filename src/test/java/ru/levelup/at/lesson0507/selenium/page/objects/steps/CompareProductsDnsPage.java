package selenium.page.objects.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;

public class CompareProductsDnsPage extends DnsBasePage {
    public CompareProductsDnsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Метод не имплементирован");
    }

    public List<String> getTitles() {
        return wait.until(
                       ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='products-slider__product-name']"),
                           10))
                   .stream()
                   .map(WebElement::getText)
                   .collect(Collectors.toList());
    }
}
