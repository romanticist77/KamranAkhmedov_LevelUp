package ru.levelup.at.lesson03.unit.testing.tools.hooks.method.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorMultiplyTest extends CalculatorBasicTest {

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        System.out.println("Method has been overridden");
    }


    @Test
    void calculatorMultiplyTest() {
        System.out.println(this.getClass().getName() + " calculatorMultiplyTest");
        var actual = calculator.multiply(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.00");
        assertEquals(expected, actual, "Умножение работает неверно");
    }

}
