package ru.levelup.at.lesson03.unit.testing.tools.hooks.method.inheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDivideTest extends CalculatorBasicTest {


    @Test
    void calculatorDivideTest() {
        System.out.println(this.getClass().getName() + " calculatorDivideTest");
        var actual = calculator.divide(new BigDecimal("4.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("2");
        assertEquals(expected, actual, "Деление работает неверно");
    }

}
