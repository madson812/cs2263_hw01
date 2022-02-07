package edu.isu.cs2263.hw01;

import java.security.InvalidParameterException;

/**
 * The object that is used to evaluate expressions. Meant to be initialized and then have the evaluate method used
 * to determine the output of a string in the form "num operator num operator num ...".
 * 
 * @author Grant Madson
 */
public class ExpressionEvaluator {
    
    /**
     * The constructor for ExpressionEvaluator. Does nothing other than initialize the 
     * ExpressionEvaluator object.
     * 
     * @author Grant Madson
     */
    public ExpressionEvaluator(){
    }

    /**
     * The method used to evaluate the expression in the given String. Will throw an exception if
     * there is an invalid operator. Evaluates left to right without respect for the order of operations.
     * 
     * @author Grant Madson
     * @param in The input string in the form "num operator num operator ... num". e.g. "1 + 20 + 3". Spaces are irrelevant. Max size of any input single input num is 50 digits.
     * @return Returns the result of the expression. Expressions are evaluated left to right without respect of order of operations.
     * @throws InvalidParameterException Will throw this exception if there is an invalid operator given.
     */
    public int evaluate(String in) throws InvalidParameterException{
        String inputString = in.replaceAll("\\s+", "");
        boolean num = true;
        int lastNum = 0;
        StringBuilder intBuilder = new StringBuilder(50);
        String currentOp = null;
        boolean cont = true;
        for(int i = 0 ; i < inputString.length() ; i++){
            if(num && currentOp != null){
                i = getContinuousNumber(inputString, intBuilder, cont, i);
                lastNum = evaluator(lastNum, Integer.parseInt(String.valueOf(intBuilder)), currentOp);
                intBuilder.delete(0, intBuilder.length());
                num = false;
            }else if(num){
                    i = getContinuousNumber(inputString, intBuilder, cont, i);
                    lastNum = Integer.parseInt(String.valueOf(intBuilder));
                    intBuilder.delete(0, intBuilder.length());
                    num = false;
            }else {
                currentOp = inputString.substring(i, i+1);
                num = true;
                }
        }
        return lastNum;
    }

    /**
     * A private method used to find the full number of an input number without grabbing operators.
     * eg. "1234 + ..." -> StringBuilder object containing "1234" and an i value to offset the current for loop.
     *
     * @author Grant Madson
     * @param inputString The string object that contains the number you are trying to grab.
     * @param intBuilder The StringBuilder object that will contain the number you are looking for.
     * @param cont A boolean used internally in this method. Declared outside the for loop to reduce overhead. (If this is wrong and it doesn't, or if this is bad practice, please let me know on the assignment comments).
     * @param i The current index for the for loop that this method is used in.
     * @return This method returns i, which is the index for the for loop. This is to prevent this method being called in an infinite loop with the same number being requested.
     */
    private int getContinuousNumber(String inputString, StringBuilder intBuilder, boolean cont, int i) {
        while(cont) {
            try {
                Integer.parseInt(String.valueOf(inputString.charAt(i)));
                intBuilder.append(inputString.charAt(i));
                i += 1;
            } catch (NumberFormatException e) {
                cont = false;
                i -= 1;
            } catch (StringIndexOutOfBoundsException e){
                cont = false;
            }
        }
        return i;
    }

    /**
     * You probably shouldn't be seeing this. This is a private method you shouldn't be touching.
     * Evaluates single expressions such as 1+1, with the inputs for numbers being integers and the operators being Strings.
     * 
     * @author Grant Madson
     * @param first This is the int that is meant to be on the left side of the expression.
     * @param second This is the int the is meant to be on the right side of the expression.
     * @param op This is the operator that determines what action is taken with the ints. e.g. adding, subtracting, multiply, divide, or modulus.
     * @return Returns the int that is the result of the input expression.
     * @throws InvalidParameterException This exception is thrown if an invalid operator is given. e.g. "1g1" is not "1+1".
     */
    private int evaluator(int first, int second, String op) throws InvalidParameterException{
        int number;
        switch(op){
            case "+" -> number = first + second;
            case "-" -> number =  first - second;
            case "/" -> number = first / second;
            case "*" -> number = first * second;
            case "%" -> number = first % second;
            default -> throw new InvalidParameterException("Not a valid operator.");
        }
        return number;
    }
}
