/*
 * Developer’s Comment (APA Citations + Author Info)
 *
 * Sources used:
 *   W3Schools.com. (n.d.). Java OOP. Retrieved September 21, 2025,
 *   from https://www.w3schools.com/java/java_oop.asp
 *
 *   W3Schools.com. (n.d.). Java Classes and Objects. Retrieved September 21, 2025,
 *   from https://www.w3schools.com/java/java_classes.asp
 *
 * Author information:
 *   Nobles, J. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
 */

package Module_2.SportTeamApp;

import java.util.Scanner;
import java.util.*;

/**
 * Test harness for the {@link Team} class.
 * <p>
 * <strong>Program flow</strong>:
 * <ol>
 *   <li>Prompt user for a team name.</li>
 *   <li>Prompt user for player first names as a single comma-separated string (no spaces).</li>
 *   <li>Split input on commas, add each name to the team (up to 20).</li>
 *   <li>Display two lines:
 *       <ul>
 *           <li>{@code "  Number of players in team <count>"}</li>
 *           <li>{@code "  Players on team: <name1,name2,...>."}</li>
 *       </ul>
 *   </li>
 *   <li>Ask if the user wants to enter another team (while loop control).</li>
 * </ol>
 * <p>
 * <strong>Formatting requirements</strong>: All output lines begin with two spaces.
 */
public class TestSportsTeamApp {

    /**
     * Converts the valid portion of the team’s internal players array (indices
     * {@code 0..playerCount-1}) into a comma-separated string with <em>no spaces</em>.
     *
     * @param team A non-null {@link Team} instance.
     * @return A comma-separated list of player names or an empty string if no players exist.
     */
    private static String playersToCommaList(Team team){
        String[] arr = team.getPlayers();
        int count = team.getPlayerCount();

        if (count == 0) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++){
            if (i > 0) sb.append(",");
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * Application entry point.
     * <p>
     * <strong>I/O</strong>: Uses {@link Scanner} for console input and prints results with
     * two-space indentation as specified. The code enforces a maximum of 20 players
     * per team and politely ignores extras.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean keepGoing = true; // While-loop sentinel controlling repeated team entry.

        // Begin user interaction loop (no executable logic changed—only comments added).
        while (keepGoing) {
            System.out.print("  Enter Team Name: ");
            String teamName = sc.nextLine().trim();

            Team team = new Team(teamName);

            System.out.print("  Enter player first names separated by commas with no spaces: ");
            String rawPlayers = sc.nextLine().trim();

            // Split on commas and add names to the team, up to the fixed capacity of 20.
            if(!rawPlayers.isEmpty()){
                String[] names = rawPlayers.split(",");
                for (String n : names){
                    String cleaned = n.trim();
                    if(!cleaned.isEmpty()){
                        if(team.getPlayerCount() < 20){
                            team.addPlayer(cleaned);
                        } else {
                            // Friendly notice when capacity is reached (still two-space padded).
                            System.out.println("  Maximum of 20 players reached. Extra names will be ignored.");
                            break;
                        }
                    }
                }
            }

            // Display required two lines with two-space indentation.
            System.out.println("  Number of players in team " + team.getPlayerCount());
            System.out.println("  Players on team: " + playersToCommaList(team) + ".");

            // Prompt to continue or exit; accept Y/y as continue, anything else exits.
            System.out.print("  Do you want to enter another team? (Y N): ");
            String answer = sc.nextLine().trim();
            keepGoing = answer.equalsIgnoreCase("Y");

            // Neat spacing between runs if the user continues.
            if(keepGoing) System.out.println();
        }

        sc.close();
    }
}