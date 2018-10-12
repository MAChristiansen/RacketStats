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

    ImageView ivUnforcedError;

    public Scenario_How_Won_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__how__won_, container, false);

        ivUnforcedError = root.findViewById(R.id.ivUnfocredError);

        ivUnforcedError.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == ivUnforcedError) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                    .replace(R.id.fragmentContainer, new Scenario_Score())
                    .commit();

        }
    }
}
