package ru.levelup.at.lesson03.unit.testing.tools.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorSampleTest {

    @Test
    void calculatorSampleTest() {
        Calculator calculator = new CalculatorImpl();

        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");

        assertEquals(expected, actual, "Сложение работает неверно");
    }

    @Test
    void calculatorMultiplyTest() {

        Calculator calculator = new CalculatorImpl();

        var actual = calculator.multiply(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.00");
        assertEquals(expected, actual, "Умножение работает неверно");
    }
}
