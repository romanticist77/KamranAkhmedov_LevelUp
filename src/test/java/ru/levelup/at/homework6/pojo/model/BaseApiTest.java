package ru.levelup.at.homework6.pojo.model;

import static io.restassured.RestAssured.oauth2;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import ru.levelup.at.homework6.service.object.CommentsServiceClient;
import ru.levelup.at.homework6.service.object.PostsServiceClient;
import ru.levelup.at.homework6.service.object.UsersServiceClient;

public class BaseApiTest {

    public static final String BASE_URI = "https://gorest.co.in";
    public static final String BASE_PATH = "/public/v2";
    protected CommentsServiceClient commentsServiceClient;
    protected PostsServiceClient postsServiceClient;
    protected UsersServiceClient usersServiceClient;

    public static final String MALE = "male";
    public static final String FEMALE = "female";
    public static final String ACTIVE = "active";
    public static final String INACTIVE = "inactive";

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
        commentsServiceClient = new CommentsServiceClient();
        postsServiceClient = new PostsServiceClient();
        usersServiceClient = new UsersServiceClient();
    }
}
