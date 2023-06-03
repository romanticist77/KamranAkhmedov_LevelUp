package ru.levelup.at.lesson03.unit.testing.tools.data.providers.external;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.at.lesson03.unit.testing.tools.Calculator;
import ru.levelup.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorInternalDataProviderTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " Before each");
        calculator = new CalculatorImpl();
    }

    @ParameterizedTest
    @MethodSource("ru.levelup.at.lesson03.unit.testing.tools.data.providers.external.ExternalDataProvider#addDataProvider")
    void calculatorSampleTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println(this.getClass().getName() + " calculatorSampleTest");
        var actual = calculator.add(a, b);
        assertEquals(expected, actual, "Сложение работает неверно");
    }

    @ParameterizedTest
    @MethodSource("ru.levelup.at.lesson03.unit.testing.tools.data.providers.external.ExternalDataProvider#multiplyDataProvider")
    void calculatorMultiplyTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println(this.getClass().getName() + " calculatorMultiplyTest");
        var actual = calculator.multiply(a, b);
        assertEquals(expected, actual, "Умножение работает неверно");
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " After each");
        calculator = null;
    }
}
