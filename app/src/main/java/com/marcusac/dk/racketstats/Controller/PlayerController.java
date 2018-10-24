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

    public void createMatch(int matchForm, int matchType, boolean match3setTiebreak) {

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

        Match match = new Match(matchID, CurrentMatch.currentTeam1ID, CurrentMatch.currentTeam2ID, scorePoints, scoreGames, scoreSets, CurrentMatch.isMatchSingle);

        setMatchFormAndType(match, matchForm, matchType);
        match.setIs3setMatchTiebreak(match3setTiebreak);

        CurrentMatch.currentMatchID = matchID;
        CurrentMatch.currentMatch = match;

        dbRefMatch.child(matchID).setValue(match);

    }

    private void generatePlayer(String playerName, ArrayList<String> playerIDs) {
        String playerID = dbRefPlayer.push().getKey();
        Player newPlayer = new Player(playerID, playerName);
        dbRefPlayer.child(playerID).setValue(newPlayer);

        playerIDs.add(playerID);

        CurrentMatch.currentPlayers.add(newPlayer);
        CurrentMatch.currentPlayerIDs.add(playerID);
    }

    private void generateTeam(ArrayList<String> playerIDs) {

        String teamID = dbRefTeam.push().getKey();
        Team newTeam = new Team(teamID, playerIDs);
        dbRefTeam.child(teamID).setValue(newTeam);

        CurrentMatch.currentTeams.add(newTeam);

        if (CurrentMatch.currentTeam1ID == null) {
            CurrentMatch.currentTeam1ID = teamID;
        } else {
            CurrentMatch.currentTeam2ID = teamID;
        }

    }

    private void setMatchFormAndType(Match match, int matchForm, int matchType) {

        switch (matchForm) {
            case 1 :
                match.setMatch1Set(true);
                break;
            case 2 :
                match.setMatch3Set(true);
                break;
            case 3 :
                match.setMatch5Set(true);
                break;
            case 4 :
                match.setMatchTiebreak(true);
                break;
            case 5 :
                match.setMatchMatchTiebreak(true);
                break;
        }

        switch (matchType) {
            case 1:
                match.setMatchTournamentMatch(true);
                break;
            case 2:
                match.setMatchTeamMatch(true);
                break;
            case 3:
                match.setMatchTrainingMatch(true);
                break;
        }
    }


}
