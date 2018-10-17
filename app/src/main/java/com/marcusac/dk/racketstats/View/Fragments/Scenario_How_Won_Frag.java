package com.marcusac.dk.racketstats.View.Fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scenario_How_Won_Frag extends Fragment implements View.OnClickListener {

    private ImageView ivUnforcedError;
    private ImageView ivForcedError;
    private ImageView ivWinner;

    public Scenario_How_Won_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__how__won_, container, false);

        ivUnforcedError = root.findViewById(R.id.ivUnforcedError);
        ivForcedError = root.findViewById(R.id.ivForcedError);
        ivWinner = root.findViewById(R.id.ivWinner);

        ivUnforcedError.setOnClickListener(this);
        ivForcedError.setOnClickListener(this);
        ivWinner.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == ivUnforcedError) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scenario_Which_Stroke_Frag())
                    .addToBackStack(null)
                    .commit();
        }

        else if (v == ivForcedError) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scenario_Which_Stroke_Frag())
                    .addToBackStack(null)
                    .commit();

        }

        else if (v == ivWinner) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scenario_Which_Stroke_Frag())
                    .addToBackStack(null)
                    .commit();

        }
    }
}
