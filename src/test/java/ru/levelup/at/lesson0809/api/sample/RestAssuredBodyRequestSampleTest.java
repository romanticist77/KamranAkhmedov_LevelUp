package api.sample;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.lesson0809.api.sample.Comment;

public class RestAssuredBodyRequestSampleTest {

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
    public void bodyStringTest() {
        ValidatableResponse response =
            given()
                .log()
                .all()
                .baseUri(BASE_URI)
                .when()
                .get(COMMENTS_ENDPOINT)
                .then()
                .log()
                .everything()
                .statusCode(HttpStatus.SC_OK);

        io.restassured.path.json.JsonPath jsonPath = response.extract().response().jsonPath();
        System.out.println(response);

        Faker faker = new Faker();
        Comment expectedComment = new Comment(
            jsonPath.get("[0].id"),
            jsonPath.get("[0].post_id"),
            faker.name().firstName() + faker.name().lastName(),

            faker.internet().emailAddress(),
            faker.lorem().sentence(7));

        given().body(
                   "{\n"
                       + "  \"post_id\": \"" + expectedComment.postId
                       + "\",\n" + "  \"name\": \"" + expectedComment.name
                       + "\",\n" + "  \"email\": \"" + expectedComment.email
                       + "\",\n" + "  \"body\": \"" + expectedComment.body
                       + "\"\n"
                       + "}")
               .log().all().baseUri(BASE_URI).when().post(COMMENTS_ENDPOINT)
               .then().log().everything().statusCode(HttpStatus.SC_CREATED).body("", not(empty())).body("",
                   equalToObject(
                       Map.of("post_id", expectedComment.postId,
                           "name", expectedComment.name,
                           "email", expectedComment.email,
                           "body", expectedComment.body,
                           "id", expectedComment.id + 1)));
    }

    @Test
    public void bodyFileTest() {
        ValidatableResponse response =
            given().log().all().baseUri(BASE_URI).when().get(COMMENTS_ENDPOINT).then().log().everything()
                   .statusCode(HttpStatus.SC_OK);
        io.restassured.path.json.JsonPath jsonPath = response.extract().response().jsonPath();
        System.out.println(response);

        Faker faker = new Faker();
        Comment expectedComment = new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"),
            faker.name().firstName() + faker.name().lastName(), faker.internet().emailAddress(),
            faker.lorem().sentence(7));

