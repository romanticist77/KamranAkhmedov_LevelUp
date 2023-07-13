package ru.levelup.at.homework6.service.object;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.Collections;
import java.util.Map;
import ru.levelup.at.homework6.pojo.model.posts.CreatePostsRequest;

public class PostsServiceClient {

    public static final String POSTS_ENDPOINT = "/posts";
    public static final String POSTS_POSTID = POSTS_ENDPOINT + "/{postId}";

    public Response createPost(final CreatePostsRequest requestBody) {
        return given()
            .body(requestBody)
            .when()
            .post(POSTS_ENDPOINT)
            .andReturn();
    }

    public Response fullyUpdatePost(final int commentId, final CreatePostsRequest requestBody) {
        return given()
            .pathParams("postId", commentId)
            .body(requestBody)
            .when()
            .put(POSTS_POSTID)
            .andReturn();
    }

    public Response getPost() {
        return getPost(Collections.EMPTY_MAP);
    }

    public Response getPost(final Map<String, Object> queryParams) {
        return given()
            .queryParams(queryParams)
            .when()
            .get(POSTS_ENDPOINT)
            .andReturn();
    }

    public Response deletePost(int id) {

        return given()
            .pathParam("postId", id)
            .when()
            .delete(POSTS_POSTID);
    }
}
