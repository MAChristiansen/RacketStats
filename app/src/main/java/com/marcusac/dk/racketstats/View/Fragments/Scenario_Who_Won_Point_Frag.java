package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scenario_Who_Won_Point_Frag extends Fragment implements View.OnClickListener {

    Button btnTeam1;
    Button btnTeam2;


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

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == btnTeam1) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Scenario_How_Won_Frag())
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }

        else if (v == btnTeam2) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Scenario_How_Won_Frag())
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }
}
