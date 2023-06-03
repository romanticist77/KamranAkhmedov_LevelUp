package ru.levelup.at.lesson03.unit.testing.tools.soft.assertions.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PersonService {

    public static Person createRandomPerson() {
        return new Person("Иван", "Иванов", LocalDate.parse("1994-08-03"), "test@test.ru");
    }

}
