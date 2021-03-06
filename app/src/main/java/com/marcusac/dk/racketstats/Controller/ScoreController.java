package com.marcusac.dk.racketstats.Controller;

import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;

public class ScoreController {

    public String updateShortScore() {

        String score;

        //show the point score
        if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak() || isSetTiebreak()) {
           score = CurrentMatch.currentMatch.getScorePoints().get(0) + " - " + CurrentMatch.currentMatch.getScorePoints().get(1);
        }
        else {
            score = convertPoints(CurrentMatch.currentMatch.getScorePoints().get(0), CurrentMatch.currentMatch.getScorePoints().get(1))
                    + " - "
                    + convertPoints(CurrentMatch.currentMatch.getScorePoints().get(1), CurrentMatch.currentMatch.getScorePoints().get(0));
        }

        //if game is done, then show the the game score
        if (score.equals("0 - 0")) {
            score = CurrentMatch.currentMatch.getScoreGames().get(0) + " - " + CurrentMatch.currentMatch.getScoreGames().get(1);
        }

        //if set is done, the show the set score
        if (score.equals("0 - 0")) {
            score = CurrentMatch.currentMatch.getScoreSets().get(0) + " - " + CurrentMatch.currentMatch.getScoreSets().get(1);
        }

        return score;

    }

    public void addPoint(int team) {
        CurrentMatch.currentMatch.getScorePoints().set(team, CurrentMatch.currentMatch.getScorePoints().get(team) + 1);

        FirebaseController.dbRefMatch.child(CurrentMatch.currentMatchID).setValue(CurrentMatch.currentMatch);
    }

    public void addGame(int team) {
        Log.i("test", "jeg er her");
        CurrentMatch.currentMatch.getScoreGames().set(team, CurrentMatch.currentMatch.getScoreGames().get(team) + 1);
        CurrentMatch.currentMatch.getScorePoints().set(0,0);
        CurrentMatch.currentMatch.getScorePoints().set(1,0);

        FirebaseController.dbRefMatch.child(CurrentMatch.currentMatchID).setValue(CurrentMatch.currentMatch);
    }

    public void addSet(int team) {
        CurrentMatch.currentMatch.getScoreSets().set(team, CurrentMatch.currentMatch.getScoreSets().get(team) + 1);
        CurrentMatch.currentMatch.getScoreGames().set(0,0);
        CurrentMatch.currentMatch.getScoreGames().set(1,0);

        FirebaseController.dbRefMatch.child(CurrentMatch.currentMatchID).setValue(CurrentMatch.currentMatch);
    }

    public void updateScoreByServ() {

        if (CurrentMatch.currentTeams.get(0).isServing()) {
            addPoint(0);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            }
            else {
                if (isSetTiebreak()) {
                    switchServingTeam();
                    if (isTiebreakDone()) {
                        addGame(0);
                        setServingTeamAfterTiebreak();
                        addSet(0);
                    }
                }
                else if (isGameDone()) {
                    addGame(0);
                    if (isSetDone()) {
                        addSet(0);
                    }
                }
            }
        }
        else {
            addPoint(1);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            }
            else {
                if (isSetTiebreak()) {
                    switchServingTeam();
                    if (isTiebreakDone()) {
                        addGame(1);
                        setServingTeamAfterTiebreak();
                        addSet(1);
                    }
                }
                else if (isGameDone()) {
                    addGame(1);
                    if (isSetDone()) {
                        addSet(1);
                    }
                }
            }
        }
    }

    public void updateScoreByDoubleFault() {

        if (CurrentMatch.currentTeams.get(0).isServing()) {
            addPoint(1);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            }
            else {
                if (isSetTiebreak()) {
                    switchServingTeam();
                    if (isTiebreakDone()) {
                        addGame(0);
                        setServingTeamAfterTiebreak();
                        addSet(0);
                    }
                }
                else if (isGameDone()) {
                    addGame(0);
                    if (isSetDone()) {
                        addSet(0);
                    }
                }
            }
        }
        else {
            addPoint(0);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            }
            else {
                if (isSetTiebreak()) {
                    switchServingTeam();
                    if (isTiebreakDone()) {
                        addGame(1);
                        setServingTeamAfterTiebreak();
                        addSet(1);
                    }
                }
                else if (isGameDone()) {
                    addGame(1);
                    if (isSetDone()) {
                        addSet(1);
                    }
                }
            }
        }
    }

    public void updateScoreByDual(int winningTeam) {

        addPoint(winningTeam);
        if (!(CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak())) {
            if (isSetTiebreak()) {
                switchServingTeam();
                if (isTiebreakDone()) {
                    addGame(winningTeam);
                    setServingTeamAfterTiebreak();
                    addSet(winningTeam);
                }
            }
            else if (isGameDone()) {
                addGame(winningTeam);
                if (isSetDone()) {
                    addSet(winningTeam);
                }
            }
        }
        else {

        }

    }


    public int setServingTeam() {
        if (CurrentMatch.currentTeams.get(0).isServing()){
            return 0;
        }
        else {
            return 1;
        }
    }

    public void setServingTeamAfterTiebreak() {
        if (((CurrentMatch.currentMatch.getScoreGames().get(0) + CurrentMatch.currentMatch.getScoreGames().get(1)) % 2) == 0) {
            switch (CurrentMatch.currentMatch.getStartedServing()) {
                case 0:
                    CurrentMatch.currentTeams.get(0).setServing(false);
                    CurrentMatch.currentTeams.get(1).setServing(true);
                    break;
                case 1:
                    CurrentMatch.currentTeams.get(1).setServing(false);
                    CurrentMatch.currentTeams.get(0).setServing(true);
            }
        }
    }

    public String convertPoints(Integer point, Integer opponent) {
        if (point < 4 && opponent < 4) {
            switch (point) {
                case 0:
                    return "0";
                case 1:
                    return "15";
                case 2:
                    return "30";
                case 3:
                    return "40";
            }
        }
        else {
            if (point > opponent) {
                return "AD";
            }
            else {
                return "40";
            }
        }
        return "";
    }

    public boolean isSetTiebreak() {
        if (CurrentMatch.currentMatch.getScoreGames().get(0) + CurrentMatch.currentMatch.getScoreGames().get(1) == 12) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isGameDone() {

        Log.i("test", CurrentMatch.currentMatch.getScorePoints().get(0) + "");
        Log.i("test", CurrentMatch.currentMatch.getScorePoints().get(1) + "");
        if (((CurrentMatch.currentMatch.getScorePoints().get(0) >= 4) && ((CurrentMatch.currentMatch.getScorePoints().get(0) - CurrentMatch.currentMatch.getScorePoints().get(1)) >=2))
                ||
            ((CurrentMatch.currentMatch.getScorePoints().get(1) >= 4) && ((CurrentMatch.currentMatch.getScorePoints().get(1) - CurrentMatch.currentMatch.getScorePoints().get(0)) >=2))) {
            if (CurrentMatch.currentTeams.get(0).isServing()){
                CurrentMatch.currentTeams.get(0).setServing(false);
                CurrentMatch.currentTeams.get(1).setServing(true);
            }
            else {
                CurrentMatch.currentTeams.get(1).setServing(false);
                CurrentMatch.currentTeams.get(0).setServing(true);
            }
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isTiebreakDone() {
        if (((CurrentMatch.currentMatch.getScorePoints().get(0) >= 7) && (CurrentMatch.currentMatch.getScorePoints().get(0) - CurrentMatch.currentMatch.getScorePoints().get(1) >= 2))
                ||
            ((CurrentMatch.currentMatch.getScorePoints().get(1) >= 7) && (CurrentMatch.currentMatch.getScorePoints().get(1) - CurrentMatch.currentMatch.getScorePoints().get(0) >= 2))) {
            return true;
        }
        else {
            return false;
        }
    }

    private void switchServingTeam() {
        Log.i("modulo", (CurrentMatch.currentMatch.getScorePoints().get(0) + CurrentMatch.currentMatch.getScorePoints().get(1)) % 2 + "");
        if ((((CurrentMatch.currentMatch.getScorePoints().get(0) + CurrentMatch.currentMatch.getScorePoints().get(1)) % 2) == 1)) {
            if (CurrentMatch.currentTeams.get(0).isServing()){
                CurrentMatch.currentTeams.get(0).setServing(false);
                CurrentMatch.currentTeams.get(1).setServing(true);
            }
            else {
                CurrentMatch.currentTeams.get(1).setServing(false);
                CurrentMatch.currentTeams.get(0).setServing(true);
            }
        }
    }

    //TODO skal laves så der kan blive spillet tiebreak
    private boolean isSetDone() {
        Log.i("Set gameScore", CurrentMatch.currentMatch.getScoreGames().get(0)
                + " "
                + CurrentMatch.currentMatch.getScoreGames().get(1));
        if (((CurrentMatch.currentMatch.getScoreGames().get(0) >= 6) && ((CurrentMatch.currentMatch.getScoreGames().get(0) - CurrentMatch.currentMatch.getScoreGames().get(1)) >=2))
            ||
            ((CurrentMatch.currentMatch.getScoreGames().get(1) >= 6) && ((CurrentMatch.currentMatch.getScoreGames().get(1) - CurrentMatch.currentMatch.getScoreGames().get(0)) >=2))) {
            return true;
        }
        else if (isSetTiebreak()) {
            if (isTiebreakDone()) {
                return true;
            }
        }
        return false;
    }
}
