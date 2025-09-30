package Module_4;
import java.util.*;
import java.util.Scanner;
/*
 *COURSE: CIS 505
 * Assignment: 4.2 BowlingShopApp
 * Author: Jarrett Nobles
 * Due Date: 10-05-2025
 * File: product.java
 * Theme Focus: Inheritance and Polymorphism
 * Description:
 *  Console UI that displays a menu, fetches a queue of 'product (polymorphic)
 *  from ProductDB, and prints by dequeue each item. Loops until user enters 'x'.
 *  Matches the control flow demonstrated in figures 7.1 through 7.3
 */
public class TestBowlingShoppApp {
    //prints the selection menu (Figure 7.1).
    private static void displayMenu(){
        System.out.println("MENU OPTIONS");
        System.out.println("   b - Bowling Balls");
        System.out.println("   a - Bowling Bags");
        System.out.println("   s - Bowling Shoes");
        System.out.println("   x - Exit");
        System.out.println("Please choose an option: ");
    }//end display menu

    //main method
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(true){
            displayMenu();
            String choice = in.nextLine().trim().toLowerCase();

            if(choice.equals("X")){
                System.out.println("Bye!");
                break; //figure 7.3
            }//end if
            GenericQueue<product> products = ProductDB.getProducts(choice);
            int total = products.size();

            if(total == 0){
                System.out.println("No products for selection.");
                System.out.println();
                continue;
            }//end if

            int index = 1;
            //Per assignment, call dequeue() inside the loop and use size() to control
            while(products.size() > 0){
                //dynamic dispatch on toString()
                product p = products.dequeue();
                System.out.printf("(%d/%d)%n%s%n%n");
            }//end while
        }//end while
        in.close();
    }//end main

}//end class
