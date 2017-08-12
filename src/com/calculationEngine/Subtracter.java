package com.calculationEngine;

/**
 * Created by neo.yiu on 07/08/2017.
 */
public class Subtracter extends CalculateBase{
    public Subtracter(){}
    public Subtracter(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }
}
