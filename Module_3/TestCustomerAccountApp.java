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
 *   - Menu choices (Integer)
 *   - Deposit/withdraw amounts (double)
 *
 * Output:
 *   - Menu prompts, operation results, final customer details, and account balance.
 */
public class TestCustomerAccountApp {

    //main method
    public static void main(String[] args) {
        Scanner lScanner = new Scanner(System.in);

        //prompt for customer number
        System.out.print("Enter a customer number (1007 - 1009): ");
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

        boolean lContinue = false;
        do{
            lAccount.displayMenu();
            System.out.print("Enter menu option (1-4): ");
            String lChoiceRaw = lScanner.nextLine().trim();
            int lChoice;
            try{
                lChoice = Integer.parseInt(lChoiceRaw);
            } catch (NumberFormatException lEx){
                System.out.println("Error: Invalid Option.");
                //Ask whether to continue
                lContinue = promptContinue(lScanner);
                continue;
            }//end catch

            switch (lChoice){
                case 1:
                    //deposit
                    System.out.print("Enter deposit amount: ");
                    double lDepositAmt = readDouble(lScanner);
                    if(lDepositAmt > 0){
                        lAccount.deposit(lDepositAmt);
                        System.out.printf("Deposit successful. Date: %s%n", lAccount.getTransactionDate());
                        System.out.printf("New balance: $%,6.2f%n", lAccount.getBalance());
                    } else{
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 2:
                    //withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double lWithdrawAmt = readDouble(lScanner);
                    if(lWithdrawAmt > 0){
                        if(lAccount.getBalance() >= lWithdrawAmt){
                            lAccount.withdraw(lWithdrawAmt);
                            System.out.printf("Withdrawal successful. Date: %s%n", lAccount.getTransactionDate());
                            System.out.printf("New balance: $%,6.2f%n", lAccount.getBalance());
                        } else{
                            System.out.println("Error: Insufficient funds.");
                            System.out.printf("Current balance: $%,6.2f%n", lAccount.getBalance());
                        }
                    } else{
                        System.out.println("Invalid withdrawal amount.");
                    }
                    break;

                case 3:
                    //Balance
                    System.out.printf("Current balance: $%,6.2f%n", lAccount.getBalance());
                    break;

                case 4:
                    //Exit
                    lContinue = false;
                    break;

                default:
                    System.out.println("Error: Invalid Option.");
                    break;
            }

            //if choice was not exit (4), ask to continue
            if(lChoice != 4){
                lContinue = promptContinue(lScanner);
            }

        } while (lContinue);
        // After exiting the menu, display customer details and account balance
        System.out.println();
        System.out.println("Customer Details:");
        System.out.println(lCustomer.toString());
        System.out.printf("Account Balance: $%,6.2f%n", lAccount.getBalance());
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
     * Purpose: Ask the user whether they want to continue (Y/N). Returns true for yes.
     *
     * @param lScanner Scanner object used for input
     * @return boolean true if user wants to continue, false otherwise
     */
    private static boolean promptContinue(Scanner lScanner){
        System.out.print("Continue? (Y/N): ");
        String lInput = lScanner.nextLine().trim().toUpperCase();
        if(lInput.equals("Y") || lInput.equals("Yes")){
            return true;
        } else{
            return false;
        }
    }
}//end class
