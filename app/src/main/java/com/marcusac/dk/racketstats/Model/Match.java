package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class Match {

    private String matchID;
    private String team1ID;
    private String team2ID;
    private ArrayList<String> scores;

    public Match(String matchID, String team1ID, String team2ID, ArrayList<String> scores) {
        this.matchID = matchID;
        this.team1ID = team1ID;
        this.team2ID = team2ID;
        this.scores = scores;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getTeam1ID() {
        return team1ID;
    }

    public void setTeam1ID(String team1ID) {
        this.team1ID = team1ID;
    }

    public String getTeam2ID() {
        return team2ID;
    }

    public void setTeam2ID(String team2ID) {
        this.team2ID = team2ID;
    }

    public ArrayList<String> getScores() {
        return scores;
    }

    public void setScores(ArrayList<String> scores) {
        this.scores = scores;
    }
}
