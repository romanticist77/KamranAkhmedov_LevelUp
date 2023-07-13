package ru.levelup.at.homework4;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class BaseDataProvider extends SeleniumBaseTest {

    private static final Faker faker = new Faker();

    @DataProvider(name = "Email data provider")
    public static Object[][] emailDataProvider() {
        return new Object[][] {
            {UtilCreds.username, faker.internet().uuid(), faker.lorem().sentence()}
        };
    }


}
