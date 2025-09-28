//customerDB.java
package Module_3;
import java.util.*;
/**
 * CustomerDB class
 *
 * Purpose:
 *   Provide a static getCustomer(Integer id) method that returns a Customer
 *   for ids 1007, 1008, 1009; otherwise return a default Customer.
 *
 * Parameters:
 *   - getCustomer(Integer id) where id is an Integer representing the customer number.
 *
 * Expected output:
 *   - A Customer object corresponding to the id, or the default Customer if not found.
 *
 * Note:
 *   - Record values (names/addresses) are aligned with the assignment's screenshots,
 *     e.g., id 1007 -> "Jennifer Patterson" at "8422 Grover Ave., Bellevue 68123".
 */
public class CustomerDB {
    /**
     * getCustomer
     *
     * @param id (Integer) customer id to lookup
     * @return Customer matching id, or default Customer if no match
     */
    public static Customer getCustomer(Integer id) {
        if (id == null){
            // Guard: null id -> default customer
            return new Customer();
        }//end if

        // Compare id against 1007, 1008, 1009 (values chosen to match expected output)
        if (id.equals(1007)){
            return new Customer(
                    "Jennifer Patterson",
                    "8422 Grover Ave.",
                    "Bellevue",
                    "68123"
            );
        }//end if
        else if (id.equals(1008)) {
            return new Customer(
                    "John Smith",
                    "1010 Maple St.",
                    "Omaha",
                    "68154"
            );
        }//end else if
        else if (id.equals(1009)){
            return new Customer(
                    "Ava Johnson",
                    "55 Pine Ct.",
                    "Lincoln",
                    "68502"
            );
        }//end else if
        else{
            // No match -> return default customer
            return new Customer();
        }
    }//end method
}

