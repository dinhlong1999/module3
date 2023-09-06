package com.example.ex1.service;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public static List<Double> calculator(double firstNumber, double secondNumber, double thirtyNumber){
        List<Double> result = new ArrayList<>();
        double dental = Math.pow(secondNumber,2) - 4 * firstNumber * thirtyNumber;
        if (dental > 0){
            double firstResult = (-secondNumber + Math.sqrt(dental)) / 2 * firstNumber;
            double secondResult = (-secondNumber - Math.sqrt(dental)) / 2 * firstNumber;
            result.add(firstResult);
            result.add(secondResult);
        }else if (dental == 0){
            double firstResult = -secondNumber / (2 * firstNumber);
            result.add(firstResult);
        }else {
            return null;
        }
        return result;
    }
}
