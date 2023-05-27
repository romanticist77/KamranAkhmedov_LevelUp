package ru.levelup.at.lesson03.unit.testing.tools.hooks.group;

import org.testng.annotations.Test;
import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideSampleTest extends BaseCalculatorTest {

    @Test(groups = {GroupNames.DECREMENT_TEST_GROUP, GroupNames.POSITIVE_TEST_GROUP})
    public void divideTest() {
        System.out.println(this.getClass().getName() + " DivideTest");
        //when
        var actual = calculator.divide(new BigDecimal("4.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("2");

        //then
        assertEquals(actual, expected, "Calculator divide function error");
    }

    @Test(groups = {GroupNames.DECREMENT_TEST_GROUP, GroupNames.NEGATIVE_TEST_GROUP}, expectedExceptions = {
        IllegalArgumentException.class})
    public void divideToZeroTest() {
        System.out.println(this.getClass().getName() + " divideToZeroTest");

        calculator.divide(new BigDecimal("4.0"), new BigDecimal("0.0"));

    }

}
