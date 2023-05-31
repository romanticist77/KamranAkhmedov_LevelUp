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
