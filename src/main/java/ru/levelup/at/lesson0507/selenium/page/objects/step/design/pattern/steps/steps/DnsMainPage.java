package ru.levelup.at.lesson0507.selenium.page.objects.step.design.pattern.steps.steps;

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
