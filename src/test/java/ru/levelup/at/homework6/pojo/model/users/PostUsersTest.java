package ru.levelup.at.homework6.pojo.model.users;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsRequest;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsResponse;

public class PostUsersTest extends BaseApiTest {

    @Test(dataProvider = "POST data provider")
    public void postRequestTest(String name, String email, String gender, String status) {
        var requestBody = createRequestBody(name, email, gender, status);
        var expectedResponse = CreateUsersResponse.from(requestBody);

        var actualResponse = usersServiceClient.createUser(requestBody)
                                               .then()
                                               .statusCode(HttpStatus.SC_CREATED)
                                               .extract()
                                               .as(CreateUsersResponse.class);

        assertThat(actualResponse.getId())
            .as("Не удалось создать объект, поле id пустое")
            .isNotNull();
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expectedResponse);
    }

    @DataProvider(name = "POST data provider")
    public static Object[][] usersDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {faker.funnyName().name(), faker.internet().emailAddress(), MALE, INACTIVE},
            {faker.funnyName().name(), faker.internet().emailAddress(), MALE, INACTIVE},
            {faker.funnyName().name(), faker.internet().emailAddress(), MALE, INACTIVE}
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
