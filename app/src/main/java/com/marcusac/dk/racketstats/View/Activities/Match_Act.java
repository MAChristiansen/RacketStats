package com.marcusac.dk.racketstats.View.Activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marcusac.dk.racketstats.Controller.FirebaseController;
import com.marcusac.dk.racketstats.Controller.MatchController;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;
import com.marcusac.dk.racketstats.R;
import com.marcusac.dk.racketstats.View.Fragments.Scenario_FirstServ_Frag;

import java.util.ArrayList;

public class Match_Act extends AppCompatActivity {

    FirebaseController firebaseController = new FirebaseController();

    TextView tvTeam1Names;
    TextView tvTeam2Names;
    TextView tvTeam1Sets;
    TextView tvTeam2Sets;
    TextView tvTeam1Games;
    TextView tvTeam2Games;
    TextView tvTeam1Points;
    TextView tvTeam2Points;
    TextView tvSets;
    TextView tvGames;
    private ImageView ivTeam1Serving;
    private ImageView ivTeam2Serving;

    MatchController matchController = new MatchController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        getSupportActionBar().hide();

        tvTeam1Names = findViewById(R.id.tvTeam1Names);
        tvTeam2Names = findViewById(R.id.tvTeam2Names);
        tvTeam1Sets = findViewById(R.id.tvTeam1Sets);
        tvTeam2Sets = findViewById(R.id.tvTeam2Sets);
        tvTeam1Games = findViewById(R.id.tvTeam1Games);
        tvTeam2Games = findViewById(R.id.tvTeam2Games);
        tvTeam1Points = findViewById(R.id.tvTeam1Points);
        tvTeam2Points = findViewById(R.id.tvTeam2Points);
        tvGames = findViewById(R.id.tvGames);
        tvSets = findViewById(R.id.tvSets);
        ivTeam1Serving = findViewById(R.id.ivTeam1Serving);
        ivTeam2Serving = findViewById(R.id.ivTeam2Serving);

        if (savedInstanceState == null) {
            Fragment fragment = new Scenario_FirstServ_Frag();

            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }

        if (CurrentMatch.isMatchSingle) {
            tvTeam1Names.setText(CurrentMatch.currentPlayers.get(0).getName());
            tvTeam2Names.setText(CurrentMatch.currentPlayers.get(1).getName());
        } else {
            tvTeam1Names.setText(CurrentMatch.currentPlayers.get(0).getName() + " / " + CurrentMatch.currentPlayers.get(1).getName());
            tvTeam2Names.setText(CurrentMatch.currentPlayers.get(2).getName() + " / " + CurrentMatch.currentPlayers.get(3).getName());
        }

        setScoreBoard(tvTeam1Sets, tvTeam2Sets, tvTeam1Games, tvTeam2Games, tvTeam1Points, tvTeam2Points, tvSets, tvGames);
        matchController.whoStartsServing(this, ivTeam1Serving, ivTeam2Serving);


    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() == 0){
            createDialog();
        } else {
            getSupportFragmentManager().popBackStack();
        }



    }

    private void createDialog() {
        AlertDialog.Builder alertConfirm = new AlertDialog.Builder(this);

        alertConfirm.setMessage("Are you sure you want to exit? You will loose your data if you exit!");
        alertConfirm.setCancelable(false);

        alertConfirm.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Match_Act.super.onBackPressed();
                Match_Act.this.finish();
            }
        });

        alertConfirm.setNegativeButton("No!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertConfirm.create().show();
    }

    private void setScoreBoard(
            TextView tvTeam1Sets, TextView tvTeam2Sets,
            TextView tvTeam1Games, TextView tvTeam2Games,
            TextView tvTeam1Points, TextView tvTeam2Points,
            TextView tvSets, TextView tvGames) {

        if (CurrentMatch.currentMatch.isMatchMatchTiebreak() || CurrentMatch.currentMatch.isMatchTiebreak()) {

            tvTeam1Points.setText(CurrentMatch.currentMatch.getScorePoints().get(0).toString());
            tvTeam2Points.setText(CurrentMatch.currentMatch.getScorePoints().get(1).toString());

            tvTeam1Games.setVisibility(View.GONE);
            tvTeam2Games.setVisibility(View.GONE);
            tvGames.setVisibility(View.GONE);

            tvTeam1Sets.setVisibility(View.GONE);
            tvTeam2Sets.setVisibility(View.GONE);
            tvSets.setVisibility(View.GONE);

        }
        else if (CurrentMatch.currentMatch.isMatch1Set()) {

            tvTeam1Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(0).toString());
            tvTeam2Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(1).toString());

            tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(0).toString());
            tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(1).toString());

            tvTeam1Sets.setVisibility(View.GONE);
            tvTeam2Sets.setVisibility(View.GONE);
            tvSets.setVisibility(View.GONE);

        } else {

            tvTeam1Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(0).toString());
            tvTeam2Sets.setText(CurrentMatch.currentMatch.getScoreSets().get(1).toString());

            tvTeam1Games.setText(CurrentMatch.currentMatch.getScoreGames().get(0).toString());
            tvTeam2Games.setText(CurrentMatch.currentMatch.getScoreGames().get(1).toString());

            tvTeam1Points.setText(CurrentMatch.currentMatch.getScorePoints().get(0).toString());
            tvTeam2Points.setText(CurrentMatch.currentMatch.getScorePoints().get(1).toString());
        }

    }


}
