package ru.levelup.at.homework4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilCreds {

    public static Properties prop = new Properties();

    public static Properties loadProperties() {
        try (FileInputStream inputStream = new FileInputStream(
            "src/main/java/ru/levelup/at/homework4/config/creds.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static final String username = UtilCreds.loadProperties().getProperty("username");
    public static final String password = UtilCreds.loadProperties().getProperty("password");
}
