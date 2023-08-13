package ru.levelup.at.homework6.pojo.model.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
@Builder
public class CreateCommentsResponse {

    private Integer id;
    @JsonProperty("post_id")
    private String postId;
    private String name;
    private String email;
    private String body;

    public static CreateCommentsResponse from(CreateCommentsRequest request) {
        return CreateCommentsResponse
            .builder()
            .postId(request.getPostId())
            .name(request.getName())
            .email(request.getEmail())
            .body(request.getBody())
            .build();
    }
}
