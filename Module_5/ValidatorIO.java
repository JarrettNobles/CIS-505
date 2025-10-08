package Module_5;
import java.util.*;
import java.util.Scanner;
/*
 * Class: CIS 505
 * Module: 5
 * File: ValidatorIO.java
 * Author: Jarrett Nobles
 * Date: 10/08/2025
 * Description:
 *   Utility class for validating user input.
 *   Contains static methods to get and validate integer, double, and string values
 *   from the console using a Scanner object.
 */


public class ValidatorIO {
    //get int method
    /**
     * Prompts the user to enter an integer value and validates the input.
     * @param sc Scanner instance for reading input
     * @param prompt Message to display to the user
     * @return Valid integer entered by the user
     */
    public static int getInt(Scanner sc, String prompt){
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("  " + prompt);  // two leading spaces
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("  Error! Invalid integer value.");
            }
            sc.nextLine();
        }
        return input;
    }//end get int

    //getDouble method
    /**
     * Prompts the user to enter a double value and validates the input.
     * @param sc Scanner instance for reading input
     * @param prompt Message to display to the user
     * @return Valid double entered by the user
     */

    public static double getDouble(Scanner sc, String prompt){
        double input = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("  " + prompt);  // two leading spaces
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("  Error! Invalid double value.");
            }
            sc.nextLine();
        }
        return input;
    }//end getDouble

    //getString method
    /**
     * Prompts the user to enter a string value.
     * @param sc Scanner instance for reading input
     * @param prompt Message to display to the user
     * @return String value entered by the user
     */
    public static String getString(Scanner sc, String prompt) {
        System.out.print("  " + prompt);  // two leading spaces
        return sc.nextLine();
    }//end getString
}//end class
