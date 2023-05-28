package ru.levelup.at.lesson03.unit.testing.tools.hooks.suite;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;


public class CalculatorDivideSampleTest extends BaseCalculatorTest {

    @Test
    public void divideTest() {
        System.out.println(this.getClass().getName() + " DivideTest");
        //when
        var actual = calculator.divide(new BigDecimal("4.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("2");

        //then
        assertEquals(actual, expected, "Calculator divide function error");
    }

    @Test
    public void divideToZero() {
        System.out.println(this.getClass().getName() + " divideToZero");
        //when
        var actual = calculator.divide(new BigDecimal("4.0"), new BigDecimal("0.0"));
    }

}
