package com.marcusac.dk.racketstats.View.Fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Match_Setup_Category_Frag extends Fragment implements View.OnClickListener {

    private FloatingActionButton btnContinue;
    private Button btnSingle;
    private Button btnDouble;

    private boolean matchIsSingle = true;


    public Match_Setup_Category_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_match__setup__category, container, false);

        btnContinue = root.findViewById(R.id.btnContinue);
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

        if (matchIsSingle) {
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
            Bundle b = new Bundle();
            b.putBoolean("isMatchSingle", matchIsSingle);
            newFragment.setArguments(b);

            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, newFragment)
                    .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();

        }
        else if (v == btnSingle) {
            matchIsSingle = true;

            btnDouble.setBackgroundResource(R.color.colorAccent);
            btnDouble.setElevation(0);

            btnSingle.setBackgroundResource(R.color.colorPrimary);
            btnSingle.setElevation(10);


        }
        else if (v == btnDouble) {
            matchIsSingle = false;

            btnSingle.setBackgroundResource(R.color.colorAccent);
            btnSingle.setElevation(0);

            btnDouble.setBackgroundResource(R.color.colorPrimary);
            btnDouble.setElevation(10);

        }
    }
}
