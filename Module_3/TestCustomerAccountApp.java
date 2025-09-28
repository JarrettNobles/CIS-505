//TestCustomerAccountApp.java
package Module_3;
import java.util.*;
import java.util.Scanner;
/**
 * TestCustomerAccountApp
 *
 * Purpose:
 *   Console application to test Customer, CustomerDB, and Account classes.
 *   Prompts the user for a customer number (1007-1009), shows the account menu,
 *   handles deposit/withdraw/balance operations, and prints final customer details.
 *
 * Input:
 *   - Customer number (Integer)
 *   - Menu choices (String: D/d, W/w, B/b) to match assignment
 *   - Deposit/withdraw amounts (double)
 *
 * Output:
 *   - Prompts, operation results, "Continue? (y/n): " loop,
 *     and final customer details with balance/date, matching the screenshots.
 */
public class TestCustomerAccountApp {

    //main method
    public static void main(String[] args) {
        Scanner lScanner = new Scanner(System.in);

        // Intro block exactly like Figure 4.5
        System.out.println("Welcome to the Customer Account App");
        System.out.println();
        System.out.println("Enter a customer ID:");
        System.out.print("ex: 1007, 1008, 1009>: ");

        //prompt for customer number
        Integer lCustomerId = null;
        try{
            lCustomerId = Integer.parseInt(lScanner.nextLine().trim());
        } catch (NumberFormatException lEx){
            System.out.println("Invalid number entered. Default customer will be used");
        }//end try-catch

        //retrieve customer from database
        Customer lCustomer = CustomerDB.getCustomer(lCustomerId);

        //create account for the customer
        Account lAccount = new Account();

        boolean lContinue;
        do{
            // Display the D/W/B menu and read a case-insensitive option
            lAccount.displayMenu();
            String lChoice = lScanner.nextLine().trim();

            if (lChoice.equalsIgnoreCase("b")) {
                // Balance: formatted as in the screenshots
                System.out.println();
                System.out.printf("Account balance: $%,.2f%n", lAccount.getBalance());
            }
            else if (lChoice.equalsIgnoreCase("d")) {
                //deposit
                System.out.println();
                System.out.print("Enter deposit amount: ");
                double lDepositAmt = readDouble(lScanner);
                if(lDepositAmt > 0){
                    lAccount.deposit(lDepositAmt);
                } else{
                    System.out.println("Invalid deposit amount.");
                }
            }
            else if (lChoice.equalsIgnoreCase("w")) {
                //withdraw
                System.out.println();
                System.out.print("Enter withdraw amount: ");
                double lWithdrawAmt = readDouble(lScanner);
                if(lWithdrawAmt > 0 && lAccount.getBalance() >= lWithdrawAmt){
                    lAccount.withdraw(lWithdrawAmt);
                } else if (lWithdrawAmt <= 0) {
                    System.out.println("Invalid withdraw amount.");
                } else {
                    System.out.println("Insufficient funds.");
                }
            }
            else {
                // Invalid option message should match the figure
                System.out.println();
                System.out.println("Error: Invalid option");
            }

            //Ask whether to continue (matches "Continue? (y/n): ")
            lContinue = promptContinue(lScanner);

        } while (lContinue);

        // After exiting the menu, display customer details and account balance/date
        System.out.println();
        System.out.println("--Customer Details--");
        System.out.print(lCustomer.toString()); // already includes newlines per field
        System.out.println();
        System.out.printf("Balance as of %s is $%,.2f%n",
                lAccount.getTransactionDate(), lAccount.getBalance());
        System.out.println();
        System.out.println("End of line...");

        lScanner.close();
    }//end main method

    /**
     * readDouble
     * Purpose: safely read a double from the scanner. Returns -1 if invalid.
     *
     * @param lScanner Scanner object from which to read
     * @return double value read or -1 if invalid
     */
    private static double readDouble(Scanner lScanner){
        String lInput = lScanner.nextLine().trim();
        try{
            return Double.parseDouble(lInput);
        } catch (NumberFormatException lEx){
            return -1;
        }//end try catch
    }//end readDouble method

    /**
     * promptContinue
     * Purpose: Ask the user whether they want to continue (y/n). Returns true for yes.
     * Matches the assignment's exact prompt and accepts y/yes in any case.
     *
     * @param lScanner Scanner object used for input
     * @return boolean true if user wants to continue, false otherwise
     */
    private static boolean promptContinue(Scanner lScanner){
        System.out.print("Continue? (y/n): ");
        String lInput = lScanner.nextLine().trim();
        return lInput.equalsIgnoreCase("y") || lInput.equalsIgnoreCase("yes");
    }
}//end class
