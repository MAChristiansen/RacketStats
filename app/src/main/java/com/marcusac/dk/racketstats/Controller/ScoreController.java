package com.marcusac.dk.racketstats.Controller;

import android.widget.TextView;

import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;

public class ScoreController {

    public void updateScore(TextView tvTeam1Sets, TextView tvTeam2Sets,
                            TextView tvTeam1Games, TextView tvTeam2Games,
                            TextView tvTeam1Points, TextView tvTeam2Points) {

        if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {
            tvTeam1Points.setText(CurrentMatch.currentMatch.getScorePoints().get(0).toString());
            tvTeam2Points.setText(CurrentMatch.currentMatch.getScorePoints().get(1).toString());
        } else {
            tvTeam1Points.setText(convertPoints(CurrentMatch.currentMatch.getScorePoints().get(0)) + "");
            tvTeam2Points.setText(convertPoints(CurrentMatch.currentMatch.getScorePoints().get(1)) + "");

        }


    }

    public void updateShortScore(TextView tv1) {

        String score = convertPoints(CurrentMatch.currentMatch.getScorePoints().get(0)) + " - " + convertPoints(CurrentMatch.currentMatch.getScorePoints().get(1));
        tv1.setText(score);

    }

    public void addPoint(int team) {

        CurrentMatch.currentMatch.getScorePoints().set(team, CurrentMatch.currentMatch.getScorePoints().get(team) + 1);

    }

    public void updateScoreByAce() {

        if (CurrentMatch.currentTeams.get(0).isServing()) {
            addPoint(0);
        } else {
            addPoint(1);
        }
    }

    public int convertPoints(int point) {

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




}
