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

    //TODO skal måske slettes
    public ArrayList<String> getPlayerNames() {

        ArrayList<String> names = new ArrayList<>();

        for (Player player : CurrentMatch.currentPlayers) {
            names.add(player.getName());
        }

        return names;
    }

    //TODO den skal laves om til mit eget fragment dialog...
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
