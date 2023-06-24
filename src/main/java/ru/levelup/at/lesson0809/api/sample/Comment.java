package ru.levelup.at.lesson0809.api.sample;

import java.util.Objects;

public class Comment {

    public final int id;

    public final int postId;
    public final String name;
    public final String email;
    public final String body;

    public Comment(int id, int postId, String name, String email, String body) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
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
