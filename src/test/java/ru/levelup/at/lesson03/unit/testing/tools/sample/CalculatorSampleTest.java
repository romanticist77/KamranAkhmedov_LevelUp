package ru.levelup.at.lesson03.unit.testing.tools.sample;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;
import java.math.BigDecimal;

public class CalculatorSampleTest {

    @Test
    public void addTest() {
        //arrange
        var calculator = new CalculatorImpl();

        //act
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");

        //assert
        assertEquals(actual, expected, "Calculator add function error");
    }

    @Test
    public void subtractTest() {
        //given
        var calculator = new CalculatorImpl();

        //when
        var actual = calculator.subtract(new BigDecimal("4.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("2.0");

        //then
        assertEquals(actual, expected, "Calculator subtract function error");
    }
}
