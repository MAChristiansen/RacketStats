package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class Team {

    private String teamID;
    private ArrayList<String> playerIDs;
    private boolean serving = false;

    public Team(String teamID, ArrayList<String> playerIDs) {
        this.teamID = teamID;
        this.playerIDs = playerIDs;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public ArrayList<String> getPlayerIDs() {
        return playerIDs;
    }

    public void setPlayerIDs(ArrayList<String> playerIDs) {
        this.playerIDs = playerIDs;
    }

    public boolean isServing() {
        return serving;
    }

    public void setServing(boolean serving) {
        this.serving = serving;
    }
}
