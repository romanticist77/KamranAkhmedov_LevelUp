package ru.levelup.at.lesson0809.api.sample;

import java.io.Serializable;
import java.util.Objects;

public class Comment implements Serializable {

    public int id;
    public int postId;
    public String name;
    public String email;
    public String body;

    public Comment(int id, int postId, String name, String email, String body) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Comment"
            + "{"
            + "id=" + id
            + ", post_id=" + postId
            + ", name='" + name + '\''
            + ", email='" + email + '\''
            + ", body='" + body + '\''
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return id == comment.id && postId == comment.postId && Objects.equals(name, comment.name) && Objects.equals(
            email, comment.email) && Objects.equals(body, comment.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postId, name, email, body);
    }
}
