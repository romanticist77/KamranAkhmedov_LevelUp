package ru.levelup.at.lesson03.unit.testing.tools.hooks.suite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public abstract class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " Before suite");
        System.out.println();
    }

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
        System.out.println();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " After suite");
    }
}
