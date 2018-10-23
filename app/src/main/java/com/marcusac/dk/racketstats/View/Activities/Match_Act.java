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

        if (savedInstanceState == null) {
            Fragment fragment = new Scenario_FirstServ_Frag();

            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }

        matchController.updateScoreBoardNames(tvTeam1Names, tvTeam2Names);
        matchController.updateScoreBoardScore(tvTeam1Sets,tvTeam2Sets, tvTeam1Games,tvTeam2Games,tvTeam1Points,tvTeam2Points);
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
}
