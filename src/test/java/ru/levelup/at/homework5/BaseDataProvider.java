package ru.levelup.at.homework5;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import ru.levelup.at.homework4.UtilCreds;

public class BaseDataProvider extends SeleniumBaseTest {

    private static final Faker faker = new Faker();

    @DataProvider(name = "Email data provider")
    public static Object[][] emailDataProvider() {
        return new Object[][] {
            {UtilCreds.username, faker.internet().uuid(), faker.lorem().sentence()}
        };
    }


}
