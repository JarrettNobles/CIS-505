package Module_5;
//imports
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Class: CIS 505
 * Module: 5
 * File: TransactionIO.java
 * Author: Jarrett Nobles
 * Date: 10/08/2025
 * Description:
 *   Handles file input and output operations for Transaction objects.
 *   Provides methods to write multiple transactions to a text file
 *   and to read all stored transactions back into an ArrayList.
 */
public class TransactionIO {
    //data fields
    private static final String FILE_NAME = "expenses.txt";
    private static final File file = new File(FILE_NAME);

    //bulk insert method
    /**
     * Writes a list of Transaction objects to the expenses.txt file.
     * @param transactions ArrayList of Transaction objects to be written
     * @throws IOException if file cannot be accessed or written
     */
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;

        // Use append mode if file exists, otherwise create a new file
        if (file.exists()) {
            output = new PrintWriter(new java.io.FileOutputStream(file, true));
        } else {
            output = new PrintWriter(file);
        }

        // Write each transaction to the file
        for (Transaction t : transactions) {
            output.printf("%s|%s|%.2f%n", t.getDate(), t.getDescription(), t.getAmount());
        }

        output.close();
    }

    //find all method
    /**
     * Reads all Transaction objects from the expenses.txt file.
     * @return ArrayList of Transaction objects
     * @throws IOException if file cannot be accessed or read
     */
    public static ArrayList<Transaction> findAll() throws IOException{
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (!file.exists()) {
            return transactions; // Return empty list if file doesn't exist yet
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] parts = line.split("\\|");
            if (parts.length == 3) {
                String date = parts[0];
                String description = parts[1];
                double amount = Double.parseDouble(parts[2]);
                Transaction t = new Transaction(date, description, amount);
                transactions.add(t);
            }

        }
        input.close();
        return transactions;

    }

}//end class
