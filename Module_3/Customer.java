package Module_3;
import java.util.*;
/**
 * Customer class
 *
 * Purpose:
 *   Represent a customer with name, address, city, and zip fields.
 *
 * Constructor parameters:
 *   - No-arg constructor: creates a default customer
 *   - Argument constructor: (String name, String address, String city, String zip)
 *
 * Expected output:
 *   - toString() returns the customer's details, each field on a separate line.
 */

public class Customer {

    //Class variables
    private String name;
    private String address;
    private String city;
    private String zip;

    /**
     * No-argument constructor.
     * Purpose: create a default customer when no data is provided.
     * Default values are simple placeholders.
     */

    public Customer() {
        this.name = "Default Name";
        this.address = "Default Address";
        this.city = "Default City";
        this.zip = "00000";
    }

    /**
     * Argument constructor.
     * Purpose: create a customer using provided values.
     *
     * @param name    (String) customer name
     * @param address (String) customer address
     * @param city    (String) customer city
     * @param zip     (String) customer zip code
     */
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    //Accessor methods
    /**
     * getName
     * Purpose: return the customer's name.
     *
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * getAddress
     * Purpose: return the customer's address.
     *
     * @return String address
     */

    public String getAddress() {
        return this.address;
    }

    /**
     * getCity
     * Purpose: return the customer's city.
     *
     * @return String city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * getZip
     * Purpose: return the customer's zip code.
     *
     * @return String zip
     */
    public String getZip() {
        return this.zip;
    }

    /**
     * toString (override)
     * Purpose: return a multi-line description of the customer with each field on its own line.
     *
     * @return String containing name, address, city, zip each on separate lines
     */
    @Override
    public String toString() {
        StringBuilder lBuilder = new StringBuilder();
        lBuilder.append("Name: ").append(this.name).append(System.lineSeparator());
        lBuilder.append("Address: ").append(this.address).append(System.lineSeparator());
        lBuilder.append("City: ").append(this.city).append(System.lineSeparator());
        lBuilder.append("Zip: ").append(this.zip).append(System.lineSeparator());
        return lBuilder.toString();
    }
}
