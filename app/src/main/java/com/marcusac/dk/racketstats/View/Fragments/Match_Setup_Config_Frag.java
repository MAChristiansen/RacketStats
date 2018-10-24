package com.marcusac.dk.racketstats.View.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marcusac.dk.racketstats.Controller.PlayerController;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.R;
import com.marcusac.dk.racketstats.View.Activities.Match_Act;

/**
 * A simple {@link Fragment} subclass.
 */
public class Match_Setup_Config_Frag extends Fragment implements View.OnClickListener {

    PlayerController playerController = new PlayerController();

    private String team1Player1;
    private String team2Player1;
    private String team1Player2;
    private String team2Player2;
    private Button btn1set;
    private Button btn3set;
    private Button btn5set;
    private Button btnMatchTiebreak;
    private Button btnTiebreak;
    private Button btnTournamentMatch;
    private Button btnTeamMatch;
    private Button btnTrainingMatch;
    private FloatingActionButton btnContinue;
    private int matchFormClick;
    private int matchTypeClick;
    private boolean match3setTiebreak;

    public Match_Setup_Config_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_match__setup__config_, container, false);

        btn1set = root.findViewById(R.id.btn1set);
        btn3set = root.findViewById(R.id.btn3sets);
        btn5set = root.findViewById(R.id.btn5sets);
        btnTiebreak = root.findViewById(R.id.btnTiebreak);
        btnMatchTiebreak = root.findViewById(R.id.btnMatchTiebreak);

        btnTournamentMatch = root.findViewById(R.id.btnTournamentMatch);
        btnTeamMatch = root.findViewById(R.id.btnTeamMatch);
        btnTrainingMatch = root.findViewById(R.id.btnTrainingMatch);

        btnContinue = root.findViewById(R.id.btnContinue3);

        if (CurrentMatch.isMatchSingle) {
            team1Player1 = getArguments().getString("team1Player1");
            team2Player1 = getArguments().getString("team2Player1");
        } else {
            team1Player1 = getArguments().getString("team1Player1");
            team1Player2 = getArguments().getString("team1Player2");
            team2Player1 = getArguments().getString("team2Player1");
            team2Player2 = getArguments().getString("team2Player2");
        }


        btn1set.setOnClickListener(this);
        btn3set.setOnClickListener(this);
        btn5set.setOnClickListener(this);
        btnMatchTiebreak.setOnClickListener(this);
        btnTiebreak.setOnClickListener(this);
        btnTournamentMatch.setOnClickListener(this);
        btnTeamMatch.setOnClickListener(this);
        btnTrainingMatch.setOnClickListener(this);
        btnContinue.setOnClickListener(this);

        matchFormClick = 2;
        matchTypeClick = 1;
        match3setTiebreak = false;

        return root;
    }

    @Override
    public void onClick(View v) {

        if (v == btnContinue) {

            if (matchFormClick == 2) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("MatchTiebreak").setMessage("Is the 3rd set a MatchTiebreak?");
                builder.setPositiveButton("Jep", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        match3setTiebreak = true;
                        startMatch();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        match3setTiebreak = false;
                        startMatch();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                startMatch();
            }
        }
        else if (v == btn1set) {
            clickMatchForm(matchFormClick, btn1set);
            matchFormClick = 1;
        }
        else if (v == btn3set) {
            clickMatchForm(matchFormClick, btn3set);
            matchFormClick = 2;
        }
        else if (v == btn5set) {
            clickMatchForm(matchFormClick, btn5set);
            matchFormClick = 3;
        }
        else if (v == btnTiebreak) {
            clickMatchForm(matchFormClick, btnTiebreak);
            matchFormClick = 4;
        }
        else if (v == btnMatchTiebreak) {
            clickMatchForm(matchFormClick, btnMatchTiebreak);
            matchFormClick = 5;
        }
        else if (v == btnTournamentMatch) {
            clickMatchType(matchTypeClick, btnTournamentMatch);
            matchTypeClick = 1;
        }
        else if (v == btnTeamMatch) {
            clickMatchType(matchTypeClick, btnTeamMatch);
            matchTypeClick = 2;
        }
        else if (v == btnTrainingMatch) {
            clickMatchType(matchTypeClick, btnTrainingMatch);
            matchTypeClick = 3;
        }
    }

    private void clickMatchForm(int clickedID, Button btnClicked) {

        Button previusClicked = null;

        switch (clickedID) {
            case 1 :
                previusClicked = btn1set;
                break;
            case 2 :
                previusClicked = btn3set;
                break;
            case 3 :
                previusClicked = btn5set;
                break;
            case 4 :
                previusClicked = btnTiebreak;
                break;
            case 5 :
                previusClicked = btnMatchTiebreak;
                break;
        }

        previusClicked.setBackgroundResource(R.color.colorAccent);
        previusClicked.setElevation(0);

        btnClicked.setBackgroundResource(R.color.colorPrimary);
        btnClicked.setElevation(10);
    }

    private void clickMatchType(int clickedID, Button btnClicked) {

        Button previusClicked = null;

        switch (clickedID) {
            case 1:
                previusClicked = btnTournamentMatch;
                break;
            case 2:
                previusClicked = btnTeamMatch;
                break;
            case 3:
                previusClicked = btnTrainingMatch;
                break;
        }

        previusClicked.setBackgroundResource(R.color.colorAccent);
        previusClicked.setElevation(0);

        btnClicked.setBackgroundResource(R.color.colorPrimary);
        btnClicked.setElevation(10);
    }

    private void startMatch() {
        if (CurrentMatch.isMatchSingle) {
            playerController.saveSingleTeam(team1Player1);
            playerController.saveSingleTeam(team2Player1);
            playerController.createMatch(matchFormClick, matchTypeClick, match3setTiebreak);
        } else {
            playerController.saveDoubleTeam(team1Player1, team1Player2);
            playerController.saveDoubleTeam(team2Player1, team2Player2);
            playerController.createMatch(matchFormClick, matchTypeClick, match3setTiebreak);
        }
        startActivity(new Intent(getActivity(), Match_Act.class));
    }
}
