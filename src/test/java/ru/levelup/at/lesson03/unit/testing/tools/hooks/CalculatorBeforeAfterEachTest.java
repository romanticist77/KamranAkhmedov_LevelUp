package ru.levelup.at.lesson03.unit.testing.tools.hooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorBeforeAfterEachTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " Before each");
        calculator = new CalculatorImpl();
    }

    @Test
    void calculatorSampleTest() {
        System.out.println(this.getClass().getName() + " calculatorSampleTest");
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");
        assertEquals(expected, actual, "Сложение работает неверно");
    }

    @Test
    void calculatorMultiplyTest() {
        System.out.println(this.getClass().getName() + " calculatorMultiplyTest");
        var actual = calculator.multiply(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.00");
        assertEquals(expected, actual, "Умножение работает неверно");
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " After each");
        calculator = null;
    }
}
