package ru.levelup.at.lesson03.unit.testing.tools.data.provider;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorExternalDataProviderTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        //arrange || given
        System.out.println("Set up");
        calculator = new CalculatorImpl();
    }

    @Test(dataProvider = "addDataProvider", dataProviderClass = ExternalDataProvider.class)
    public void addTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println("AddTest");
        //act
        var actual = calculator.add(a, b);

        //assert
        assertEquals(actual, expected, "Calculator add function error");
    }

    @Test(dataProvider = "Subtract Test Data", dataProviderClass = ExternalDataProvider.class)
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
