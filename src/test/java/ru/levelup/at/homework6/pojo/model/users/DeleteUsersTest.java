package ru.levelup.at.homework6.pojo.model.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsRequest;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsResponse;

public class DeleteUsersTest extends BaseApiTest {

    @Test
    public void deleteRequestTest() {
        var id = 3571498;

        var actualResponse = usersServiceClient.deleteUser(id)
                                               .then()
                                               .statusCode(HttpStatus.SC_NO_CONTENT)
                                               .extract()
                                               .asPrettyString();

        assertThat(actualResponse)
            .as("Не удалось удалить объект, не найден нужный комментарий")
            .isEmpty();
    }
}



