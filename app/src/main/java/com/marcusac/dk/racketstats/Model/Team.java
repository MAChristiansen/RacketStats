package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class Team {

    private String teamID;
    private ArrayList<Player> players;

    public Team(String teamID, ArrayList<Player> players) {
        this.teamID = teamID;
        this.players = players;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
