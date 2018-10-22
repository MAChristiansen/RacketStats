package com.marcusac.dk.racketstats.Model;

public class CurrentMatch {

    public static String currentMatchID;
    public static String currentTeam1ID;
    public static String currentTeam2ID;

    private static final CurrentMatch ourInstance = new CurrentMatch();

    public static CurrentMatch getInstance() {
        return ourInstance;
    }

    private CurrentMatch() {
    }
}
