package Module_4;

/*
 *COURSE: CIS 505
 * Assignment: 4.2 BowlingShopApp
 * Author: Jarrett Nobles
 * Due Date: 10-05-2025
 * File: product.java
 * Theme Focus: Inheritance and Polymorphism
 * Description:
 *  bag is a product with an additional field: type (Example: Roller, tote).
 *  Extends product and appends its own attribute to the display output
 */
public class Bag extends Product {
    private String type;

    public Bag(){
        super();
    }

    public Bag(String code, String description, double price, String type){
        super(code, description, price);
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return super.toString() + System.lineSeparator()
                + "Type: " + type;
    }//end to string
}//end bag class
