package ru.levelup.at.lesson03.unit.testing.tools.hooks.method.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorAddTest extends CalculatorBasicTest {

    @Test
    void calculatorAddTest() {
        System.out.println(this.getClass().getName() + " calculatorAddTest");
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");
        assertEquals(expected, actual, "Сложение работает неверно");
    }

}
