package ru.levelup.at.lesson1011.cicd.allure;

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
import io.qameta.allure.TmsLinks;
import java.util.List;
import org.testng.annotations.Test;
import ru.levelup.at.lesson1011.cicd.allure.annotations.AutomatedBy;
import ru.levelup.at.lesson1011.cicd.allure.annotations.Priority;
import ru.levelup.at.lesson1011.cicd.allure.dictionary.PriorityLevel;
import ru.levelup.at.lesson1011.cicd.allure.pages.UserBugRedLoginRegistrationPage;

@Issues({@Issue("LUP-123"), @Issue("LUP-1234")})
@Owner("k.akhmedov")
@AutomatedBy("k.akhmedov")
@Epic("Регистрация")
@Story("Падающая регистрация")
@Priority(PriorityLevel.LOW)
public class AllureReporterFailV2Test extends BaseSeleniumTest {

    @Test(description = "Успешная регистрация пользователя (падающий)")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLinks({@TmsLink("LUP-123"), @TmsLink("LUP-1234")})
    @Description("Что-то мы тестируем да не вытестируем")
    @Feature("Правильная регистрация")
    public void registerUserTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().emailAddress();

        var mainPage = new UserBugRedLoginRegistrationPage(driver);
        mainPage.open();
        mainPage.fillLoginField(login);
        mainPage.fillPasswordField(password);
        mainPage.fillEmailField(email);
        mainPage.clickRegisterButton();

        var doub = 1 / 0;
    }

    @Test(description = "Пользователь не может зарегистрироваться с неправильной почтой (падающий)")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("LUP-1234")
    @Description("Что-то мы тестируем да не вытестируем")
    @Feature("Неправильная регистрация")
    public void negativeRegistrationTest() {

        var login = faker.funnyName().name();
        var password = faker.internet().password();
        var email = faker.internet().domainSuffix();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);
        registrationPage.open();
        registrationPage.fillLoginField(login);
        registrationPage.fillPasswordField(password);
        registrationPage.fillEmailField(email);
        registrationPage.clickRegisterButton();

        var list = List.of("One, two, three");
        var elem = list.get(4);
    }
}
