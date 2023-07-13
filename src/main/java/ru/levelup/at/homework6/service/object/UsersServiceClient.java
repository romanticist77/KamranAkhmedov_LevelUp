package ru.levelup.at.homework6.service.object;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.Collections;
import java.util.Map;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsRequest;
import ru.levelup.at.homework6.pojo.model.users.CreateUsersRequest;

public class UsersServiceClient {

    public static final String USERS_ENDPOINT = "/users";
    public static final String USERS_USERID = USERS_ENDPOINT + "/{userId}";

    public Response createUser(final CreateUsersRequest requestBody) {
        return given()
            .body(requestBody)
            .when()
            .post(USERS_ENDPOINT)
            .andReturn();
    }

    public Response fullyUpdateUser(final int userId, final CreateUsersRequest requestBody) {
        return given()
            .pathParams("userId", userId)
            .body(requestBody)
            .when()
            .put(USERS_USERID)
            .andReturn();
    }

    public Response getUser() {
        return getUser(Collections.EMPTY_MAP);
    }

    public Response getUser(final Map<String, Object> queryParams) {
        return given()
            .queryParams(queryParams)
            .when()
            .get(USERS_ENDPOINT)
            .andReturn();
    }

    public Response deleteUser(int id) {

        return given()
            .pathParam("userId", id)
            .when()
            .delete(USERS_USERID);
    }
}
