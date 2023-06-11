package ru.levelup.at.lesson0507.selenium.page.objects.types.fluent;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import ru.levelup.at.lesson0507.selenium.BaseSeleniumTest;

public class PageObjectFluentTest extends BaseSeleniumTest {

    @Test
    public void registerUserTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().emailAddress();

        var mainPage = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .fillLoginField(login)
            .fillPasswordField(password)
            .fillEmailField(email)
            .successClickRegisterButton();

        String actualUserName = mainPage.getUserNameText();
        assertThat(actualUserName).isEqualToIgnoringCase(login);
    }

    @Test
    public void negativeRegisterUserTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().domainSuffix();

        String actualUserName = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .fillLoginField(login)
            .fillPasswordField(password)
            .fillEmailField(email)
            .failClickRegisterButton()
            .getErrorMessageLabelText();

        assertThat(actualUserName).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
