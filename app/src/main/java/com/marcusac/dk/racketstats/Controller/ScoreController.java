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

    public void updateScoreByAce(ImageView iv1, ImageView iv2) {

        if (CurrentMatch.currentTeams.get(0).isServing()) {
            addPoint(0);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            } else {
                if (isGameDone(CurrentMatch.currentMatch.getScorePoints().get(0), CurrentMatch.currentMatch.getScorePoints().get(1))) {
                    addGame(0);
                    setServingTeam(iv1, iv2);
                }
            }
        } else {
            addPoint(1);

            if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {

            } else {
                if (isGameDone(CurrentMatch.currentMatch.getScorePoints().get(0), CurrentMatch.currentMatch.getScorePoints().get(1))) {
                    addGame(1);
                    setServingTeam(iv1, iv2);
                }
            }
        }
    }

    private void setServingTeam(ImageView iv1, ImageView iv2) {
        if (CurrentMatch.currentTeams.get(0).isServing()){
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.INVISIBLE);
        } else {
            iv2.setVisibility(View.VISIBLE);
            iv1.setVisibility(View.INVISIBLE);
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

    private boolean isGameDone(int team1Score, int team2Score) {

        Log.i("test", team1Score + "");
        Log.i("test", team2Score + "");
        if (((team1Score >= 4) && ((team1Score - team2Score) >=2)) || ((team2Score >= 4) && ((team2Score - team1Score) >=2))) {
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
