package ru.levelup.at.lesson03.unit.testing.tools.soft.assertions;

import org.testng.annotations.Test;
import ru.levelup.at.lesson03.unit.testing.tools.soft.assertions.service.PersonService;

import java.time.LocalDate;

import static org.testng.AssertJUnit.assertEquals;

public class HardAssertionsTest {

    @Test
    public void createRandomPersonTest() {


        var person = PersonService.createRandomPerson();
        assertEquals(person.getFirstname(), "Иван");
        assertEquals(person.getLastName(), "Иванов");
        assertEquals(person.getDateOfBirth(), LocalDate.parse("1994-08-03"));
        assertEquals(person.getEmail(), "test@test.ru");
    }

    @Test
    public void createRandomPersonFailTest() {

        var person = PersonService.createRandomPerson();
        assertEquals(person.getFirstname(), "Виктор");
        assertEquals(person.getLastName(), "Иванов");
        assertEquals(person.getDateOfBirth(), LocalDate.parse("1994-08-03"));
        assertEquals(person.getEmail(), "test@test.ru");
    }

}
