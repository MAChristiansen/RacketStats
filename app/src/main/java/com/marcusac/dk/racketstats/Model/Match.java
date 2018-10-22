package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class Match {

    private String matchID;
    private String team1ID;
    private String team2ID;

    private ArrayList<Integer> scorePoints;
    private ArrayList<Integer> scoreGames;
    private ArrayList<Integer> scoreSets;

    private boolean single;
    private boolean matchDone = false;

    public Match(String matchID,
                 String team1ID,
                 String team2ID,
                 ArrayList<Integer> scorePoints,
                 ArrayList<Integer> scoreGames,
                 ArrayList<Integer> scoreSets,
                 boolean single) {

        this.matchID = matchID;
        this.team1ID = team1ID;
        this.team2ID = team2ID;
        this.scorePoints = scorePoints;
        this.scoreGames = scoreGames;
        this.scoreSets = scoreSets;
        this.single = single;
    }

    public Match(){}

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

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public ArrayList<Integer> getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(ArrayList<Integer> scorePoints) {
        this.scorePoints = scorePoints;
    }

    public ArrayList<Integer> getScoreGames() {
        return scoreGames;
    }

    public void setScoreGames(ArrayList<Integer> scoreGames) {
        this.scoreGames = scoreGames;
    }

    public ArrayList<Integer> getScoreSets() {
        return scoreSets;
    }

    public void setScoreSets(ArrayList<Integer> scoreSets) {
        this.scoreSets = scoreSets;
    }

    public boolean isMatchDone() {
        return matchDone;
    }

    public void setMatchDone(boolean matchDone) {
        this.matchDone = matchDone;
    }
}
