package ru.levelup.at.homework6.pojo.model.comments;

import static io.restassured.RestAssured.given;
import static java.util.Collections.EMPTY_MAP;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;

public class GetCommentsTest extends BaseApiTest {

    @Test(dataProvider = "GET data provider")
    public void getRequestTest(String postId, String name, String email, String body) {

        var expectedResponse = CreateCommentsResponse.from(new CreateCommentsRequest(postId, name, email, body));

        var actualResponse = commentsServiceClient.getComment(Map.of(
                                                      "postId", postId,
                                                      "name", name,
                                                      "email", email,
                                                      "body", body
                                                  ))
                                                  .then()
                                                  .statusCode(HttpStatus.SC_OK)
                                                  .extract()
                                                  .as(CreateCommentsResponse.class.arrayType());

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

        var actualResponse = commentsServiceClient.getComment()
                                                  .then()
                                                  .statusCode(HttpStatus.SC_OK)
                                                  .extract()
                                                  .as(CreateCommentsResponse.class.arrayType());

        assertThat(Array.get(actualResponse, 0))
            .as("Не удалось получить объект")
            .isNotNull();
        assertThat(Array.get(actualResponse, 0))
            .usingRecursiveComparison()
            .isInstanceOf(CreateCommentsResponse.class);
    }

    @DataProvider(name = "GET data provider")
    public static Object[][] commentsDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {String.valueOf(50024), "Atreyi Bhattathiri", "bhattathiri_atreyi@kulas.example",
                "Nihil adipisci et."},
            {String.valueOf(50023), "Upendra Desai", "upendra_desai@kerluke.test",
                "Ipsum suscipit vel."},
            {String.valueOf(50023), "Chapal Devar", "chapal_devar@robel.test",
                "Nihil labore quos. Unde eos quam. Voluptatem id beatae."}
        };
    }
}
