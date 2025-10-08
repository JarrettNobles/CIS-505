package Module_5;
import java.util.*;

/*
 * Class: CIS 505
 * Module: 5
 * File: Transaction.java
 * Author: Jarrett Nobles
 * Date: 10/08/2025
 * Description:
 *   Represents an expense transaction with date, description, and amount.
 *   Includes constructors, getters, setters, and a formatted toString() method.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
public class Transaction {
    //data fields
    //date of transaction
    private String date;
    //description of the transaction
    private String description;
    //amount of the transaction
    private double amount;

    //no argument constructor
    /*
    Default constructor initializes the transaction with todays date,
    an empty description, and a default amount of 0.0
     */
    public Transaction(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        this.date = formatter.format(new Date());
        this.description = "";
        this.amount = 0.0;
    }//end constructor

    /*Argument constructor that uses all 3 fields
     * @param date the date of the transaction
     * @param description the description of the transaction
     * @param amount the amount of the transaction
    */
    public Transaction(String date, String description, double amount){
        this.date = date;
        this.description = description;
        this.amount = amount;
    }//end constructor

    // ------------------------------------------------------------
    // Accessors (Getters)
    // ------------------------------------------------------------

    /** @return the date of the transaction */
    public String getDate(){
        return date;
    }//end getDate

    /** @return the description of the transaction */
    public String getDescription(){
        return description;
    }//end getDescription

    /** @return the amount of the transaction */
    public double getAmount() {
        return amount;
    }//end getAmount

    // ------------------------------------------------------------
    // Mutators (Setters)
    // ------------------------------------------------------------
    /** @param date the date to set */
    public void setDate(String date) {
        this.date = date;
    }//end setDate

    /** @param description the description to set */
    public void setDescription(String description) {
        this.description = description;
    }//end setDescription

    /** @param amount the amount to set */
    public void setAmount(double amount) {
        this.amount = amount;
    }//end setAmount

    // ------------------------------------------------------------
    // Overridden to string method
    // ------------------------------------------------------------
    /**
     * Returns a string representation of the transaction with each field
     * on a separate line, formatted with two leading spaces.
     * Example:
     *   Date: 10-08-2025
     *   Description: Gas Station
     *   Amount: 45.75
     */
    @Override
    public String toString(){
        return String.format("  Date: %s%n  Description: %s%n  Amount: %.2f",
                date, description, amount);
    }//end overridden to string method
}//end transaction class
