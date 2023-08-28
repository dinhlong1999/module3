package com.example.calculator.service;

public class Calculator {
    public static float calculator(float firstNumber, float secondNumber, char operator) {
        float result = 0;
        switch (operator) {
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                    break;
                } else {
                    throw new RuntimeException("Arithmectic Exception: by zero / 0");
                }
            default:
                throw new RuntimeException("No valid, please enter again");
        }
        return result;
    }
}
