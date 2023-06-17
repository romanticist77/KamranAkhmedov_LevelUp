package selenium.page.objects.steps;

import org.openqa.selenium.WebDriver;

public class DnsMainPage extends DnsBasePage {


    public DnsMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("/");
    }


}
