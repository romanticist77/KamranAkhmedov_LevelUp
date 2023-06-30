package ru.levelup.at.lesson0809.api.ser.deser;

import ru.levelup.at.lesson0809.api.sample.Comment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserealizationApp {

    public static void main(String[] args) {

        try(var ois = new ObjectInputStream(new FileInputStream(new File("comment.json")))) {
            var comment = (Comment) ois.readObject();
            System.out.println(comment);
            comment.setId(comment.id + 1);
            System.out.println(comment);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
