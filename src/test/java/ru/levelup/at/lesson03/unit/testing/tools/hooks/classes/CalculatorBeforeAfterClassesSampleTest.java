package ru.levelup.at.lesson03.unit.testing.tools.hooks.classes;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorBeforeAfterClassesSampleTest {

    private Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void setUp() {
        //arrange || given
        System.out.println("Set up");
        calculator = new CalculatorImpl();
    }

    @Test
    public void addTest() {
        System.out.println("AddTest");
        //act
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");

        //assert
        assertEquals(actual, expected, "Calculator add function error");
    }

    @Test
    public void subtractTest() {
        System.out.println("SubtractTest");
        //when
        var actual = calculator.subtract(new BigDecimal("4.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("2.0");

        //then
        assertEquals(actual, expected, "Calculator subtract function error");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tear down");
        calculator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Before class");
    }

}
