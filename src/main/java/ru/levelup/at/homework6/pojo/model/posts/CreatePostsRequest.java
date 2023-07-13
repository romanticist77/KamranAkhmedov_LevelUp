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
public class CreatePostsRequest {

    @JsonProperty("user_id")
    private Integer userId;
    private String title;
    private String body;

}
