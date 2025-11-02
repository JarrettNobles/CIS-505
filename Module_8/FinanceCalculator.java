package Module_8;
/*
 * ------------------------------------------------------------
 * Program: Enhanced Future Value (Assignment 8.2)
 * File: FinanceCalculator.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-11-02
 * Description:
 *   Provides finance-related helper methods for the Enhanced
 *   Future Value application, including a static method to
 *   calculate future value based on assignment requirements.
 *
 *   Calculation details (per assignment):
 *     - MONTHS_IN_YEAR = 12
 *     - months = years * MONTHS_IN_YEAR
 *     - interestRate = (1 + rate / 100)
 *     - presentValue = monthlyPayment * months
 *     - futureValue = presentValue * Math.pow(interestRate, months)
 * ------------------------------------------------------------
 */

public class FinanceCalculator {

    // Required: private static MONTHS_IN_YEAR = 12
    private static final int MONTHS_IN_YEAR = 12;

    /**
     * Calculates the future value using the specified formula.
     *
     * @param monthlyPayment the user's monthly payment amount
     * @param rate           the annual interest rate (percent, e.g., 5.0 for 5%)
     * @param years          the number of years
     * @return the calculated future value
     */
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = years * MONTHS_IN_YEAR;
        double interestRate = (1 + (rate / 100.0));
        double presentValue = monthlyPayment * months;
        return presentValue * Math.pow(interestRate, months);
    }//end calculateFutureValue method
}//end class
