package ru.levelup.at.lesson03.unit.testing.tools.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.levelup.at.lesson03.unit.testing.tools.groups.annotations.IncrementTag;
import ru.levelup.at.lesson03.unit.testing.tools.groups.annotations.PositiveTag;

public class CalculatorAddTest extends CalculatorBasicTest {

    @Test
    @Tag(TagNames.INCEREMENT_TAG)
    void calculatorAddTest() {
        System.out.println(this.getClass().getName() + " calculatorAddTest");
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");
        assertEquals(expected, actual, "Сложение работает неверно");
    }

    @Test
    @PositiveTag
    @IncrementTag
    void calculatorAdditionalTest() {
        System.out.println(this.getClass().getName() + " calculatorAdditionalTest");
        var actual = calculator.add(new BigDecimal("4.0"), new BigDecimal("4.0"));
        var expected = new BigDecimal("8.0");
        assertEquals(expected, actual, "Сложение работает неверно");
    }
}
