package Module_4;

/*
 *COURSE: CIS 505
 * Assignment: 4.2 BowlingShopApp
 * Author: Jarrett Nobles
 * Due Date: 10-05-2025
 * File: product.java
 * Theme Focus: Inheritance and Polymorphism
 * Description:
 *  shoe is a product with an additional field: size.
 *  Extends product and appends its own attribute to the display output.
 */
public class Shoe extends Product {
    private int size;

    public Shoe(){
        super();
    }

    public Shoe(String code, String description, double price, int size){
        super(code, description, price);
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    @Override
    public String toString(){
        return super.toString() + System.lineSeparator()
                + "Size: " + size;
    }//end to string
}//end shoe class
