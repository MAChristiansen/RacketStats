package com.marcusac.dk.racketstats.Controller;

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

        if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {
           score = CurrentMatch.currentMatch.getScorePoints().get(0) + " - " + CurrentMatch.currentMatch.getScorePoints().get(1);
        } else {
            score = convertPoints(CurrentMatch.currentMatch.getScorePoints().get(0)) + " - " + convertPoints(CurrentMatch.currentMatch.getScorePoints().get(1));
        }

        if (score.equals("0 - 0")) {
            score = CurrentMatch.currentMatch.getScoreGames().get(0) + " - " + CurrentMatch.currentMatch.getScoreGames().get(1);
        }

        return score;

    }

    public void addPoint(int team) {
        CurrentMatch.currentMatch.getScorePoints().set(team, CurrentMatch.currentMatch.getScorePoints().get(team) + 1);
    }

    public void addGame(int team) {
        Log.i("test", "jeg er her");
        CurrentMatch.currentMatch.getScoreGames().set(team, CurrentMatch.currentMatch.getScoreGames().get(team) + 1);
        CurrentMatch.currentMatch.getScorePoints().set(0,0);
        CurrentMatch.currentMatch.getScorePoints().set(1,0);

        FirebaseController.dbRefMatch.child(CurrentMatch.currentMatchID).setValue(CurrentMatch.currentMatch);
    }

    public void updateScoreByAce() {

        if (CurrentMatch.currentTeams.get(0).isServing()) {
            addPoint(0);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            } else {
                if (isGameDone()) {
                    addGame(0);
                }
            }
        } else {
            addPoint(1);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            } else {
                if (isGameDone()) {
                    addGame(1);
                }
            }
        }
    }

    public int setServingTeam() {
        if (CurrentMatch.currentTeams.get(0).isServing()){
            return 0;
        } else {
            return 1;
        }
    }

    public Integer convertPoints(Integer point) {
        switch (point) {
            case 0:
                return 0;
            case 1:
                return 15;
            case 2:
                return 30;
            case 3:
                return 40;
            default:
                return 0;
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
            } else {
                CurrentMatch.currentTeams.get(1).setServing(false);
                CurrentMatch.currentTeams.get(0).setServing(true);
            }
            return true;
        } else {
            return false;
        }
    }

}
