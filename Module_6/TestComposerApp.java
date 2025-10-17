package Module_6;
/*
 * ------------------------------------------------------------
 * Program: ComposerApp (Assignment 6.2)
 * File: TestComposerApp.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-10-17
 * Description:
 *   Console-based application that demonstrates the use of the
 *   MemComposerDao class. Users can:
 *     1. View all composers
 *     2. Find a composer by ID
 *     3. Add a new composer
 *     4. Exit the application
 *
 *   All output follows strict formatting:
 *     - Two leading spaces for normal lines
 *     - Four leading spaces for numbered menu options
 * ------------------------------------------------------------
 */
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class TestComposerApp {

    /**
     * Entry point of the application.
     * Displays menu options and handles user input.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComposerDao dao = new MemComposerDao();

        printHeader();

        boolean runApp = true;
        while (runApp) {
            printMenu();
            System.out.print("  Please choose an option: ");
            String option = sc.nextLine().trim();
            System.out.println();

            switch (option) {
                case "1":
                    // ------------------------------------------------------------
                    // Option 1: View all composers
                    // ------------------------------------------------------------
                    System.out.println("  —DISPLAYING COMPOSERS—");
                    //System.out.println();

                    List<Composer> composers = dao.findAll();
                    for (int i = 0; i < composers.size(); i++) {
                        System.out.println(composers.get(i).toString());
                        if (i < composers.size() - 1) {
                            System.out.println();
                        }//end if
                    }//end for
                    System.out.println();
                    break;

                case "2":
                    // ------------------------------------------------------------
                    // Option 2: Find composer by ID
                    // ------------------------------------------------------------
                    System.out.print("  Enter an id: ");
                    Integer id = readInt(sc);
                    System.out.println();
                    System.out.println("  —DISPLAYING COMPOSER—");
                    //System.out.println();

                    Composer found = dao.findBy(id);
                    if (found != null) {
                        System.out.println(found.toString());
                    } else {
                        System.out.println("  No composer found with id: " + id);
                    }//end if
                    System.out.println();
                    break;

                case "3":
                    // ------------------------------------------------------------
                    // Option 3: Add a new composer
                    // ------------------------------------------------------------
                    System.out.print("  Enter an id: ");
                    int newId = readInt(sc);
                    System.out.print("  Enter a name: ");
                    String name = sc.nextLine();
                    System.out.print("  Enter a genre: ");
                    String genre = sc.nextLine();
                    System.out.println();

                    dao.insert(new Composer(newId, name, genre));
                    // Figure 5.1 does not show a success line here, returns to menu
                    break;

                case "4":
                    // ------------------------------------------------------------
                    // Option 4: Exit the program
                    // ------------------------------------------------------------
                    System.out.println("  Goodbye!");
                    runApp = false;
                    break;

                default:
                    // ------------------------------------------------------------
                    // Invalid option handling
                    // ------------------------------------------------------------
                    System.out.println("  Invalid option. Please try again.");
                    System.out.println();
                    break;
            }//end switch
        }//end while

        sc.close();
    }//end main method

    /**
     * Prints the application header, matching Figure 5.1 layout.
     */
    private static void printHeader() {
        System.out.println("  Welcome to the Composer App");
        System.out.println();
    }//end printHeader method

    /**
     * Prints the main menu using four leading spaces for options.
     */
    private static void printMenu() {
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. View Composers");
        System.out.println("    2. Find Composer");
        System.out.println("    3. Add Composer");
        System.out.println("    4. Exit");
        System.out.println();
    }//end printMenu method

    /**
     * Reads an integer safely.
     * Reprompts if invalid input is provided.
     */
    private static int readInt(Scanner sc) {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("  Please enter a valid number: ");
            }//end catch
        }//end while
    }//end readInt method
}//end class


