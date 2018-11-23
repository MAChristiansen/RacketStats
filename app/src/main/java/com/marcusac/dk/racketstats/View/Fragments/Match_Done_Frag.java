package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Match_Done_Frag extends Fragment implements View.OnClickListener {

    Button btnToMenu;
    Button btnStatistic;

    TextView tvScore;
    TextView tvTeamWon;


    public Match_Done_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_match__done, container, false);

        btnStatistic = root.findViewById(R.id.btnStatistic);
        btnToMenu = root.findViewById(R.id.btnToMenu);
        tvScore = root.findViewById(R.id.tvScore);
        tvTeamWon = root.findViewById(R.id.tvTeamWon);

        btnToMenu.setOnClickListener(this);
        btnStatistic.setOnClickListener(this);

        //Setting winner name
        String name;
        if (CurrentMatch.currentMatch.getScoreSets().get(0) > CurrentMatch.currentMatch.getScoreSets().get(1)) {
            if (CurrentMatch.isMatchSingle) {
                name = CurrentMatch.currentPlayers.get(0).getName();
            } else {
                name = CurrentMatch.currentPlayers.get(0).getName() + " / " + CurrentMatch.currentPlayers.get(1).getName();
            }
        }
        else {
            if (CurrentMatch.isMatchSingle) {
                name = CurrentMatch.currentPlayers.get(1).getName();
            } else {
                name = CurrentMatch.currentPlayers.get(2).getName() + " / " + CurrentMatch.currentPlayers.get(3).getName();
            }
        }
        tvTeamWon.setText(name + " Won");

        //Setting score for match
        String score = "";
        if (CurrentMatch.currentMatch.isMatchTiebreak() || CurrentMatch.currentMatch.isMatchMatchTiebreak()) {
            score = CurrentMatch.currentMatch.getScorePoints().get(0) + " - " + CurrentMatch.currentMatch.getScorePoints().get(1);
        }
        else {
            switch (CurrentMatch.currentMatch.getScoreGames().size() / 2) {
                case 1:
                    score = CurrentMatch.currentMatch.getScoreGames().get(0) + " / " + CurrentMatch.currentMatch.getScoreGames().get(1);
                    break;
                case 2:
                    score = CurrentMatch.currentMatch.getScoreGames().get(0) + " / " + CurrentMatch.currentMatch.getScoreGames().get(1) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(2) + " / " + CurrentMatch.currentMatch.getScoreGames().get(3);
                    break;
                case 3:
                    score = CurrentMatch.currentMatch.getScoreGames().get(0) + " / " + CurrentMatch.currentMatch.getScoreGames().get(1) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(2) + " / " + CurrentMatch.currentMatch.getScoreGames().get(3) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(4) + " / " + CurrentMatch.currentMatch.getScoreGames().get(5);
                    break;
                case 4:
                    score = CurrentMatch.currentMatch.getScoreGames().get(0) + " / " + CurrentMatch.currentMatch.getScoreGames().get(1) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(2) + " / " + CurrentMatch.currentMatch.getScoreGames().get(3) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(4) + " / " + CurrentMatch.currentMatch.getScoreGames().get(5) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(6) + " / " + CurrentMatch.currentMatch.getScoreGames().get(7);
                    break;
                case 5:
                    score = CurrentMatch.currentMatch.getScoreGames().get(0) + " / " + CurrentMatch.currentMatch.getScoreGames().get(1) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(2) + " / " + CurrentMatch.currentMatch.getScoreGames().get(3) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(4) + " / " + CurrentMatch.currentMatch.getScoreGames().get(5) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(6) + " / " + CurrentMatch.currentMatch.getScoreGames().get(7) +
                            "  " +
                            CurrentMatch.currentMatch.getScoreGames().get(8) + " / " + CurrentMatch.currentMatch.getScoreGames().get(9);
                    break;
            }
        }
        tvScore.setText(score);



        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == btnStatistic) {

        }
        else if (v == btnToMenu) {

        }

    }
}
