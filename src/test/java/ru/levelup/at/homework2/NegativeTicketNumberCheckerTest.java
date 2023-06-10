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
            {"123456"},
            {"456123"},
            {"123"},
            {"      "},
            {""},
            {null}
        };
    }

//    @DataProvider(name = "Empty String data")
//    public static Object[][] checkerEmptyDataProvider() {
//        return new Object[][] {
//            {"123456", false},
//            {"456123", false},
//            {"      ", false}
//        };
//    }

    @Test(dataProvider = "Negative test data")
    public void checkerNegativeTest(String ticketNumber) {
        var expectedMessage = "Illegal argument is provided";
        try {
            assertFalse(tickerNumberChecker.checkTicketNumber(ticketNumber));
        } catch (Exception e) {
            Assert.assertEquals(expectedMessage, e.getMessage());
        }
    }

//    @Test
//    public void checkerEmptyStringTest() {
//        try {
//            assertFalse(tickerNumberChecker.checkTicketNumber("      "));
//        } catch (Exception e) {
//            Assert.assertEquals(expected, e.getMessage());
//        }
//    }
}
