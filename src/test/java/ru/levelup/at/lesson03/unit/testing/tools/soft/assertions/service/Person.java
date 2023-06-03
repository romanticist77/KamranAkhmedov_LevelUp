package ru.levelup.at.lesson03.unit.testing.tools.soft.assertions.service;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String firstname;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;

    public Person(String firstname, String lastName, LocalDate dateOfBirth, String email) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname) && Objects.equals(lastName, person.lastName)
            && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName, dateOfBirth, email);
    }

    @Override
    public String toString() {
        return "Person{"
            + "firstname='"
            + firstname + '\''
            + ", lastName='"
            + lastName + '\''
            + ", dateOfBirth="
            + dateOfBirth
            + ", email='"
            + email
            + '\''
            +
            '}';
    }
}
