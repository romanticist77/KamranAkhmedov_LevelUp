package ru.levelup.at.homework6.pojo.model.posts;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;
import ru.levelup.at.homework6.pojo.model.comments.CreateCommentsRequest;
import ru.levelup.at.homework6.pojo.model.comments.CreateCommentsResponse;

public class PutPostsTest extends BaseApiTest {

    @Test(dataProvider = "PUT data provider")
    public void putRequestTest(int id, int userId, String title, String body) {
        var requestBody = createRequestBody(userId, title, body);
        var expectedResponse = CreatePostsResponse.from(requestBody);

        var actualResponse = postsServiceClient.fullyUpdatePost(id, requestBody)
                                               .then()
                                               .statusCode(HttpStatus.SC_OK)
                                               .extract()
                                               .as(CreatePostsResponse.class);

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
            {50027, 3498582, faker.lorem().sentence(7), faker.lorem().sentence(7)},
            {50026, 3498581, faker.lorem().sentence(7), faker.lorem().sentence(7)},
            {50025, 3498580, faker.lorem().sentence(7), faker.lorem().sentence(7)}
        };
    }

    private CreatePostsRequest createRequestBody(int userId, String title, String body) {

        return CreatePostsRequest.builder()
                                 .userId(userId)
                                 .title(title)
                                 .body(body)
                                 .build();
    }
}
