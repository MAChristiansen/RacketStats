package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.marcusac.dk.racketstats.Controller.MatchController;
import com.marcusac.dk.racketstats.Controller.ScoreController;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scenario_Who_Won_Point_Frag extends Fragment implements View.OnClickListener {

    Button btnTeam1;
    Button btnTeam2;

    ScoreController scoreController = new ScoreController();

    public Scenario_Who_Won_Point_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__who__won__point_, container, false);

        btnTeam1 = root.findViewById(R.id.btnTeam1);
        btnTeam2 = root.findViewById(R.id.btnTeam2);

        btnTeam1.setOnClickListener(this);
        btnTeam2.setOnClickListener(this);

        if (CurrentMatch.isMatchSingle) {
            btnTeam1.setText(CurrentMatch.currentPlayers.get(0).getName());
            btnTeam2.setText(CurrentMatch.currentPlayers.get(1).getName());
        } else {
            btnTeam1.setText(CurrentMatch.currentPlayers.get(0).getName() + " / " + CurrentMatch.currentPlayers.get(1).getName());
            btnTeam2.setText(CurrentMatch.currentPlayers.get(2).getName() + " / " + CurrentMatch.currentPlayers.get(3).getName());
        }

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == btnTeam1) {

            scoreController.updateScoreByDual(0);

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scenario_How_Won_Frag())
                    .addToBackStack(null)
                    .commit();
        }

        else if (v == btnTeam2) {

            scoreController.updateScoreByDual(1);

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scenario_How_Won_Frag())
                    .addToBackStack(null)
                    .commit();
        }
    }
}
