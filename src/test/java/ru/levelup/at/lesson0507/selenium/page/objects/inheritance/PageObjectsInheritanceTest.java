package ru.levelup.at.lesson0507.selenium.page.objects.inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.levelup.at.lesson0507.selenium.BaseSeleniumTest;

public class PageObjectsInheritanceTest extends BaseSeleniumTest {

    @Test
    public void registerUserTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().emailAddress();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.fillLoginField(login);
        registrationPage.fillPasswordField(password);
        registrationPage.fillEmailField(email);
        registrationPage.clickRegisterButton();

        var mainPage = new UserBugRedMainPage(driver);
        String actualUserName = mainPage.getUserNameText();
        assertThat(actualUserName).isEqualToIgnoringCase(login);
    }

    @Test
    public void negativeRegisterUserTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().domainSuffix();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.fillLoginField(login);
        registrationPage.fillPasswordField(password);
        registrationPage.fillEmailField(email);
        registrationPage.clickRegisterButton();

        String actualUserName = registrationPage.getErrorMessageLabelText();
        assertThat(actualUserName).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
