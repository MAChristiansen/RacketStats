package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marcusac.dk.racketstats.Controller.ScoreController;
import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scenario_Score extends Fragment {

    TextView tvScore;
    ScoreController scoreController = new ScoreController();
    TextView tvTeam1Sets;
    TextView tvTeam2Sets;
    TextView tvTeam1Games;
    TextView tvTeam2Games;
    TextView tvTeam1Points;
    TextView tvTeam2Points;

    public Scenario_Score() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__score, container, false);

        tvScore = root.findViewById(R.id.tvScore);
        /*tvTeam1Sets = root.findViewById(R.id.tvTeam1Points);
        tvTeam1Sets = root.findViewById(R.id.tvTeam1Sets);
        tvTeam2Sets = root.findViewById(R.id.tvTeam2Sets);
        tvTeam1Games = root.findViewById(R.id.tvTeam1Games);
        tvTeam2Games = root.findViewById(R.id.tvTeam2Games);
        tvTeam1Points = root.findViewById(R.id.tvTeam1Points);
        tvTeam2Points = root.findViewById(R.id.tvTeam2Points);*/


        scoreController.updateShortScore(tvScore);
        //scoreController.updateScore(tvTeam1Sets, tvTeam2Sets, tvTeam1Games, tvTeam2Games, tvTeam1Points, tvTeam2Points);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        }, 1500);

        return root;
    }

}
