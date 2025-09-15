package Module_2.SportTeamApp;
import java.util.*;
import java.util.Scanner;
public class TestSportsTeamApp {

    //turn the player's array back into a comma seperated string
    // for only the first playerCount entries with no spacers per the input style
    private static String playersToCommaList(Team team){
        String[] arr = team.getPlayers();
        int count = team.getPlayerCount();

        if (count == 0) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++){
            if (i > 0) sb.append(", ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    //main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean keepGoing = true;
        System.out.print(" Enter Team Name: ");
        String teamName = sc.nextLine().trim();

        Team team = new Team(teamName);
        System.out.print("  Enter player first names separated by commas with no spaces: ");

        String rawPlayers = sc.nextLine().trim();

        //split on commas and add to team
    }
}
