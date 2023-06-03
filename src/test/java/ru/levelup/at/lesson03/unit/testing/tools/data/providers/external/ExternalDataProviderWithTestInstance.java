package ru.levelup.at.lesson03.unit.testing.tools.data.providers.external;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.provider.Arguments;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class ExternalDataProviderWithTestInstance {

    static Stream<Arguments> addDataProvider() {
        return Stream.of(
            of(new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("4.0")),
            of(new BigDecimal("4.0"), new BigDecimal("2.0"), new BigDecimal("6.0")),
            of(new BigDecimal("6.0"), new BigDecimal("2.0"), new BigDecimal("8.0"))

        );
    }

    static Stream<Arguments> multiplyDataProvider() {
        return Stream.of(
            of(new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("4.00")),
            of(new BigDecimal("4.0"), new BigDecimal("2.0"), new BigDecimal("8.00")),
            of(new BigDecimal("6.0"), new BigDecimal("2.0"), new BigDecimal("12.00"))

        );
    }
}
