package ru.levelup.at.lesson03.unit.testing.tools.data.provider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;
import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CalculatorInternalDataProviderTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        //arrange || given
        System.out.println("Set up");
        calculator = new CalculatorImpl();
    }

    @DataProvider
    public static Object[][] addDataProvider() {
        return new Object[][] {
            {new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("4.0")},
            {new BigDecimal("4.0"), new BigDecimal("2.0"), new BigDecimal("6.0")},
            {new BigDecimal("6.0"), new BigDecimal("2.0"), new BigDecimal("8.0")}
        };
    }

    @DataProvider(name = "Subtract Test Data")
    public static Object[][] subtractDataProvider() {
        return new Object[][] {
            {new BigDecimal("6.0"), new BigDecimal("2.0"), new BigDecimal("4.0")},
            {new BigDecimal("4.0"), new BigDecimal("2.0"), new BigDecimal("2.0")},
            {new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("0.0")}
        };
    }

    @Test(dataProvider = "addDataProvider")
    public void addTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println("AddTest");
        //act
        var actual = calculator.add(a, b);

        //assert
        assertEquals(actual, expected, "Calculator add function error");
    }

    @Test(dataProvider = "Subtract Test Data")
    public void subtractTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println("SubtractTest");
        //when
        var actual = calculator.subtract(a, b);

        //then
        assertEquals(actual, expected, "Calculator subtract function error");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tear down");
        calculator = null;
    }
}
