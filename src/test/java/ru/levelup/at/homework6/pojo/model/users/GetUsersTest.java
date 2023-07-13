package ru.levelup.at.homework6.pojo.model.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;

public class GetUsersTest extends BaseApiTest {

    @Test(dataProvider = "GET data provider")
    public void getRequestTest(String name, String email, String gender, String status) {

        var expectedResponse = CreateUsersResponse.from(new CreateUsersRequest(name, email, gender, status));

        var actualResponse = usersServiceClient.getUser(Map.of(
                                                   "name", name,
                                                   "email", email,
                                                   "gender", gender,
                                                   "status", status
                                               ))
                                               .then()
                                               .statusCode(HttpStatus.SC_OK)
                                               .extract()
                                               .as(CreateUsersResponse.class.arrayType());

        assertThat(Array.get(actualResponse, 0))
            .as("Не удалось получить объект")
            .isNotNull();
        assertThat(Array.get(actualResponse, 0))
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expectedResponse);
    }

    @Test
    public void getAllRequestTest() {

        var actualResponse = usersServiceClient.getUser()
                                               .then()
                                               .statusCode(HttpStatus.SC_OK)
                                               .extract()
                                               .as(CreateUsersResponse.class.arrayType());

        assertThat(Array.get(actualResponse, 0))
            .as("Не удалось получить объект")
            .isNotNull();
        assertThat(Array.get(actualResponse, 0))
            .usingRecursiveComparison()
            .isInstanceOf(CreateUsersResponse.class);
    }

    @DataProvider(name = "GET data provider")
    public static Object[][] postsDataProvider() {
        return new Object[][] {
            {"Brahmanandam Achari II", "brahmanandam_ii_achari@spencer.example", "male", "inactive"},
            {"Amb. Deepankar Gupta", "gupta_amb_deepankar@mitchell-crooks.test", "male", "inactive"},
            {"Sameer Johar", "johar_sameer@mohr.example", "male", "inactive"}
        };
    }
}
