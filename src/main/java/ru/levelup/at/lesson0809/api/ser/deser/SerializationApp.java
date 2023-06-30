package ru.levelup.at.lesson0809.api.ser.deser;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import ru.levelup.at.lesson0809.api.sample.Comment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationApp {

    static Faker faker = new Faker();

    public static void main(String[] args) {

        Comment comment =
            new Comment(faker.number().numberBetween(42850, 42900), faker.number().numberBetween(48000, 48050),
                faker.name().firstName() + faker.name().lastName(), faker.internet().emailAddress(),
                faker.lorem().sentence(7));

        try (var oos = new ObjectOutputStream(new FileOutputStream(new File("comment.json")))) {
            oos.writeObject(comment);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
