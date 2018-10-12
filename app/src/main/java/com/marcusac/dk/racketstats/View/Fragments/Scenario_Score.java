package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scenario_Score extends Fragment {

    TextView tvScore;


    public Scenario_Score() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__score, container, false);

        tvScore = root.findViewById(R.id.tvScore);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {



                getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                /*getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right.xml, R.anim.exit_to_left)
                        .replace(R.id.fragmentContainer, new Scenario_FirstServ_Frag())
                        .commit();*/



            }
        }, 2500);

        return root;
    }

}
