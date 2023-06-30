package ru.levelup.at.lesson0809.api.pojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
@Builder
public class CreateCommentResponse {

    private Integer id;
    @JsonProperty("post_id")
    private String postId;
    private String name;
    private String email;
    private String body;

    public static CreateCommentResponse from(CreateCommentRequest request) {
        return CreateCommentResponse
            .builder()
            .postId(request.getPostId())
            .name(request.getName())
            .email(request.getEmail())
            .body(request.getBody())
            .build();
    }
}
