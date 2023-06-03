package ru.levelup.at.lesson03.unit.testing.tools.hooks.classes.test.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class CalculatorAddTest extends CalculatorBasicTest {

    @Test
    void calculatorAddTest() {
        System.out.println(this.getClass().getName() + " calculatorAddTest");
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");
        assertEquals(expected, actual, "Сложение работает неверно");
    }

    @Test
    void calculatorAdditionalTest() {
        System.out.println(this.getClass().getName() + " calculatorAdditionalTest");
        var actual = calculator.add(new BigDecimal("4.0"), new BigDecimal("4.0"));
        var expected = new BigDecimal("8.0");
        assertEquals(expected, actual, "Сложение работает неверно");
    }
}
