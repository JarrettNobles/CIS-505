package Module_8;
/*
 * ------------------------------------------------------------
 * Program: Enhanced Future Value App (Week 8)
 * File: FinanceCalculator.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-11-02
 * Description:
 *   Helper with a static method to calculate future value.
 *
 *   Formula:
 *     MONTHS_IN_YEAR = 12
 *     months       = years * MONTHS_IN_YEAR
 *     interestRate = 1 + (rate / 100)
 *     presentValue = monthlyPayment * months
 *     futureValue  = presentValue * Math.pow(interestRate, months)
 * ------------------------------------------------------------
 */
public class FinanceCalculator {

    private static final int MONTHS_IN_YEAR = 12;

    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = years * MONTHS_IN_YEAR;
        double interestRate = 1 + (rate / 100.0);
        double presentValue = monthlyPayment * months;
        return presentValue * Math.pow(interestRate, months);
    }
}
