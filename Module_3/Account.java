package Module_3;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Account class
 *
 * Purpose:
 *   Represent a simple bank account with a balance, deposit, withdraw,
 *   menu display, and transaction date retrieval.
 *
 * Fields:
 *   - private double balance (default 200)
 *
 * Methods:
 *   - getBalance(): returns current balance
 *   - deposit(double amt): increases the balance by amt
 *   - withdraw(double amt): decreases the balance by amt if sufficient funds
 *   - displayMenu(): prints the account menu
 *   - getTransactionDate(): returns the current date as MM-dd-yyyy
 *
 * Note:
 *   - Currency printing should be handled by the caller using printf("$%,6.2f")
 */
public class Account {
    // Private data field for balance; default value is 200
    private double balance = 200.0;

    /**
     * getBalance
     * Purpose: Return current account balance.
     *
     * @return double current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * deposit
     * Purpose: Add the specified amount to the account balance.
     *
     * @param amt (double) amount to deposit; expected > 0
     *            If negative or zero, method will not change balance.
     * @return void
     */

    public void deposit(double amt) {
        if (amt > 0) {
            this.balance += amt;
        } else{
            // Guard: negative deposit amount -> no change to balance
            System.out.println("Invalid deposit amount.");
        }//end else
    }//end deposit method

    /**
     * withdraw
     * Purpose: Withdraw the specified amount from the account if funds are sufficient.
     *
     * @param amt (double) amount to withdraw; expected > 0
     *            If amt <= balance, subtracts amt; otherwise does nothing.
     * @return void
     */
    public void withdraw(double amt){
        if(amt >0 && this.balance >= amt){
            this.balance -= amt;
        } else{
            System.out.println("Insufficient funds.");
        }//end else
    }//end withdraw method

    /**
     * displayMenu
     * Purpose: Print the account menu to the console that matches the expected format.
     *
     * Example output:
     *   1. Deposit
     *   2. Withdraw
     *   3. Balance
     *   4. Exit
     *
     * @return void
     */

    public void displayMenu(){
        System.out.println();
        System.out.println("Account Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance");
        System.out.println("4. Exit");
        System.out.println();
    }//end displayMenu method

    /**
     * getTransactionDate
     * Purpose: Return the current date as a String in the format MM-dd-yyyy.
     *
     * @return String date formatted as MM-dd-yyyy
     */
    public String getTransactionDate() {
        LocalDate lToday = LocalDate.now();
        DateTimeFormatter lFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return lToday.format(lFormatter);
    }//end getTransactionDate method
}//end Account class
