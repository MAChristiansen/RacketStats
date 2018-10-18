package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class Stats {

    private String playerID;
    private String matchID;
    private ArrayList<Set> sets;

    public Stats(String playerID, String matchID, ArrayList<Set> sets) {
        this.playerID = playerID;
        this.matchID = matchID;
        this.sets = sets;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }
}
