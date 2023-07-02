package ru.levelup.at.homework2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasicTicketNumberCheckerTest {

    protected TicketNumberChecker tickerNumberChecker;

    @BeforeMethod
    public void setUp() {
        tickerNumberChecker = new TicketNumberChecker();
    }

    @AfterMethod
    public void tearDown() {
        tickerNumberChecker = null;
    }
}
