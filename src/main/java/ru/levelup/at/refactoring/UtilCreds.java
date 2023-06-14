package ru.levelup.at.refactoring;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilCreds {

    public static Properties prop = new Properties();

    static {

        try (FileInputStream inputStream = new FileInputStream(
            "src/main/java/ru/levelup/at/refactoring/config/creds.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String username = prop.getProperty("username");
    public static final String password = prop.getProperty("password");
}
