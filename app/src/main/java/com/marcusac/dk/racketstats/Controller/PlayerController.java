package com.marcusac.dk.racketstats.Controller;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;
import com.marcusac.dk.racketstats.Model.Player;
import com.marcusac.dk.racketstats.Model.Team;

import java.util.ArrayList;

import static com.marcusac.dk.racketstats.Controller.FirebaseController.dbRefMatch;
import static com.marcusac.dk.racketstats.Controller.FirebaseController.dbRefPlayer;
import static com.marcusac.dk.racketstats.Controller.FirebaseController.dbRefTeam;

public class PlayerController {

    FirebaseController firebaseController = new FirebaseController();

    public void setTestPlayerData(final TextView view) {

        final Task<DataSnapshot> dataTask = firebaseController.getTestPlayerData();

        dataTask.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> dataSnapshotTask) {

            }
        });
    }


    public void savePlayer() {
    }

    public void saveSingleTeam(String playerName) {

        ArrayList<String> playerIDs = new ArrayList<>();

        generatePlayer(playerName, playerIDs);

        generateTeam(playerIDs);
    }

    public void saveDoubleTeam(String player1Name, String player2Name) {

        ArrayList<String> playerIDs = new ArrayList<>();

        generatePlayer(player1Name, playerIDs);
        generatePlayer(player2Name, playerIDs);

        generateTeam(playerIDs);
    }

    public void createMatch(boolean isMatchSingle) {

        ArrayList<Integer> scorePoints = new ArrayList<>();
        scorePoints.add(0);
        scorePoints.add(0);
        ArrayList<Integer> scoreGames = new ArrayList<>();
        scoreGames.add(0);
        scoreGames.add(0);
        ArrayList<Integer> scoreSets = new ArrayList<>();
        scoreSets.add(0);
        scoreSets.add(0);

        String matchID = dbRefMatch.push().getKey();

        Match match = new Match(matchID, CurrentMatch.currentTeam1ID, CurrentMatch.currentTeam2ID, scorePoints, scoreGames, scoreSets, isMatchSingle);

        dbRefMatch.child(matchID).setValue(match);

    }

    private void generatePlayer(String playerName, ArrayList<String> playerIDs) {
        String playerID = dbRefPlayer.push().getKey();
        Player newPlayer = new Player(playerID, playerName);
        dbRefPlayer.child(playerID).setValue(newPlayer);

        playerIDs.add(playerID);
    }

    private void generateTeam(ArrayList<String> playerIDs) {

        String teamID = dbRefTeam.push().getKey();
        Team newTeam = new Team(teamID, playerIDs);
        dbRefTeam.child(teamID).setValue(newTeam);

        if (CurrentMatch.currentTeam1ID == null) {
            CurrentMatch.currentTeam1ID = teamID;
        } else {
            CurrentMatch.currentTeam2ID = teamID;
        }

    }

}
