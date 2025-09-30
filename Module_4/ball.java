package Module_4;
import java.util.*;
/*
*COURSE: CIS 505
 * Assignment: 4.2 BowlingShopApp
 * Author: Jarrett Nobles
 * Due Date: 10-05-2025
 * File: product.java
 * Theme Focus: Inheritance and Polymorphism
 * Description:
 *  ball is a product with an additional field: color.
 *  Demonstrates inheritance by extending product and polymorphism by
 *  overriding/augmenting toString()
 */
public class ball extends product{
    //declare variables
    private String color;

    public ball(){
        super();
    }

    public ball(String code, String description, double price, String color){
        super(code, description, price);
        this.color = color;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return super.toString() + System.lineSeparator()
                + "Color: " + color;
    }
}
