package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Match_Setup_Category_Frag extends Fragment implements View.OnClickListener {

    FloatingActionButton btnContinue;


    public Match_Setup_Category_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_match__setup__category, container, false);

        btnContinue = root.findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == btnContinue) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Match_Setup_Teams_Frag())
                    .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();

        }
    }
}
