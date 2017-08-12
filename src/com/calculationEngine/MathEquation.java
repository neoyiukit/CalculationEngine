package com.calculationEngine;

/**
 * Created by neo.yiu on 02/08/2017.
 */
public class MathEquation {
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

    // using the constructor
    public MathEquation(){}

    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal){
        this(opCode); // chained constructor
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    // method overloading
    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }

    // method overloading for int
    public void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();

        result = (int)result;
    }

    public void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Error - invalid OpCode!");
                result = 0.0d;
                break;
        }
    }
}
