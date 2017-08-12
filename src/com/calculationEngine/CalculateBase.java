package com.calculationEngine;

/**
 * Created by neo.yiu on 07/08/2017.
 */
public abstract class CalculateBase {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    public double getLeftVal() {return leftVal;}
    public double getRightVal() {return rightVal;}
    public char getOpCode() {return opCode;}
    public double getResult() {return result;}
    public void setLeftVal(double leftVal) {this.leftVal = leftVal;}
    public void setRightVal(double rightVal) {this.rightVal = rightVal;}
    public void setOpCode(char opCode) {this.opCode = opCode;}
    public void setResult(double result) {this.result = result;}

    public CalculateBase(){}
    public CalculateBase(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public abstract void calculate();
}
