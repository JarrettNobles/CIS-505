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

        // Compare id against 1007, 1008, 1009
        if (id == 1007){
            return new Customer(
                    "Alice Johnson",
                    "123 Main St",
                    "Springfield",
                    "10007"
            );

        }//end if
        else if (id.equals(1008)) {
            return new Customer(
                    "Brian Miller",
                    "456 Oak Ave",
                    "Greenville",
                    "10008"
            );

        }//end else if
        else if (id.equals(1009)){
            return new Customer(
                    "Catherine Nguyen",
                    "789 Pine Ave",
                    "Rivertown",
                    "10009"
            );
        }//end else if
        else{
            // No match -> return default customer
            return new Customer();
        }

    }//end method
}
