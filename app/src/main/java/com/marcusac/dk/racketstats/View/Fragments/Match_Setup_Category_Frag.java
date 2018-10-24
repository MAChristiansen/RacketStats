package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Match_Setup_Category_Frag extends Fragment implements View.OnClickListener {

    private FloatingActionButton btnContinue;
    private Button btnSingle;
    private Button btnDouble;


    public Match_Setup_Category_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_match__setup__category, container, false);
        CurrentMatch.isMatchSingle = true;

        btnContinue = root.findViewById(R.id.btnContinue3);
        btnSingle = root.findViewById(R.id.btnSingle);
        btnDouble = root.findViewById(R.id.btnDouble);

        btnContinue.setOnClickListener(this);
        btnSingle.setOnClickListener(this);
        btnDouble.setOnClickListener(this);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (CurrentMatch.isMatchSingle) {
            btnDouble.setBackgroundResource(R.color.colorAccent);
            btnDouble.setElevation(0);

            btnSingle.setBackgroundResource(R.color.colorPrimary);
            btnSingle.setElevation(10);
        } else {
            btnSingle.setBackgroundResource(R.color.colorAccent);
            btnSingle.setElevation(0);

            btnDouble.setBackgroundResource(R.color.colorPrimary);
            btnDouble.setElevation(10);
        }

    }

    @Override
    public void onClick(View v) {
        if (v == btnContinue) {
            Fragment newFragment = new Match_Setup_Teams_Frag();

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, newFragment)
                    .addToBackStack(null)
                    .commit();

        }
        else if (v == btnSingle) {
            CurrentMatch.isMatchSingle = true;

            btnDouble.setBackgroundResource(R.color.colorAccent);
            btnDouble.setElevation(0);

            btnSingle.setBackgroundResource(R.color.colorPrimary);
            btnSingle.setElevation(10);


        }
        else if (v == btnDouble) {
            CurrentMatch.isMatchSingle = false;

            btnSingle.setBackgroundResource(R.color.colorAccent);
            btnSingle.setElevation(0);

            btnDouble.setBackgroundResource(R.color.colorPrimary);
            btnDouble.setElevation(10);

        }
    }
}
