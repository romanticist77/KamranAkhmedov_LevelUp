package ru.levelup.at.lesson0507.selenium.page.objects.component;

import org.testng.annotations.Test;
import ru.levelup.at.lesson0507.selenium.BaseSeleniumTest;

import static org.assertj.core.api.Assertions.assertThat;

public class PageObjectsComponentTest extends BaseSeleniumTest {

    @Test
    public void registerUserTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().emailAddress();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.registration().fillLoginField(login);
        registrationPage.registration().fillPasswordField(password);
        registrationPage.registration().fillEmailField(email);
        registrationPage.registration().clickRegisterButton();
        registrationPage.menu().menuClick("Компании");

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
        registrationPage.registration().fillLoginField(login);
        registrationPage.registration().fillPasswordField(password);
        registrationPage.registration().fillEmailField(email);
        registrationPage.registration().clickRegisterButton();

        String actualUserName = registrationPage.registration().getErrorMessageLabelText();
        assertThat(actualUserName).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
