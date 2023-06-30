package api.pojo.model;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.levelup.at.lesson0809.api.pojo.model.CreateCommentRequest;
import ru.levelup.at.lesson0809.api.pojo.model.CreateCommentResponse;
import ru.levelup.at.lesson0809.api.sample.Comment;

import java.util.Map;

import static dk.brics.automaton.StringUnionOperations.build;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.not;

public class RestAssuredObjectTest {

    public static final String BASE_URI = "https://gorest.co.in";
    public static final String BASE_PATH = "/public/v2";
    public static final String COMMENTS_ENDPOINT = "/comments";

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
                                                                   .log(LogDetail.ALL)
                                                                   .setAuth(oauth2("603239379fb1f8944df90ac711c1035bb62"
                                                                       + "329e7629ef72319c317e1096ac188"))
                                                                   .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().log(LogDetail.ALL)
                                                                     .build();
    }

    @Test
    public void pojoTest() {
        var requestBody = createRequestBody();
        var expectedResponse = CreateCommentResponse.from(requestBody);

        var actualResponse = given()
            .body(requestBody)
            .when()
            .post(COMMENTS_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreateCommentResponse.class);

        assertThat(actualResponse.getId())
            .as("Не удалось создать объект, поле id пустое")
            .isNotNull();
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expectedResponse);
    }

    private CreateCommentRequest createRequestBody() {
        final var faker = new Faker();
        return CreateCommentRequest.builder()
                                   .postId(String.valueOf(48583))
                                   .name("Kandis Carroll")
                                   .email("lakiesha.kunde@yahoo.com")
                                   .body("Ut cumque quo necessitatibus quaerat aut quis reprehenderit earum et cumque.")
                                   .build();
    }
}
