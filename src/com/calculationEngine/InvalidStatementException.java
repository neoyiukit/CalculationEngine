package com.calculationEngine;

/**
 * Created by neo.yiu on 12/08/2017.
 */
public class InvalidStatementException extends Exception {
    public InvalidStatementException(String reason, String statement){
        super(reason + ": " + statement); // calling the superclass constructor
    }
    public InvalidStatementException(String reason, String statement, Throwable cause){
        super(reason + ": " + statement, cause); // to specify the exception is triggered by the exception specified but not from others
    }
}
