package ru.levelup.at.lesson0809.api.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import java.util.Map;
import java.util.Optional;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class RestAssuredSampleTest {

    public static final String BASE_URI = "https://gorest.co.in/public/v2";
    public static final String COMMENTS_ENDPOINT = "/comments";
    public static final String COMMENT_ENDPOINT = COMMENTS_ENDPOINT + "/{commentId}";

    @Test
    public void getCommentsTest() {
        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URI)
                   .when()
                   .get(COMMENTS_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200);
    }

    @Test
    public void getCommentsBodyAssertionTest() {

        Comment expectedComment = new Comment(41837, 46789, "Sitara Agarwal", "sitara_agarwal@white.example",
            "Est qui doloribus. Et quis est. Eum eligendi suscipit.");

        ValidatableResponse r = RestAssured.given()
                                           .log().all()
                                           .baseUri(BASE_URI)
                                           .when()
                                           .get(COMMENTS_ENDPOINT)
                                           .then()
                                           .log().everything()
                                           .statusCode(200)
                                           .body("", iterableWithSize(10));

        JsonPath jsonPath = r.extract().jsonPath();

        Comment actualResult =
            new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"), jsonPath.get("[0].name"),
                jsonPath.get("[0].email"), jsonPath.get("[0].body"));

        System.out.println(Optional.ofNullable(jsonPath.get("[0]")));
        System.out.println(expectedComment.equals(actualResult));

        assertThat(actualResult).as("Объекты не равны").isEqualTo(expectedComment);
    }

    @Test
    public void getCommentsQueryParamsTest() {

        Comment expectedComment = new Comment(41828, 46781, "Anjushri Saini", "saini_anjushri@sipes.example",
            "Illum quos perspiciatis. Beatae ut excepturi.");

        var postId = expectedComment.postId;
        var name = expectedComment.name;
        var email = expectedComment.email;
        var body = expectedComment.body;

        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URI)
                   .queryParams(Map.of(
                       "post_id", postId,
                       "name", name,
                       "email", email,
                       "body", body))
                   .when()
                   .get(COMMENTS_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200)
                   .body("", hasSize(1))
                   .body("[0]['id']", equalTo(expectedComment.id));
    }

    @Test
    public void getCommentsPathParamsTest() {

        Comment oldComment = new Comment(41827, 46781, "Anjushri Saini", "saini_anjushri@sipes.example",
            "Illum quos perspiciatis. Beatae ut excepturi.");
        Comment expectedComment = new Comment(41827, 46781, "Testrest", "Testrest@test.ru",
            "Testrest");

        final var commentId = oldComment.id;
        JSONObject requestParams = new JSONObject();
        requestParams.put("post_id", expectedComment.postId);
        requestParams.put("name", expectedComment.name);
        requestParams.put("email", expectedComment.email);
        requestParams.put("body", expectedComment.body);

        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URI)
                   .pathParams("commentId", commentId)
                   .body(requestParams)
                   .auth()
                   .oauth2("603239379fb1f8944df90ac711c1035bb62329e7629ef72319c317e1096ac188")
                   .when()
                   .put(COMMENT_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200);

        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URI)
                   .queryParams(Map.of(
                       "id", expectedComment.id,
                       "post_id", expectedComment.postId))
                   .when()
                   .get(COMMENTS_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200)
                   .body("", hasSize(1))
                   .body("[0]['post_id']", is(expectedComment.postId));
    }
}
