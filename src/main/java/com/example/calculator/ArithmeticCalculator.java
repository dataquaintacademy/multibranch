package com.example.calculator;

public class ArithmeticCalculator {
    public double calculate(double left, double right, String operator) {
        if (operator == null) {
            throw new IllegalArgumentException("Unsupported operation.");
        }
        switch (operator) {
            case "add":
                return left + right;
            case "subtract":
                return left - right;
            case "multiply":
                return left * right;
            case "divide":
                if (right == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero.");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Unsupported operation.");
        }
    }
}
