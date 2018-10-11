package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scenario_FirstServ_Frag extends Fragment implements View.OnClickListener {


    ImageView iwAce;
    ImageView iwFault;
    ImageView iwIn;
    ImageView iwFootFault;
    ImageView iwServiceWinner;


    public Scenario_FirstServ_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__serv_, container, false);

        iwAce = root.findViewById(R.id.iwAce);
        iwFault = root.findViewById(R.id.iwFault);
        iwIn = root.findViewById(R.id.iwIn);
        iwFootFault = root.findViewById(R.id.iwFootFault);
        iwServiceWinner = root.findViewById(R.id.iwServiceWinner);

        iwAce.setOnClickListener(this);
        iwFault.setOnClickListener(this);
        iwIn.setOnClickListener(this);
        iwFootFault.setOnClickListener(this);
        iwServiceWinner.setOnClickListener(this);



        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == iwAce) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Scenario_Score())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();

        }

        else if (v == iwFault) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Scenario_SecondServ_Frag())
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }

        else if (v == iwIn) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Scenario_Who_Won_Point_Frag())
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }

        else if (v == iwFootFault) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Scenario_SecondServ_Frag())
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }

        else if (v == iwServiceWinner) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Scenario_Score())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }
}
