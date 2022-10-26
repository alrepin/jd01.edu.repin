package ga.repin.education.course02.topic12.hw.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ga.repin.education.course02.topic12.hw.calculator.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplV2Test {
    private final CalculatorServiceV2 calc = new CalculatorServiceImplV2();

    @Test
    public void operationWelcomeContainCriticalInfo() {
        assertTrue(calc.operationWelcome().contains(GREETING_HAS_STRING));
    }

    @Test
    void operationPlusReturnedHTMLContainedStrExpressionFivePlusOneIsSix() {
        String actual = calc.operationPlus(FIVE, ONE);
        assertTrue(actual.contains(FIVE_PLUS_ONE));
    }

    @Test
    void operationPlusReturnedHTMLContainedStrExpressionZeroPlusZeroIsZero() {
        String actual = calc.operationPlus(ZERO, ZERO);
        assertTrue(actual.contains(ZERO_PLUS_ZERO));
    }

    @Test
    void operationMinusReturnedHTMLContainedStrExpressionZeroMinusZeroIsZero() {
        String actual = calc.operationMinus(ZERO, ZERO);
        assertTrue(actual.contains(ZERO_MINUS_ZERO));
    }

    @Test
    void operationMinusReturnedHTMLContainedStrExpressionZeroMinusOneIsNegOne() {
        String actual = calc.operationMinus(ZERO, ONE);
        assertTrue(actual.contains(ZERO_MINUS_ONE));
    }

    @Test
    void operationMultiplyReturnedHTMLContainedCorrectStrExpressions() {
        String actual = calc.operationMultiply(ZERO, TWENTY);
        assertTrue(actual.contains(ZERO_MULTIPLY_TWENTY));
    }

    @Test
    void operationMultiplyReturnedHTMLContainedCorrectStrExpressions2() {
        String actual = calc.operationMultiply(TWENTY, ONE);
        assertTrue(actual.contains(TWENTY_MULTIPLY_ONE));
    }

    @Test
    void operationDivideReturnedHTMLContainedCorrectStrExpressions() {
        String actual = calc.operationDivide(TWENTY, FIVE);
        assertTrue(actual.contains(TWENTY_DIVIDE_FIVE));
    }

    @Test
    void operationDivideReturnedHTMLContainedCorrectStrExpressions2() {
        String actual = calc.operationDivide(FIVE, TWENTY);
        assertTrue(actual.contains(FIVE_DIVIDE_TWENTY));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenZeroDivider() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.operationDivide(FIVE, ZERO)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTests")
    public void operationPlusGenerateCorrectOutput(Double num1, Double num2, String expectedInOutput) {
        String actual = calc.operationPlus(num1, num2);
        assertTrue(actual.contains(expectedInOutput));
    }

    public static Stream<Arguments> provideParamsForPlusTests() {
        return Stream.of(
                Arguments.of(FIVE, ONE, FIVE_PLUS_ONE),
                Arguments.of(ZERO, ZERO, ZERO_PLUS_ZERO)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTests")
    public void operationMinusGenerateCorrectOutput(Double num1, Double num2, String expectedInOutput) {
        String actual = calc.operationMinus(num1, num2);
        assertTrue(actual.contains(expectedInOutput));
    }

    public static Stream<Arguments> provideParamsForMinusTests() {
        return Stream.of(
                Arguments.of(ZERO, ZERO, ZERO_MINUS_ZERO),
                Arguments.of(ZERO, ONE, ZERO_MINUS_ONE)
        );
    }

}