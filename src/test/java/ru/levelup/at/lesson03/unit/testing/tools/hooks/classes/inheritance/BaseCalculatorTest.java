package ru.levelup.at.lesson03.unit.testing.tools.hooks.classes.inheritance;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public abstract class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " Before class");
    }

    @BeforeMethod
    public void setUp() {
        //arrange || given
        System.out.println(this.getClass().getName() + " Set up");
        calculator = new CalculatorImpl();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getName() + " Tear down");
        calculator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " After class");
    }
}
