package com.calculationEngine;

/**
 * Created by neo.yiu on 13/08/2017.
 */
public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper (MathProcessing[] handlers) {
        this.handlers = handlers;
    }
    public String process (String statement) {
//        IN: add 1.0 2.0
//        OUT: 1.0 + 2.0 = 3.0
        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0]; //add

        MathProcessing theHandler = null;

        for (MathProcessing handler : handlers) { // there could be more than one class implement the same interface
            if (keyword.equalsIgnoreCase(handler.getKeyword())) {
                theHandler = handler;
                break;
            }
        }
        double leftValue = Double.parseDouble(parts[1]); // 1.0
        double rightValue = Double.parseDouble(parts[2]); // 2.0
        double result = theHandler.doCalculation(leftValue, rightValue);

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString(); // calling toString from StringBuilder
    }
}
