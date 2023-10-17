package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ComputerService implements IComputerService{

    @Override
    public double sumInputNumber(double inputNumber1, double inputNumber2, String calculation) {
        double sum = 0;
        if (calculation.equals("+")){
            sum = inputNumber1 + inputNumber2;
            return sum;
        } else if (calculation.equals("-")) {
            sum = inputNumber1 - inputNumber2;
            return sum;
        } else if (calculation.equals("*")) {
            sum = inputNumber1 * inputNumber2;
            return sum;
        } else if (calculation.equals("/")) {
            sum = inputNumber1 / inputNumber2;
            return sum;
        }
        return sum;
    }
}
