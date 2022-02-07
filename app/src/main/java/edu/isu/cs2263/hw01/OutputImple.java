package edu.isu.cs2263.hw01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This object is used for outputting the solution to the input expression.
 * 
 * @author Grant Madson
 */
public class OutputImple implements OutputFace{

    /**
     * The constructor for the OutputImple object. Doesn't have any use other than reducing overhead if this object is to be called
     * multiple times.
     * 
     * @author Grant Madson
     */
    public OutputImple(){

    }

    /**
     * Outputs both the expression and its results to the System.out stream.
     * 
     * @author Grant Madson
     * @param expr The expression that was evaluated. e.g. "1 + 2 + 3"
     * @param result The result of the expression. e.g. 6
     */
    @Override
    public void output(String expr, int result) {
        System.out.println("The result of the expression " + expr + " is " + result + "\n");
    }

    public void output(String expr, int result, FileWriter writer) throws IOException {
        writer.write("The result of the expression " + expr + " is " + result + "\n");
    }

}
