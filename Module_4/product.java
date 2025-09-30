package Module_4;
import java.util.*;
/*
 * COURSE: CIS 505
 * Assignment: 4.2 BowlingShopApp
 * Author: Jarrett Nobles
 * Due Date: 10-05-2025
 * File: product.java
 * Theme Focus: Inheritance and Polymorphism
 * Description:
 *  Base product type for all store items. Subclasses (ball, bag, shoe).
 *  inherit common fields and override/ extend behavior as needed.
 *  Price is formatted as "$%, 6.2f" and each field prints on its own line.
 *
 * OOP Notes:
 *  -Inheritance: Subclasses reuse code/fields here
 *  -Polymorphism: Variables of type 'product' can reference any subclass,
 *  and overridden toString() resolves runtime.
 */
public class product {
    //declare variables
    private String code;
    private String description;
    private double price;

    //no-arg constructor
    public product(){}

    //convenience constructor
    public product(String code, String description, double price){
        this.code=code;
        this.description=description;
        this.price=price;
    }//end constructor

    //getters and setters
    public String getCode(){
        return code;
    }//end getCode

    public void setCode(String code){
        this.code = code;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString(){
        //Exact format required by the assignment figures
        String priceStr = String.format("$%,6.2f", price);
        return "Code: " + code + System.lineSeparator()
                + "Description: " + description + System.lineSeparator()
                + "Price: " + priceStr;
    }
}//end class
