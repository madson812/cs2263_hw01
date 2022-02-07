package edu.isu.cs2263.hw01;


/**
 * An interface for the class that will input both the numbers and operators. Makes sure that the input method 
 * will be called getInput.
 * 
 * @author Grant Madson
 */
public interface InputFace{

    /**
     * Returns the String that is input by the user. Meant to be implemented and then used in an endless loop.
     * 
     * @author Grant Madson
     * @return   Returns the String that is input by the user.
     */
    String getInput();

}
