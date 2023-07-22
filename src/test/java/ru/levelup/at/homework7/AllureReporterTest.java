package ru.levelup.at.lesson1011.cicd.allure;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import ru.levelup.at.lesson1011.cicd.allure.annotations.AutomatedBy;
import ru.levelup.at.lesson1011.cicd.allure.annotations.Priority;
import ru.levelup.at.lesson1011.cicd.allure.dictionary.PriorityLevel;
import ru.levelup.at.lesson1011.cicd.allure.model.UserDTO;
import ru.levelup.at.lesson1011.cicd.allure.pages.UserBugRedLoginRegistrationPage;
import ru.levelup.at.lesson1011.cicd.allure.pages.UserBugRedMainPage;

@Issues({@Issue("LUP-123"), @Issue("LUP-1234")})
@Owner("k.akhmedov")
@AutomatedBy("k.akhmedov")
@Epic("Регистрация")
@Priority(PriorityLevel.HIGH)
public class AllureReporterTest extends BaseSeleniumTest {

    @Test(description = "Успешная регистрация пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("LUP-123456")
    @Description("Что-то мы тестируем да не вытестируем")
    @Story("Успешная регистрация")
    @Feature("Правильные данные")
    public void registerUserTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().emailAddress();

        var mainPage = new UserBugRedLoginRegistrationPage(driver);
        mainPage.open();

        step("Выполняем регистрацию", () -> {
            mainPage.fillLoginField(login);
            mainPage.fillPasswordField(password);
            mainPage.fillEmailField(email);
            mainPage.clickRegisterButton();
        });

        step("Проверка имени зарегистрированного пользователя", () -> {
            String actualAccountText = new UserBugRedMainPage(driver).getUserNameText();
            assertThat(actualAccountText).isEqualToIgnoringCase(login);
        });
    }

    @Test(description = "Пользователь не может зарегистрироваться с неправильной почтой")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("LUP-12345")
    @Description("Что-то мы тестируем да не вытестируем")
    @Story("Успешная регистрация")
    @Feature("Неправильные данные")
    public void negativeRegistrationTest() {

        var testUser = step("Генерируем тестового пользователя",
                () -> new UserDTO(faker.funnyName().name(),
                        faker.internet().password(),
                        faker.internet().domainSuffix()));

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        step("Выполняем регистрацию", () -> {
            registrationPage.fillLoginField(testUser.getLogin());
            registrationPage.fillPasswordField(testUser.getPassword());
            registrationPage.fillEmailField(testUser.getEmail());
            registrationPage.clickRegisterButton();
        });

        step("Проверка ошибки при регистрации", () -> {
            String actualErrorText = registrationPage.getErrorText();
            assertThat(actualErrorText).isEqualToIgnoringCase("register_not_correct_field (email)");
        });
    }
}
