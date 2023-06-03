package ru.levelup.at.lesson03.unit.testing.tools.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class CalculatorDivideTest extends
    CalculatorBasicTest {

    @Test
    @Tags({@Tag(TagNames.DECREMENT_TAG), @Tag(TagNames.POSITIVE_TAG)})
    void calculatorDivideTest() {
        System.out.println(this.getClass().getName() + " calculatorDivideTest");
        var actual = calculator.divide(new BigDecimal("4.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("2");
        assertEquals(expected, actual, "Деление работает неверно");
    }
}
