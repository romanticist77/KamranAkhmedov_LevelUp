package ru.levelup.at.homework6.pojo.model.comments;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;

public class DeleteCommentsTest extends BaseApiTest {

    @Test
    public void deleteRequestTest() {
        var id = 44575;

        var actualResponse = commentsServiceClient.deleteComment(id)
            .then()
            .statusCode(HttpStatus.SC_NO_CONTENT)
            .extract()
            .asPrettyString();

        assertThat(actualResponse)
            .as("Не удалось удалить объект, не найден нужный комментарий")
            .isEmpty();
    }
}



