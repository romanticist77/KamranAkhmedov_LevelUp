package ru.levelup.at.lesson03.unit.testing.tools.hooks.group;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public abstract class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeGroups(groups = {
        GroupNames.DECREMENT_TEST_GROUP,
        GroupNames.INCREMENT_TEST_GROUP,
        GroupNames.NEGATIVE_TEST_GROUP,
        GroupNames.POSITIVE_TEST_GROUP
    })
    public void beforeGroups() {
        //arrange || given
        System.out.println(this.getClass().getName() + " Before groups");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        //arrange || given
        System.out.println(this.getClass().getName() + " Set up");
        calculator = new CalculatorImpl();
    }

    @AfterMethod(groups = GroupNames.POSITIVE_TEST_GROUP)
    public void positiveGroupTearDown() {
        System.out.println(this.getClass().getName() + " Positive group tear down");
        calculator = null;
    }

    @AfterMethod(groups = GroupNames.NEGATIVE_TEST_GROUP)
    public void negativeGroupTearDown() {
        System.out.println(this.getClass().getName() + " Negative group tear down");
        calculator = null;
    }

    @AfterGroups(groups = {
        GroupNames.DECREMENT_TEST_GROUP,
        GroupNames.INCREMENT_TEST_GROUP,
        GroupNames.NEGATIVE_TEST_GROUP,
        GroupNames.POSITIVE_TEST_GROUP
    })
    public void afterGroups() {
        //arrange || given
        System.out.println(this.getClass().getName() + " After groups");
    }
}
