package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class Stats {

    private String playerID;
    private String matchID;
    private ArrayList<SetStats> sets;

    public Stats(String playerID, String matchID, ArrayList<SetStats> sets) {
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

    public ArrayList<SetStats> getSets() {
        return sets;
    }

    public void setSets(ArrayList<SetStats> sets) {
        this.sets = sets;
    }
}
