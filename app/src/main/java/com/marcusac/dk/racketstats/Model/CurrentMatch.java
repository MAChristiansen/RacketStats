package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class CurrentMatch {

    public static String currentMatchID;
    public static Match currentMatch;
    public static String currentTeam1ID;
    public static String currentTeam2ID;
    public static ArrayList<Team> currentTeams = new ArrayList<>(); //index 0 = team1, index 1 = team2
    public static ArrayList<String> currentPlayerIDs = new ArrayList<>(); // if single - index 0 = team1, index 1 = team2 ... if double - index 0,1 = team1, index 1,2 = team2
    public static ArrayList<Player> currentPlayers = new ArrayList<>(); // if single - index 0 = team1, index 1 = team2 ... if double - index 0,1 = team1, index 1,2 = team2
    public static boolean isMatchSingle;


    private static final CurrentMatch ourInstance = new CurrentMatch();

    public static CurrentMatch getInstance() {
        return ourInstance;
    }

    private CurrentMatch() {
    }
}