        var bodyRequest = "";
        try {
            bodyRequest = FileUtils.readFileToString(
                                       new File(Objects.requireNonNull(
                                                           this.getClass()
                                                               .getResource(
                                                                   "/ru/levelup/at/lesson0809/api/sample"
                                                                       + "/file/create_comment_request.json"))
                                                       .getPath()),
                                       StandardCharsets.UTF_8)
                                   .replace("<postId>", String.valueOf(expectedComment.postId))
                                   .replace("<name>", expectedComment.name)
                                   .replace("<email>", expectedComment.email)
                                   .replace("<body>", expectedComment.body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .log()
            .all()
            .baseUri(BASE_URI)
            .when()
            .post(COMMENTS_ENDPOINT)
            .then()
            .log()
            .everything()
            .statusCode(HttpStatus.SC_CREATED)
            .body("", not(empty()))
            .body("", hasEntry("post_id", expectedComment.postId))
            .body("", hasEntry("name", expectedComment.name))
            .body("", hasEntry("email", expectedComment.email))
            .body("", hasEntry("body", expectedComment.body));
    }

    @Test
    public void bodyJSONpathTest() {

        ValidatableResponse response =
            given()
                .log()
                .all()
                .baseUri(BASE_URI)
                .when().get(COMMENTS_ENDPOINT)
                .then()
                .log()
                .everything()
                .statusCode(HttpStatus.SC_OK);
        io.restassured.path.json.JsonPath jsonPath = response
            .extract()
            .response()
            .jsonPath();
        System.out.println(response);

        Faker faker = new Faker();
        Comment expectedComment = new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"),
            faker.name().firstName() + faker.name().lastName(), faker.internet().emailAddress(),
            faker.lorem().sentence(7));

        var bodyRequest = "";
        try {
            bodyRequest = JsonPath.parse(new File(Objects.requireNonNull(
                                                             this.getClass().getResource(
                                                                 "/ru/levelup/at/lesson0809/api/sample"
                                                                     + "/jsonpath/create_comment_request.json"))
                                                         .getPath()))
                                  .set("post_id", String.valueOf(expectedComment.postId))
                                  .set("name", String.valueOf(expectedComment.name))
                                  .set("email", String.valueOf(expectedComment.email))
                                  .set("body", String.valueOf(expectedComment.body))
                                  .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .log()
            .all()
            .baseUri(BASE_URI)
            .when()
            .post(COMMENTS_ENDPOINT)
            .then()
            .log()
            .everything()
            .statusCode(HttpStatus.SC_CREATED)
            .body("", not(empty()))
            .body("", hasEntry("post_id", expectedComment.postId))
            .body("", hasEntry("name", expectedComment.name))
            .body("", hasEntry("email", expectedComment.email))
            .body("", hasEntry("body", expectedComment.body));
    }

    @Test
    public void bodyJSONpathDeleteTest() {

        ValidatableResponse response =
            given()
                .log()
                .all()
                .baseUri(BASE_URI)
                .when().get(COMMENTS_ENDPOINT)
                .then()
                .log()
                .everything()
                .statusCode(HttpStatus.SC_OK);
        io.restassured.path.json.JsonPath jsonPath = response
            .extract()
            .response()
            .jsonPath();
        System.out.println();
        System.out.println("getResource: " + Objects.requireNonNull(
            this.getClass()
                .getResource(
                    "/ru/levelup/at/lesson0809/api/sample/jsonpath/create_comment_request.json")));
        System.out.println("getPath: " + Objects.requireNonNull(
                                                    this.getClass()
                                                        .getResource(
                                                            "/ru/levelup/at/lesson0809/api/sample"
                                                                + "/jsonpath/create_comment_request.json"))
                                                .getPath());
        System.out.println();

        Faker faker = new Faker();
        Comment expectedComment = new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"),
            faker.name().firstName() + faker.name().lastName(), faker.internet().emailAddress(),
            faker.lorem().sentence(7));

        var bodyRequest = "";
        try {
            bodyRequest = JsonPath.parse(new File(
                                      Objects.requireNonNull(
                                                 this.getClass()
                                                     .getResource(
                                                         "/ru/levelup/at/lesson0809/api/sample/jsonpath"
                                                             + "/create_comment_request.json"))
                                             .getPath()))
                                  .set("post_id", String.valueOf(expectedComment.postId))
                                  .set("name", String.valueOf(expectedComment.name))
                                  .set("email", String.valueOf(expectedComment.email))
                                  .set("body", String.valueOf(expectedComment.body))
                                  .delete("id")
                                  .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .log()
            .all()
            .baseUri(BASE_URI)
            .when()
            .post(COMMENTS_ENDPOINT)
            .then()
            .log()
            .everything()
            .statusCode(HttpStatus.SC_CREATED)
            .body("", not(empty()))
            .body("", hasEntry("post_id", expectedComment.postId))
            .body("", hasEntry("name", expectedComment.name))
            .body("", hasEntry("email", expectedComment.email))
            .body("", hasEntry("body", expectedComment.body));
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {"post_id"},
            {"name"},
            {"email"},
            {"body"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void bodyJSONpathDeleteDataProviderTest(String fieldpath) {

        ValidatableResponse response =
            given()
                .log()
                .all()
                .baseUri(BASE_URI)
                .when().get(COMMENTS_ENDPOINT)
                .then()
                .log()
                .everything()
                .statusCode(HttpStatus.SC_OK);
        io.restassured.path.json.JsonPath jsonPath = response
            .extract()
            .response()
            .jsonPath();
        System.out.println();
        System.out.println("getResource: " + Objects.requireNonNull(
            this.getClass()
                .getResource(
                    "/ru/levelup/at/lesson0809/api/sample/jsonpath/create_comment_request.json")));
        System.out.println("getPath: " + Objects.requireNonNull(
                                                    this.getClass()
                                                        .getResource(
                                                            "/ru/levelup/at/lesson0809/api/sample"
                                                                + "/jsonpath/create_comment_request.json"))
                                                .getPath());
        System.out.println();

        Faker faker = new Faker();
        Comment expectedComment = new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"),
            faker.name().firstName() + faker.name().lastName(), faker.internet().emailAddress(),
            faker.lorem().sentence(7));

        var bodyRequest = "";
        try {
            bodyRequest = JsonPath.parse(new File(
                                      Objects.requireNonNull(
                                                 this.getClass()
                                                     .getResource(
                                                         "/ru/levelup/at/lesson0809/api/sample"
                                                             + "/jsonpath/create_comment_request.json"))
                                             .getPath()))
                                  .set("post_id", String.valueOf(expectedComment.postId))
                                  .set("name", String.valueOf(expectedComment.name))
                                  .set("email", String.valueOf(expectedComment.email))
                                  .set("body", String.valueOf(expectedComment.body))
                                  .delete(fieldpath)
                                  .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .log()
            .all()
            .baseUri(BASE_URI)
            .when()
            .post(COMMENTS_ENDPOINT)
            .then()
            .log()
            .everything()
            .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
            .body("", not(empty()))
            .body("[0]", hasEntry("field", fieldpath));
    }

    @DataProvider
    public Object[][] nullEmptyDataProvider() {
        return new Object[][] {
            {"post_id", null},
            {"name", null},
            {"email", null},
            {"body", null},
            {"post_id", StringUtils.EMPTY},
            {"name", StringUtils.EMPTY},
            {"email", StringUtils.EMPTY},
            {"body", StringUtils.EMPTY}
        };
    }

    @Test(dataProvider = "nullEmptyDataProvider")
    public void bodyJSONpathDeleteNullEmptyDataProviderTest(String fieldPath, String fieldValue) {

        ValidatableResponse response =
            given()
                .log()
                .all()
                .baseUri(BASE_URI)
                .when().get(COMMENTS_ENDPOINT)
                .then()
                .log()
                .everything()
                .statusCode(HttpStatus.SC_OK);
        io.restassured.path.json.JsonPath jsonPath = response
            .extract()
            .response()
            .jsonPath();
        System.out.println();
        System.out.println("getResource: " + Objects.requireNonNull(
            this.getClass()
                .getResource(
                    "/ru/levelup/at/lesson0809/api/sample/jsonpath/create_comment_request.json")));
        System.out.println("getPath: " + Objects.requireNonNull(
                                                    this.getClass()
                                                        .getResource(
                                                            "/ru/levelup/at/lesson0809/api/sample"
                                                                + "/jsonpath/create_comment_request.json"))
                                                .getPath());
        System.out.println();

        Faker faker = new Faker();
        Comment expectedComment = new Comment(jsonPath.get("[0].id"), jsonPath.get("[0].post_id"),
            faker.name().firstName() + faker.name().lastName(), faker.internet().emailAddress(),
            faker.lorem().sentence(7));

        var bodyRequest = "";
        try {
            bodyRequest = JsonPath.parse(new File(
                                      Objects.requireNonNull(
                                                 this.getClass()
                                                     .getResource(
                                                         "/ru/levelup/at/lesson0809/api/sample"
                                                             + "/jsonpath/create_comment_request.json"))
                                             .getPath()))
                                  .set("post_id", expectedComment.postId)
                                  .set("name", expectedComment.name)
                                  .set("email", expectedComment.email)
                                  .set("body", expectedComment.body)
                                  .set(fieldPath, fieldValue)
                                  .delete("id")
                                  .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .log()
            .all()
            .baseUri(BASE_URI)
            .when()
            .post(COMMENTS_ENDPOINT)
            .then()
            .log()
            .everything()
            .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
            .body("", not(empty()))
            .body("[0]", hasEntry("field", fieldPath));
    }
}
