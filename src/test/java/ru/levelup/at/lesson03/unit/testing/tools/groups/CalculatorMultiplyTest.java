package ru.levelup.at.lesson03.unit.testing.tools.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.levelup.at.lesson03.unit.testing.tools.groups.annotations.IncrementTag;
import ru.levelup.at.lesson03.unit.testing.tools.groups.annotations.PositiveTag;

public class CalculatorMultiplyTest extends
    CalculatorBasicTest {

    @Override
    @BeforeAll
    void beforeAll() {
        super.beforeAll();
        System.out.println("beforeAll Method has been overridden");
    }

    @IncrementTag
    @PositiveTag
    @Test
    void calculatorMultiplyTest() {
        System.out.println(this.getClass().getName() + " calculatorMultiplyTest");
        var actual = calculator.multiply(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.00");
        assertEquals(expected, actual, "Умножение работает неверно");
    }

    @Override
    @AfterAll
    void afterAll() {
        super.afterAll();
        System.out.println("afterAll Method has been overridden");
    }
}
