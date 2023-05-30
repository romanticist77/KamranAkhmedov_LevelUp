package ru.levelup.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeTicketNumberCheckerTest extends BasicTicketNumberCheckerTest {

    @DataProvider(name = "Negative test data")
    public static Object[][] checkerDataProvider() {
        return new Object[][] {
            {"123456", false},
            {"456123", false}
        };
    }

    @Test(dataProvider = "Negative test data")
    public void checkerNegativeTest(String ticketNumber, boolean expected) {
        var actual = tickerNumberChecker.checkTicketNumber(ticketNumber);
        assertEquals(actual, expected, "Checker negative test error");
    }
}
