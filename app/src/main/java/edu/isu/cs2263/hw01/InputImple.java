package edu.isu.cs2263.hw01;

import java.util.Scanner;

/**
 * Implements InputFace. This is meant to be used in an endless loop to gather the input from the user using the
 * stream specified by the Scanner object that is passed into the constructor.
 * 
 * @author Grant Madson
 */
public class InputImple implements InputFace {

    private final Scanner in;

    /**
     * The constructor that initializes the InputImple object. Requires a scanner object with the desired input stream
     * to be input as a parameter.
     * 
     * @author Grant Madson
     * @param scan The scanner object with the desired input stream.
     */
    public InputImple(Scanner scan){
        this.in = scan;
    }

    /**
     * The method for getting the input from the Scanner object. Returns the full input as a String
     * after the user hits enter.
     * 
     * @author Grant Madson
     * @return returns a String of the users input from the scanner object.
     */
    @Override
    public String getInput() {
        if(in.hasNextLine()){
            return in.nextLine();
        } else{
            return null;
        }

    }
    
}
