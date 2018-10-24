package com.marcusac.dk.racketstats.Model;

import java.util.ArrayList;

public class Match {

    private String matchID;
    private String team1ID;
    private String team2ID;

    private ArrayList<Integer> scorePoints;
    private ArrayList<Integer> scoreGames;
    private ArrayList<Integer> scoreSets;


    private boolean isMatchTiebreak = false;
    private boolean isMatchMatchTiebreak = false;
    private boolean isMatch1Set = false;
    private boolean isMatch3Set = false;
    private boolean is3setMatchTiebreak = false;
    private boolean isMatch5Set = false;

    private boolean isMatchTournamentMatch = false;
    private boolean isMatchTeamMatch = false;
    private boolean isMatchTrainingMatch = false;

    private boolean isMatchSingle;
    private boolean matchStarted = false;
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
        this.isMatchSingle = single;
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

    public boolean isMatchSingle() {
        return isMatchSingle;
    }

    public void setMatchSingle(boolean matchSingle) {
        this.isMatchSingle = matchSingle;
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

    public boolean isMatchTiebreak() {
        return isMatchTiebreak;
    }

    public void setMatchTiebreak(boolean matchTiebreak) {
        isMatchTiebreak = matchTiebreak;
    }

    public boolean isMatchMatchTiebreak() {
        return isMatchMatchTiebreak;
    }

    public void setMatchMatchTiebreak(boolean matchMatchTiebreak) {
        isMatchMatchTiebreak = matchMatchTiebreak;
    }

    public boolean isMatch1Set() {
        return isMatch1Set;
    }

    public void setMatch1Set(boolean match1Set) {
        isMatch1Set = match1Set;
    }

    public boolean isMatch3Set() {
        return isMatch3Set;
    }

    public void setMatch3Set(boolean match3Set) {
        isMatch3Set = match3Set;
    }

    public boolean isMatch5Set() {
        return isMatch5Set;
    }

    public void setMatch5Set(boolean match5Set) {
        isMatch5Set = match5Set;
    }

    public boolean isMatchStarted() {
        return matchStarted;
    }

    public void setMatchStarted(boolean matchStarted) {
        this.matchStarted = matchStarted;
    }

    public boolean isIs3setMatchTiebreak() {
        return is3setMatchTiebreak;
    }

    public void setIs3setMatchTiebreak(boolean is3setMatchTiebreak) {
        this.is3setMatchTiebreak = is3setMatchTiebreak;
    }

    public boolean isMatchTournamentMatch() {
        return isMatchTournamentMatch;
    }

    public void setMatchTournamentMatch(boolean matchTournamentMatch) {
        isMatchTournamentMatch = matchTournamentMatch;
    }

    public boolean isMatchTeamMatch() {
        return isMatchTeamMatch;
    }

    public void setMatchTeamMatch(boolean matchTeamMatch) {
        isMatchTeamMatch = matchTeamMatch;
    }

    public boolean isMatchTrainingMatch() {
        return isMatchTrainingMatch;
    }

    public void setMatchTrainingMatch(boolean matchTrainingMatch) {
        isMatchTrainingMatch = matchTrainingMatch;
    }
}
