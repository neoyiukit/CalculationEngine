package com.calculationEngine;

/**
 * Created by neo.yiu on 13/08/2017.
 */
public interface MathProcessing { // only with the contract but not with any implementation
    String SEPARATOR = " ";
    String getKeyword(); // e.g. subtract
    char getSymbol(); // -
    double doCalculation(double leftVal, double rightVal);
}
