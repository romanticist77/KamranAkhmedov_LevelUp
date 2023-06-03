package ru.levelup.at.lesson03.unit.testing.tools.soft.assertions;

import java.time.LocalDate;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelup.at.lesson03.unit.testing.tools.soft.assertions.service.PersonService;

public class SoftAssertionsTest {

    @Test
    public void createRandomPersonTest() {

        var person = PersonService.createRandomPerson();

        var softAssert = new SoftAssert();

        softAssert.assertEquals(person.getFirstname(), "Иван");
        softAssert.assertEquals(person.getLastName(), "Иванов");
        softAssert.assertEquals(person.getDateOfBirth(), LocalDate.parse("1994-08-03"));
        softAssert.assertEquals(person.getEmail(), "test@test.ru");

        softAssert.assertAll();
    }

    @Test
    public void createRandomPersonFailTest() {

        var person = PersonService.createRandomPerson();

        var softAssert = new SoftAssert();

        softAssert.assertEquals(person.getFirstname(), "Виктор");
        softAssert.assertEquals(person.getLastName(), "Соколов");
        softAssert.assertEquals(person.getDateOfBirth(), LocalDate.parse("1993-08-03"));
        softAssert.assertEquals(person.getEmail(), "test@tests.ru");
        softAssert.assertAll();
    }

    @Test
    public void createRandomPersonWithoutAssertAllTest() {

        var person = PersonService.createRandomPerson();

        var softAssert = new SoftAssert();

        softAssert.assertEquals(person.getFirstname(), "Виктор");
        softAssert.assertEquals(person.getLastName(), "Соколов");
        softAssert.assertEquals(person.getDateOfBirth(), LocalDate.parse("1993-08-03"));
        softAssert.assertEquals(person.getEmail(), "test@tests.ru");
    }
}

