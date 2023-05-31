package ru.levelup.at.lesson03.unit.testing.tools.hooks.tests;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;

public class CalculatorSubtractSampleTest extends BaseCalculatorTest {

    @Test
    public void subtractTest() {
        System.out.println(this.getClass().getName() + " SubtractTest");
        //when
        var actual = calculator.subtract(new BigDecimal("4.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("2.0");

        //then
        assertEquals(actual, expected, "Calculator subtract function error");
    }

}
