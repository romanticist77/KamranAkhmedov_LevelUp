package ru.levelup.at.homework6.pojo.model.posts;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;

public class DeletePostsTest extends BaseApiTest {

    @Test
    public void deleteRequestTest() {
        var id = 50008;

        var actualResponse = postsServiceClient.deletePost(id)
                                               .then()
                                               .statusCode(HttpStatus.SC_NO_CONTENT)
                                               .extract()
                                               .asPrettyString();

        assertThat(actualResponse)
            .as("Не удалось удалить объект, не найден нужный комментарий")
            .isEmpty();
    }
}



