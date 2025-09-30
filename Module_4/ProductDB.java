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
 *  Factory method that returns a GenericQueue<product> filled with subclass
 *  instances based on a one-letter code:
 *      b - five balls
 *      s - five shoes
 *      a - three bags
 *  Any other input - empty queue.
 *  Polymorphism in action: returning a queue typed as product while holding
 *  ball, shoe, or bag instances, and toString() dispatches at runtime.
 */
public class ProductDB {
    public static GenericQueue<product> getProducts(String code){
        GenericQueue<product> result = new GenericQueue<>();

        if (code == null) return result;
        String c = code.trim().toLowerCase();

        switch(c){
            //five balls
            case "b":
                result.enqueue(new ball("B100", "StrikeMaster Reactive Ball", 129.95, "Black"));
                result.enqueue(new ball("B110", "Galaxy Swirl Ball", 149.50, "Purple"));
                result.enqueue(new ball("B120", "Thunderbolt Urethane Ball", 109.99, "Blue"));
                result.enqueue(new ball("B130", "Afterburn Pearl Ball", 159.00, "Red"));
                result.enqueue(new ball("B140", "Ice Storm Polyester Ball", 89.95, "White"));
                break;

            //five shoes
            case "s":
                result.enqueue(new shoe("S200", "SlidePro Men Shoes",      69.99,10));
                result.enqueue(new shoe("S210", "SlidePro Women Shoes",    64.99, 7));
                result.enqueue(new shoe("S220", "Tour Elite Unisex Shoes", 119.00,9));
                result.enqueue(new shoe("S230", "Comfort Flex Shoes",      79.95,11));
                result.enqueue(new shoe("S240", "Junior Started Shoes",     49.50,5));
                break;

            case "a":
                result.enqueue(new bag("A300", "Single Roller Bag",         59.99,"Roller"));
                result.enqueue(new bag("A310", "Deluxe Tote Bag",           39.95,"Tote"));
                result.enqueue(new bag("A320", "Triple Roller Tournament Bag",189.00,"Roller"));
                break;
        }//end switch
        return result;
    }//end
}//end class
