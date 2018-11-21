package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marcusac.dk.racketstats.Controller.ScoreController;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
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
    private ImageView ivTeam2Serving;
    private ImageView ivTeam1Serving;

    public Scenario_Score() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__score, container, false);

        tvScore = root.findViewById(R.id.tvScore);
        tvTeam1Sets = getActivity().findViewById(R.id.tvTeam1Points);
        tvTeam1Sets = getActivity().findViewById(R.id.tvTeam1Sets);
        tvTeam2Sets = getActivity().findViewById(R.id.tvTeam2Sets);
        tvTeam1Games = getActivity().findViewById(R.id.tvTeam1Games);
        tvTeam2Games = getActivity().findViewById(R.id.tvTeam2Games);
        tvTeam1Points = getActivity().findViewById(R.id.tvTeam1Points);
        tvTeam2Points = getActivity().findViewById(R.id.tvTeam2Points);
        ivTeam1Serving = getActivity().findViewById(R.id.ivTeam1Serving);
        ivTeam2Serving = getActivity().findViewById(R.id.ivTeam2Serving);

        //set big score
        tvScore.setText(scoreController.updateShortScore());

        //set set score
        tvTeam1Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(0).toString());
        tvTeam2Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(1).toString());

        //set games score
        switch (CurrentMatch.currentMatch.getScoreGames().size() / 2) {
            case 1:
                tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(0).toString());
                tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(1).toString());
                break;
            case 2:
                tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(2).toString());
                tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(3).toString());
                break;
            case 3:
                tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(4).toString());
                tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(5).toString());
                break;
            case 4:
                tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(6).toString());
                tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(7).toString());
                break;
            case 5:
                tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(8).toString());
                tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(9).toString());
                break;
        }


        //set point score
        if (scoreController.isSetTiebreak()) {
            tvTeam1Points.setText(CurrentMatch.currentMatch.getScorePoints().get(0).toString());
            tvTeam2Points.setText(CurrentMatch.currentMatch.getScorePoints().get(1).toString());
        }
        else {
            tvTeam1Points.setText(scoreController.convertPoints(CurrentMatch.currentMatch.getScorePoints().get(0),
                    CurrentMatch.currentMatch.getScorePoints().get(1)));

            tvTeam2Points.setText(scoreController.convertPoints(CurrentMatch.currentMatch.getScorePoints().get(1),
                    CurrentMatch.currentMatch.getScorePoints().get(0)));
        }

        //set serving icon
        switch (scoreController.setServingTeam()) {
            case 0:
                ivTeam2Serving.setVisibility(View.INVISIBLE);
                ivTeam1Serving.setVisibility(View.VISIBLE);
                break;
            case 1:
                ivTeam1Serving.setVisibility(View.INVISIBLE);
                ivTeam2Serving.setVisibility(View.VISIBLE);
                break;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    SystemClock.sleep(600);
                }
            }
        }, 700);



        return root;
    }

}
