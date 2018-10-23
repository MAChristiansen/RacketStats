package com.marcusac.dk.racketstats.Controller;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;


public class MatchController {

    FirebaseController firebaseController = new FirebaseController();

    public void updateScoreBoardNames(final TextView tvTeam1Names, final TextView tvTeam2Names) {

        final Task<DataSnapshot> dataTask = firebaseController.getMatchInfo(CurrentMatch.currentMatchID);

        dataTask.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                Match match = task.getResult().getValue(Match.class);

                tvTeam1Names.setText(match.getTeam1ID());
                tvTeam2Names.setText(match.getTeam2ID());

            }
        });

    }

    public void updateScoreBoardScore(
                                      final TextView tvTeam1Sets, final TextView tvTeam2Sets,
                                      final TextView tvTeam1Games, final TextView tvTeam2Games,
                                      final TextView tvTeam1Points, final TextView tvTeam2Points) {

        final Task<DataSnapshot> dataTask = firebaseController.getMatchInfo(CurrentMatch.currentMatchID);

        dataTask.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                Match match = task.getResult().getValue(Match.class);

                tvTeam1Sets.setText(match.getScoreSets().get(0).toString());
                tvTeam2Sets.setText(match.getScoreSets().get(1).toString());

                tvTeam1Games.setText(match.getScoreGames().get(0).toString());
                tvTeam2Games.setText(match.getScoreGames().get(1).toString());

                tvTeam1Points.setText(match.getScorePoints().get(0).toString());
                tvTeam2Points.setText(match.getScorePoints().get(1).toString());
            }
        });

    }










    }
