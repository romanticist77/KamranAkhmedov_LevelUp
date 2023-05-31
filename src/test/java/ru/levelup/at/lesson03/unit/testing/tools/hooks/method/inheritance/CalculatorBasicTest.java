package ru.levelup.at.lesson03.unit.testing.tools.hooks.method.inheritance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

abstract class CalculatorBasicTest {

    protected Calculator calculator;

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
}
