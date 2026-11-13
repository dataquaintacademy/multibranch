package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArithmeticCalculatorTest {
    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    @Test
    void calculatesBasicOperations() {
        assertEquals(7.0, calculator.calculate(3, 4, "add"));
        assertEquals(-1.0, calculator.calculate(3, 4, "subtract"));
        assertEquals(12.0, calculator.calculate(3, 4, "multiply"));
        assertEquals(0.75, calculator.calculate(3, 4, "divide"));
    }

    @Test
    void rejectsDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(3, 0, "divide"));
    }

    @Test
    void rejectsUnsupportedOperation() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(3, 4, "power"));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(3, 4, null));
    }
}
