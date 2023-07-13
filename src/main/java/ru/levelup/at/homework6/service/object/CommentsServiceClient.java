package ru.levelup.at.homework6.service.object;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.Collections;
import java.util.Map;
import ru.levelup.at.homework6.pojo.model.comments.CreateCommentsRequest;

public class CommentsServiceClient {

    public static final String COMMENTS_ENDPOINT = "/comments";
    public static final String COMMENTS_COMMENTID = COMMENTS_ENDPOINT + "/{commentId}";

    public Response createComment(final CreateCommentsRequest requestBody) {
        return given()
            .body(requestBody)
            .when()
            .post(COMMENTS_ENDPOINT)
            .andReturn();
    }

    public Response fullyUpdateComment(final String commentId, final CreateCommentsRequest requestBody) {
        return given()
            .pathParams("commentId", commentId)
            .body(requestBody)
            .when()
            .put(COMMENTS_COMMENTID)
            .andReturn();
    }

    public Response getComment() {
        return getComment(Collections.EMPTY_MAP);
    }

    public Response getComment(final Map<String, Object> queryParams) {
        return given()
            .queryParams(queryParams)
            .when()
            .get(COMMENTS_ENDPOINT)
            .andReturn();
    }

    public Response deleteComment(int id) {

        return given()
            .pathParam("commentId", id)
            .when()
            .delete(COMMENTS_COMMENTID);
    }
}
