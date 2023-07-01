package ru.levelup.at.lesson0809.api.service.object;

import io.restassured.response.Response;
import ru.levelup.at.lesson0809.api.pojo.model.CreateCommentRequest;

import static io.restassured.RestAssured.given;

public class CommentServiceClient {

    public static final String COMMENTS_ENDPOINT = "/comments";
    public static final String COMMENTS_COMMENTID = COMMENTS_ENDPOINT + "/{commentId}";

    public Response createComment(final CreateCommentRequest requestBody) {
        return given()
            .body(requestBody)
            .when()
            .post(COMMENTS_ENDPOINT)
            .andReturn();
    }

    public Response fullyUpdateComment(final String commentId, final CreateCommentRequest requestBody) {
        return given()
            .pathParams("commentId", commentId)
            .body(requestBody)
            .when()
            .post(COMMENTS_ENDPOINT)
            .andReturn();
    }
}
