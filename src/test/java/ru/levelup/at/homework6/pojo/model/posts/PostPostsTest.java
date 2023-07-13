package ru.levelup.at.homework6.pojo.model.posts;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;
import ru.levelup.at.homework6.pojo.model.comments.CreateCommentsRequest;
import ru.levelup.at.homework6.pojo.model.comments.CreateCommentsResponse;

public class PostPostsTest extends BaseApiTest {

    @Test(dataProvider = "POST data provider")
    public void postRequestTest(int userId, String title, String body) {
        var requestBody = createRequestBody(userId, title, body);
        var expectedResponse = CreatePostsResponse.from(requestBody);

        var actualResponse = postsServiceClient.createPost(requestBody)
                                               .then()
                                               .statusCode(HttpStatus.SC_CREATED)
                                               .extract()
                                               .as(CreatePostsResponse.class);

        assertThat(actualResponse.getId())
            .as("Не удалось создать объект, поле id пустое")
            .isNotNull();
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expectedResponse);
    }

    @DataProvider(name = "POST data provider")
    public static Object[][] postsDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {3498582, faker.lorem().sentence(7), faker.lorem().sentence(7)},
            {3498581, faker.lorem().sentence(7), faker.lorem().sentence(7)},
            {3498580, faker.lorem().sentence(7), faker.lorem().sentence(7)}
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
