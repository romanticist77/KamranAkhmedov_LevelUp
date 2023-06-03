package ru.levelup.at.lesson03.unit.testing.tools.hooks.classes.test.instance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

@TestInstance(Lifecycle.PER_CLASS)
abstract class CalculatorBasicTest {

    protected Calculator calculator;

    @BeforeAll
    void beforeAll() {
        System.out.println(this.getClass().getName() + " Before all");
    }

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " Before each");
        calculator = new CalculatorImpl();
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " After each");
        calculator = null;
    }

    @AfterAll
    void afterAll() {
        System.out.println(CalculatorBasicTest.class.getName() + " After all");
    }
}
