package com.marcusac.dk.racketstats.Controller;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;
import com.marcusac.dk.racketstats.Model.Player;

import java.util.ArrayList;


public class MatchController {

    FirebaseController firebaseController = new FirebaseController();

    public void clearCurrentMatch() {}

    public void updateScoreBoardScore(
                                      TextView tvTeam1Sets, TextView tvTeam2Sets,
                                      TextView tvTeam1Games, TextView tvTeam2Games,
                                      TextView tvTeam1Points, TextView tvTeam2Points,
                                      TextView tvSets, TextView tvGames) {

        if (CurrentMatch.currentMatch.isMatchMatchTiebreak() || CurrentMatch.currentMatch.isMatchTiebreak()) {

            tvTeam1Points.setText(CurrentMatch.currentMatch.getScorePoints().get(0).toString());
            tvTeam2Points.setText(CurrentMatch.currentMatch.getScorePoints().get(1).toString());

            tvTeam1Games.setVisibility(View.GONE);
            tvTeam2Games.setVisibility(View.GONE);
            tvGames.setVisibility(View.GONE);

            tvTeam1Sets.setVisibility(View.GONE);
            tvTeam2Sets.setVisibility(View.GONE);
            tvSets.setVisibility(View.GONE);

        }
        else if (CurrentMatch.currentMatch.isMatch1Set()) {

            tvTeam1Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(0).toString());
            tvTeam2Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(1).toString());

            tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(0).toString());
            tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(1).toString());

            tvTeam1Sets.setVisibility(View.GONE);
            tvTeam2Sets.setVisibility(View.GONE);
            tvSets.setVisibility(View.GONE);

        } else {

            tvTeam1Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(0).toString());
            tvTeam2Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(1).toString());

            tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(0).toString());
            tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(1).toString());

            tvTeam1Points.setText(CurrentMatch.currentMatch.getScorePoints().get(0).toString());
            tvTeam2Points.setText(CurrentMatch.currentMatch.getScorePoints().get(1).toString());
        }

    }

    public void setPlayerNamesToTextViews(TextView tv1, TextView tv2) {

        if (CurrentMatch.isMatchSingle) {
            tv1.setText(CurrentMatch.currentPlayers.get(0).getName());
            tv2.setText(CurrentMatch.currentPlayers.get(1).getName());

        } else {

            tv1.setText(CurrentMatch.currentPlayers.get(0).getName() + " / " + CurrentMatch.currentPlayers.get(1).getName());
            tv2.setText(CurrentMatch.currentPlayers.get(2).getName() + " / " + CurrentMatch.currentPlayers.get(3).getName());
        }

    }

    public void setPlayerNamesToBtns(Button btn1, Button btn2) {

        if (CurrentMatch.isMatchSingle) {
            btn1.setText(CurrentMatch.currentPlayers.get(0).getName());
            btn2.setText(CurrentMatch.currentPlayers.get(1).getName());

        } else {

            btn1.setText(CurrentMatch.currentPlayers.get(0).getName() + " / " + CurrentMatch.currentPlayers.get(1).getName());
            btn2.setText(CurrentMatch.currentPlayers.get(2).getName() + " / " + CurrentMatch.currentPlayers.get(3).getName());
        }

    }

    public ArrayList<String> getPlayerNames() {

        ArrayList<String> names = new ArrayList<>();

        for (Player player : CurrentMatch.currentPlayers) {
            names.add(player.getName());
        }

        return names;
    }

    public void whoStartsServing(Context context, final ImageView iv1, final ImageView iv2) {
        CharSequence[] names = getPlayerNames().toArray(new CharSequence[getPlayerNames().size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Who starts serving?")
                .setItems(names, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (CurrentMatch.isMatchSingle) {
                            if (which == 0) {
                                CurrentMatch.currentTeams.get(0).setServing(true);
                                CurrentMatch.currentPlayers.get(0).setServing(true);
                            } else {
                                CurrentMatch.currentTeams.get(1).setServing(true);
                                CurrentMatch.currentPlayers.get(1).setServing(true);
                            }

                            if (CurrentMatch.currentTeams.get(0).isServing()) {
                                iv1.setVisibility(View.VISIBLE);
                            } else {
                                iv2.setVisibility(View.VISIBLE);
                            }
                        } else {
                            if (which == 0 || which == 1) {
                                CurrentMatch.currentTeams.get(0).setServing(true);
                                if (which == 0) {
                                    CurrentMatch.currentPlayers.get(0).setServing(true);
                                } else {
                                    CurrentMatch.currentPlayers.get(1).setServing(true);
                                }

                                if (CurrentMatch.currentTeams.get(0).isServing()) {
                                    iv1.setVisibility(View.VISIBLE);
                                } else {
                                    iv2.setVisibility(View.VISIBLE);
                                }
                            } else {
                                CurrentMatch.currentTeams.get(1).setServing(true);
                                if (which == 2) {
                                    CurrentMatch.currentPlayers.get(2).setServing(true);
                                } else {
                                    CurrentMatch.currentPlayers.get(3).setServing(true);
                                }

                                if (CurrentMatch.currentTeams.get(0).isServing()) {
                                    iv1.setVisibility(View.VISIBLE);
                                } else {
                                    iv2.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                    }
                });
        builder.create();
        builder.show();

    }


    }
