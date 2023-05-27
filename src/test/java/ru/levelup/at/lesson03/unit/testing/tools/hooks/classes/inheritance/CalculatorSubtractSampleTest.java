package ru.levelup.at.lesson03.unit.testing.tools.hooks.classes.inheritance;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

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
