package Module_4;
/*
 * Course: CIS 505
 * Assignment: 4.2 BowlingShopApp
 * Author: Jarrett Nobles
 * Date: 2025-09-30
 * File: TestBowlingShopApp.java
 * Theme Focus: Inheritance and Polymorphism
 * Description:
 *   Console UI that displays a menu, fetches a queue of 'product' (polymorphic)
 *   from ProductDB, and prints by de-queuing each item. Loops until user enters 'x'.
 *   Matches the control flow demonstrated in figures 7.1 through 7.3.
 */
import java.util.Scanner;

public class TestBowlingShopApp {

    /** Prints the selection menu (Figure 7.1). */
    private static void displayMenu() {
        System.out.println("MENU OPTIONS");
        System.out.println("1.   <b> - Bowling Balls");
        System.out.println("2.   <a> - Bowling Bags");
        System.out.println("3.   <s> - Bowling Shoes");
        System.out.println("4.   <x> - Exit");
        System.out.print("Please choose an option: ");
    }//end display meni

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            displayMenu();
            String choice = in.nextLine().trim().toLowerCase();

            //  Exit FIRST — before any DB calls
            if (choice.equals("x")) {
                System.out.println("Bye!");
                break; // Figure 7.3
            }//end if

            // Optional: guard invalid options, so we don't call the DB
            if (!choice.equals("b") && !choice.equals("a") && !choice.equals("s")) {
                System.out.println("Invalid option. Try again.\n");
                continue;
            }//end if

            // Fetch products only for valid non-exit choices
            GenericQueue<Product> products = ProductDB.getProducts(choice); // Figure 7.2
            int total = products.size();

            if (total == 0) {
                System.out.println("No products for selection.\n");
                continue;
            }//end if

            int i = 1;
            while (products.size() > 0) {
                Product p = products.dequeue(); // polymorphic toString()
                System.out.printf("(%d/%d)%n%s%n%n", i, total, p.toString());
                i++;
            }//end while
        }//end while

        in.close();
    }//end main method
}//end class file
