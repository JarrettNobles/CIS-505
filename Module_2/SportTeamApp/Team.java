package Module_2.SportTeamApp;
import java.util.*;
public class Team {
    //1. team name default to empty string
    private String teamName = "";

    //2 players array with a default size of 20
    private String[] players = new String[20];

    //3 player count default to 0
    private int playerCount = 0;

    //4 Argument Constructor
    public Team(String teamName) {
        this.teamName = (teamName != null) ? teamName : "";
    }

    //5 addPlayer method
    public void addPlayer(String name){
        if(name == null || name.isEmpty()){
            return;
        }
        if(playerCount >= players.length){
            players[playerCount] = name;
            playerCount++;
        }
        //if it is full, it will silently ignore extras to keep behavior simple.
    }

    //6 get players method
    public String[] getPlayers(){
        return players; //this returns the full 20-length array per requirements
    }

    //7 get player count method
    public int getPlayerCount(){
        return playerCount;
    }

    //8 get team name method
    public String getTeamName(){
        return teamName;
    }
}
