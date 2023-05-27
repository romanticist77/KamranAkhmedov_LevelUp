package ru.levelup.at.lesson03.unit.testing.tools.data.provider;

import org.testng.annotations.DataProvider;
import java.math.BigDecimal;

public class ExternalDataProvider {

    @DataProvider
    public static Object[][] addDataProvider() {
        return new Object[][] {
            {new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("4.0")},
            {new BigDecimal("4.0"), new BigDecimal("2.0"), new BigDecimal("6.0")},
            {new BigDecimal("6.0"), new BigDecimal("2.0"), new BigDecimal("8.0")}
        };
    }

    @DataProvider(name = "Subtract Test Data")
    public static Object[][] subtractDataProvider() {
        return new Object[][] {
            {new BigDecimal("6.0"), new BigDecimal("2.0"), new BigDecimal("4.0")},
            {new BigDecimal("4.0"), new BigDecimal("2.0"), new BigDecimal("2.0")},
            {new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("0.0")}
        };
    }
}
