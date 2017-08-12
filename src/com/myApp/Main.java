package com.myApp;

import com.calculationEngine.Adder;
import com.calculationEngine.CalculateBase;
import com.calculationEngine.CalculateHelper;
import com.calculationEngine.Divider;
import com.calculationEngine.InvalidStatementException;
import com.calculationEngine.MathEquation;
import com.calculationEngine.Multiplier;
import com.calculationEngine.Subtracter;

public class Main {
    public static void main(String[] args) {
//        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//        char[] opCodes = {'d', 'a', 's', 'm'};
//        double[] results = new double[opCodes.length];

//        useMathEquation();
//        useCalculateBase();

        String[] statements = {
                "add 1.0", // error: incorrect number of values
                "add xx 25.0", // error: non-numeric data
                "addX 0.0 0.0", // error: invalid command
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement:statements){
            // handle the exception here
            try {
                helper.process(statement);
                System.out.println(helper); // if you print the object instance itself it will be like this so overriding (defining) the object method toString will be better
            } catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("Original Exception: " + e.getCause().getMessage()); // there maybe another exception associated
            }
        }


        MathEquation[] equations = new MathEquation[4]; // good points that sometimes u can create an array directly from the class
        equations[0] = new MathEquation('d', 100.0d, 50.0d); // create an obj using constructors
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation : equations){
            equation.execute();
            System.out.println("The result is: " + equation.getResult());}

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("The result is: " + equationOverload.getResult());

        // widening conversion - double is wider than an int
        equationOverload.execute(leftInt, rightInt);
        System.out.println("The result is: " + equationOverload.getResult());

        // one double and one int - will pick a constructor that can go with two double
        equationOverload.execute(leftInt, rightDouble);
        System.out.println("The result is: " + equationOverload.getResult());

        // new section using inheritance
        System.out.println("Now this is the Inheritance");
        CalculateBase[] calculators = {
                new Divider(100.0d , 50.0d),
                new Adder(25.0d , 92.0d),
                new Subtracter(225.0d , 17.0d),
                new Multiplier(11.0d , 3.0d)
        };

        for (CalculateBase calculator : calculators){
            calculator.calculate();
            System.out.println("The result is: " + calculator.getResult());
        }
    }

//    public static MathEquation create(double leftVal, double rightVal, char opCode) {
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//
//        return equation;
//    }
}
