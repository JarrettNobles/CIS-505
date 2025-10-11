package Module_5;
/*
 * Class: CIS 505
 * Module: 5
 * File: TestExpenseTracker.java
 * Author: Jarrett Nobles
 * Date: 10/08/2025
 * Description:
 *   Console app to manage expense transactions.
 *   Uses Transaction, TransactionIO, and ValidatorIO to display a menu,
 *   list transactions, add transactions, and show the total of all expenses.
 */
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TestExpenseTracker {

    // ------------------------------------------------------------
    // Entry Point
    // ------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        // Main loop – stay in the menu until user chooses to exit
        while (keepRunning) {
            printMenu();

            int choice = ValidatorIO.getInt(sc, "Enter menu number: ");
            System.out.println(); // visual spacer

            switch (choice) {
                case 1:
                    doListAll();
                    break;
                case 2:
                    doAddTransactions(sc);
                    break;
                case 3:
                    doShowTotal();
                    break;
                default:
                    System.out.println("  Invalid choice. Please select 1, 2, or 3.");
            }

            System.out.println();
            String again = ValidatorIO.getString(sc, "Continue? (y/n): ").trim().toLowerCase(Locale.ROOT);
            keepRunning = again.startsWith("y");
            System.out.println();
        }

        System.out.println("  Goodbye!");
        sc.close();
    }

    // ------------------------------------------------------------
    // Menu Printer (4 leading spaces for numbered lines)
    // ------------------------------------------------------------
    /**
     * Prints the application menu using the required spacing:
     * - Two leading spaces for the header lines
     * - Four leading spaces for numbered menu items
     */
    private static void printMenu() {
        System.out.println("  ===============================");
        System.out.println("  Expense Tracker");
        System.out.println("  ===============================");
        System.out.println("    1) List all transactions");
        System.out.println("    2) Add a new transaction");
        System.out.println("    3) Display total expenses");
        System.out.println("  -------------------------------");
    }

    // ------------------------------------------------------------
    // Option 1: List All Transactions
    // ------------------------------------------------------------
    /**
     * Reads all transactions from the file and prints them.
     * Uses the Transaction.toString() which already applies two-space indentation.
     */
    private static void doListAll() {
        try {
            ArrayList<Transaction> txns = TransactionIO.findAll();

            if (txns.isEmpty()) {
                System.out.println("  No transactions found.");
                return;
            }

            System.out.println("  All Transactions:");
            System.out.println("  -----------------");
            for (Transaction t : txns) {
                // Transaction.toString() prints each field on its own line with two leading spaces
                System.out.println(t.toString());
                System.out.println(); // blank line between entries
            }
        } catch (IOException ex) {
            System.out.println("  Error reading transactions: " + ex.getMessage());
        }
    }

    // ------------------------------------------------------------
    // Option 2: Add Transactions (loop until user stops)
    // ------------------------------------------------------------
    /**
     * Prompts the user to add one or more transactions and writes them to the file.
     * Uses two loops:
     *  - outer loop for staying in the Add section
     *  - inner process of collecting fields and staging to a list for bulkInsert
     */
    private static void doAddTransactions(Scanner sc) {
        boolean stayInAdd = true;

        while (stayInAdd) {
            ArrayList<Transaction> toWrite = new ArrayList<>();

            // Collect one transaction
            String date = ValidatorIO.getString(sc, "Enter date (MM-dd-yyyy): ");
            String description = ValidatorIO.getString(sc, "Enter description: ");
            double amount = ValidatorIO.getDouble(sc, "Enter amount: ");

            toWrite.add(new Transaction(date, description, amount));

            // Ask to add another before committing, to demonstrate bulkInsert as specified
            String more = ValidatorIO.getString(sc, "Add another transaction? (y/n): ").trim().toLowerCase(Locale.ROOT);
            while (more.startsWith("y")) {
                String d = ValidatorIO.getString(sc, "Enter date (MM-dd-yyyy): ");
                String desc = ValidatorIO.getString(sc, "Enter description: ");
                double amt = ValidatorIO.getDouble(sc, "Enter amount: ");
                toWrite.add(new Transaction(d, desc, amt));
                more = ValidatorIO.getString(sc, "Add another transaction? (y/n): ").trim().toLowerCase(Locale.ROOT);
            }

            // Write the collected transactions
            try {
                TransactionIO.bulkInsert(toWrite);
                System.out.println("  Transaction(s) saved.");
            } catch (IOException ex) {
                System.out.println("  Error writing transactions: " + ex.getMessage());
            }

            // Ask to stay in the Add section
            String again = ValidatorIO.getString(sc, "Stay in Add Transactions? (y/n): ").trim().toLowerCase(Locale.ROOT);
            stayInAdd = again.startsWith("y");
            System.out.println();
        }
    }

    // ------------------------------------------------------------
    // Option 3: Display Total Expenses
    // ------------------------------------------------------------
    /**
     * Sums all transaction amounts and displays the result,
     * formatted per instructions using $%,6.2f.
     */
    private static void doShowTotal() {
        try {
            ArrayList<Transaction> txns = TransactionIO.findAll();
            double total = 0.0;
            for (Transaction t : txns) {
                total += t.getAmount();
            }
            System.out.printf("  Total: $%,6.2f%n", total);
        } catch (IOException ex) {
            System.out.println("  Error reading transactions: " + ex.getMessage());
        }
    }
}
