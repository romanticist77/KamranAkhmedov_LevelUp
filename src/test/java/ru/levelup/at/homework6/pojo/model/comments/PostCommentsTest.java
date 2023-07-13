package ru.levelup.at.homework6.pojo.model.comments;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;

public class PostCommentsTest extends BaseApiTest {

    @Test(dataProvider = "POST data provider")
    public void postRequestTest(String postId, String name, String email, String body) {
        var requestBody = createRequestBody(postId, name, email, body);
        var expectedResponse = CreateCommentsResponse.from(requestBody);

        var actualResponse = commentsServiceClient.createComment(requestBody)
                                                  .then()
                                                  .statusCode(HttpStatus.SC_CREATED)
                                                  .extract()
                                                  .as(CreateCommentsResponse.class);

        assertThat(actualResponse.getId())
            .as("Не удалось создать объект, поле id пустое")
            .isNotNull();
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expectedResponse);
    }

    @DataProvider(name = "POST data provider")
    public static Object[][] commentsDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {String.valueOf(50521), faker.funnyName().name(), faker.internet().emailAddress(),
                faker.lorem().sentence(7)},
            {String.valueOf(50518), faker.funnyName().name(), faker.internet().emailAddress(),
                faker.lorem().sentence(7)},
            {String.valueOf(50517), faker.funnyName().name(), faker.internet().emailAddress(),
                faker.lorem().sentence(7)}
        };
    }

    private CreateCommentsRequest createRequestBody(String postId, String name, String email, String body) {

        return CreateCommentsRequest.builder()
                                    .postId(postId)
                                    .name(name)
                                    .email(email)
                                    .body(body)
                                    .build();
    }
}
