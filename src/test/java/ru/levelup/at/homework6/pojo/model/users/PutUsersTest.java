package ru.levelup.at.homework6.pojo.model.users;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsRequest;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsResponse;

public class PutUsersTest extends BaseApiTest {

    @Test(dataProvider = "PUT data provider")
    public void putRequestTest(int id, String name, String email, String gender, String status) {
        var requestBody = createRequestBody(name, email, gender, status);
        var expectedResponse = CreateUsersResponse.from(requestBody);

        var actualResponse = usersServiceClient.fullyUpdateUser(id, requestBody)
                                               .then()
                                               .statusCode(HttpStatus.SC_OK)
                                               .extract()
                                               .as(CreateUsersResponse.class);

        assertThat(actualResponse.getId())
            .as("Не удалось обновить объект, поле id пустое")
            .isNotNull()
            .isEqualTo(Integer.valueOf(id));
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expectedResponse);
    }

    @DataProvider(name = "PUT data provider")
    public static Object[][] postsDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {3571521, faker.funnyName().name(), faker.internet().emailAddress(), MALE, INACTIVE},
            {3571518, faker.funnyName().name(), faker.internet().emailAddress(), MALE, INACTIVE},
            {3571516, faker.funnyName().name(), faker.internet().emailAddress(), MALE, INACTIVE}
        };
    }

    private CreateUsersRequest createRequestBody(String name, String email, String gender, String status) {

        return CreateUsersRequest.builder()
                                 .name(name)
                                 .email(email)
                                 .gender(gender)
                                 .status(status)
                                 .build();
    }
}
