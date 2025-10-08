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

    }//end constructor

}
