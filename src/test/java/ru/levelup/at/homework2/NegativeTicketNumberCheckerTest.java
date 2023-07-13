package ru.levelup.at.homework2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeTicketNumberCheckerTest extends BasicTicketNumberCheckerTest {

    @DataProvider(name = "Negative test data")
    public static Object[][] checkerDataProvider() {
        return new Object[][] {
            {"123"},
            {"      "},
            {""},
            {null}
        };
    }

    @Test(dataProvider = "Negative test data",
          expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Illegal argument is provided")
    public void checkerNegativeTest(String ticketNumber) {
        assertFalse(tickerNumberChecker.checkTicketNumber(ticketNumber));
    }
}
