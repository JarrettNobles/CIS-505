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
import java.util.*;
/**
 * The {@code Team} class models a simple sports team with a fixed-capacity roster.
 * <p>
 * <strong>Responsibilities</strong>:
 * <ul>
 *   <li>Store the team’s name.</li>
 *   <li>Maintain an array of up to 20 player names.</li>
 *   <li>Track how many players have been added.</li>
 * </ul>
 *
 * <strong>Key Invariants</strong>:
 * <ul>
 *   <li>{@code playerCount} is always in the range {@code 0..players.length}.</li>
 *   <li>Only the first {@code playerCount} elements in {@code players} contain valid names.</li>
 * </ul>
 */
public class Team {
    // 1) Team name. Defaults to empty string when not provided.
    private String teamName = "";

    // 2) Fixed-capacity array of player names (max 20 players).
    //    Only indices [0..playerCount-1] are valid/used.
    private String[] players = new String[20];

    // 3) Number of currently assigned players. Defaults to 0.
    private int playerCount = 0;

    /**
     * 4) Constructs a {@code Team} with the specified team name.
     *
     * @param teamName The name for this team; if {@code null}, an empty string is used.
     */
    public Team(String teamName) {
        this.teamName = (teamName != null) ? teamName : "";
    }

    /**
     * 5) Adds a player to the {@code players} array if capacity allows.
     * <p>
     * <strong>Parameters</strong>:
     * <ul>
     *   <li>{@code name} — A non-null, non-empty player name.</li>
     * </ul>
     * <strong>Behavior</strong>:
     * <ul>
     *   <li>Stores the name at index {@code playerCount}.</li>
     *   <li>Increments {@code playerCount} by one.</li>
     *   <li>Silently ignores the request if the roster is already full.</li>
     * </ul>
     */
    public void addPlayer(String name){
        if (name == null || name.isEmpty()) return;

        // Add while capacity remains (no code changes—this is the original fixed version).
        if (playerCount < players.length) {
            players[playerCount] = name;
            playerCount++;
        }
        // If full, extras are ignored to keep behavior simple.
    }

    /**
     * 6) Returns the underlying players array (capacity 20).
     * <p><strong>Note:</strong> Only the first {@code playerCount} entries are valid.
     *
     * @return The full 20-length {@code String[]} roster array.
     */
    public String[] getPlayers(){
        return players;
    }

    /**
     * 7) Returns the number of valid players currently on the team.
     *
     * @return The current {@code playerCount}.
     */
    public int getPlayerCount(){
        return playerCount;
    }

    /**
     * 8) Returns the team name.
     *
     * @return {@code teamName} for this team.
     */
    public String getTeamName(){
        return teamName;
    }
}