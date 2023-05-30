package ru.levelup.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveTicketNumberCheckerTest extends BasicTicketNumberCheckerTest {

    @DataProvider(name = "Positive test data")
    public static Object[][] subtractDataProvider() {
        return new Object[][] {
            {"123123", true},
            {"456456", true}
        };
    }

    @Test(dataProvider = "Positive test data")
    public void checkerPositiveTest(String ticketNumber, boolean expected) {
        var actual = tickerNumberChecker.checkTicketNumber(ticketNumber);
        assertEquals(actual, expected, "Checker positive test error");
    }
}
