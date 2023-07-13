package ru.levelup.at.homework6.pojo.model.posts;

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
public class CreatePostsResponse {

    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    private String title;
    private String body;

    public static CreatePostsResponse from(CreatePostsRequest request) {
        return CreatePostsResponse
            .builder()
            .userId(request.getUserId())
            .title(request.getTitle())
            .body(request.getBody())
            .build();
    }
}
