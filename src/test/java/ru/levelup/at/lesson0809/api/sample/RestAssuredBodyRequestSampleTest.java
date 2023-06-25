package ru.levelup.at.lesson0809.api.sample;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;
import static org.hamcrest.Matchers.*;

public class RestAssuredBodyRequestSampleTest {

    public static final String BASE_URI = "https://gorest.co.in";
    public static final String BASE_PATH = "/public/v2";
    public static final String COMMENTS_ENDPOINT = "/comments";

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .setAuth(oauth2("603239379fb1f8944df90ac711c1035bb62329e7629ef72319c317e1096ac188"))
            .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    public void bodyStringTest() {
        ValidatableResponse response = given()
            .log().all()
            .baseUri(BASE_URI)
            .when()
            .get(COMMENTS_ENDPOINT)
            .then()
            .log().everything()
            .statusCode(HttpStatus.SC_OK);
        JsonPath jsonPath = response.extract().response().jsonPath();
        System.out.println(response);

        //        Comment expectedComment =
        //            new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"), jsonPath.get("[0].name"),
        //                jsonPath.get("[0].email"), jsonPath.get("[0].body"));

        Faker faker = new Faker();
        Comment expectedComment =
            new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"),
                faker.name().firstName() + faker.name().lastName(),
                faker.internet().emailAddress(), faker.lorem().sentence(7));

        given()
            .body("{\n"
                + "  \"post_id\": \"" + expectedComment.postId + "\",\n"
                + "  \"name\": \"" + expectedComment.name + "\",\n"
                + "  \"email\": \"" + expectedComment.email + "\",\n"
                + "  \"body\": \"" + expectedComment.body + "\"\n"
                + "}")
            .log().all()
            .baseUri(BASE_URI)
            .when()
            .post(COMMENTS_ENDPOINT)
            .then()
            .log().everything()
            .statusCode(HttpStatus.SC_CREATED)
            .body("", not(empty()))
            .body("", equalToObject(Map.of(
                "post_id", expectedComment.postId,
                "name", expectedComment.name,
                "email", expectedComment.email,
                "body", expectedComment.body,
                "id", expectedComment.id + 1)));
    }
}
