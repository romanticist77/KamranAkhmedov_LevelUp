package ru.levelup.at.homework6.pojo.model.comments;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;

public class PutCommentsTest extends BaseApiTest {

    @Test(dataProvider = "PUT data provider")
    public void putRequestTest(String id, String postId, String name, String email, String body) {
        var requestBody = createRequestBody(postId, name, email, body);
        var expectedResponse = CreateCommentsResponse.from(requestBody);

        var actualResponse = commentsServiceClient.fullyUpdateComment(id, requestBody)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(CreateCommentsResponse.class);

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
    public static Object[][] commentsDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {String.valueOf(44625), String.valueOf(50026), faker.funnyName().name(), faker.internet().emailAddress(),
                faker.lorem().sentence(7)},
            {String.valueOf(44624), String.valueOf(50025), faker.funnyName().name(), faker.internet().emailAddress(),
                faker.lorem().sentence(7)},
            {String.valueOf(44623), String.valueOf(50025), faker.funnyName().name(), faker.internet().emailAddress(),
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
