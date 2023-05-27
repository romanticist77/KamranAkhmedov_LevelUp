package ru.levelup.at.lesson03.unit.testing.tools.hooks.suite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CalculatorAddSampleTest extends BaseCalculatorTest {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        System.out.println("Overrided");
    }

    @Test
    public void addTest() {
        System.out.println(this.getClass().getName() + " AddTest");
        //act
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");

        //assert
        assertEquals(actual, expected, "Calculator add function error");
    }

}
