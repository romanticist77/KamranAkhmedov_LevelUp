package ru.levelup.at.homework6.pojo.model.posts;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import java.lang.reflect.Array;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.homework6.pojo.model.BaseApiTest;
import ru.levelup.at.homework6.pojo.model.comments.CreateCommentsRequest;
import ru.levelup.at.homework6.pojo.model.comments.CreateCommentsResponse;

public class GetPostsTest extends BaseApiTest {

    @Test(dataProvider = "GET data provider")
    public void getRequestTest(int userId, String title, String body) {

        var expectedResponse = CreatePostsResponse.from(new CreatePostsRequest(userId, title, body));

        var actualResponse = postsServiceClient.getPost(Map.of(
                                                   "userId", userId,
                                                   "title", title,
                                                   "body", body
                                               ))
                                               .then()
                                               .statusCode(HttpStatus.SC_OK)
                                               .extract()
                                               .as(CreatePostsResponse.class.arrayType());

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

        var actualResponse = postsServiceClient.getPost()
                                               .then()
                                               .statusCode(HttpStatus.SC_OK)
                                               .extract()
                                               .as(CreatePostsResponse.class.arrayType());

        assertThat(Array.get(actualResponse, 0))
            .as("Не удалось получить объект")
            .isNotNull();
        assertThat(Array.get(actualResponse, 0))
            .usingRecursiveComparison()
            .isInstanceOf(CreatePostsResponse.class);
    }

    @DataProvider(name = "GET data provider")
    public static Object[][] postsDataProvider() {
        return new Object[][] {
            {3498582, "Cito utrimque color acceptus eveniet sunt tondeo.",
                "Cribro pecunia cimentarius. Beatus quibusdam adfero. Iure decipio theatrum."
                    + " Demens vereor patrocinor. Vere calamitas caste. Curia aegrotatio atavus."
                    + " Viduata coniecto sufficio. Vel adaugeo terra. Agnitio vitium est. Auctor "
                    + "tandem viriliter. Curiositas crepusculum vomer."},
            {3498581, "Adsidue aut tolero dolor tibi adamo et et consequatur.",
                "Aro suffoco cattus. Volo comis curto. Demergo adultus strues. Amet angustus tremo. Cultura aut careo."
                    + " Aro ipsa aurum. Suffragium comprehendo comburo. Quos terra tamquam. Tergum cubo degusto. "
                    + "Abutor dolorum uter. Cuppedia angustus iure. Traho vinco clam. Tenetur autem tener. "
                    + "Laborum adfero demum. Degero dignissimos crux. Culpa arcus angustus. Vigilo capitulus caveo."},
            {
                3498580, "Avarus aptus ventito bene laborum pel.",
                "Et vehemens alter. Aliquam aequus aperiam. Vestigium xiphias thymum. Officiis amiculum certo. "
                    + "Annus voluptatem nam. Cornu delicate dolorem. Thermae ducimus comes. Ulterius absorbeo modi. "
                    + "Canis vis comminor. Tibi recusandae vacuus. Et terra ocer. Derideo uter velum. Ambitus ut "
                    + "callide. Advenio thermae conscendo. Accusator creber inflammatio. Trucido quis certo. Tibi "
                    + "surgo suppono."}
        };
    }
}
