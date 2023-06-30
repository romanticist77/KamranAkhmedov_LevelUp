package ru.levelup.at.lesson0809.api.pojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
public class CreateCommentRequest {

    @JsonProperty("post_id")
    private String postId;
    private String name;
    private String email;
    private String body;

    public static CreateCommentRequestBuilder builder() {
        return new CreateCommentRequestBuilder();
    }

    public static class CreateCommentRequestBuilder {
        private String postId;
        private String name;
        private String email;
        private String body;

        CreateCommentRequestBuilder() {
        }

        public CreateCommentRequestBuilder postId(String postId) {
            this.postId = postId;
            return this;
        }

        public CreateCommentRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CreateCommentRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CreateCommentRequestBuilder body(String body) {
            this.body = body;
            return this;
        }

        public CreateCommentRequest build() {
            return new CreateCommentRequest(this.postId, this.name, this.email, this.body);
        }

        public String toString() {
            return "CreateCommentRequest.CreateCommentRequestBuilder(postId=" + this.postId + ", name=" + this.name
                + ", email=" + this.email + ", body=" + this.body + ")";
        }
    }
}
