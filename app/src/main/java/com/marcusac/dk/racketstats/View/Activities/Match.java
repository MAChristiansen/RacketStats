package com.marcusac.dk.racketstats.View.Activities;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.marcusac.dk.racketstats.R;
import com.marcusac.dk.racketstats.View.Fragments.Scenario_FirstServ_Frag;

public class Match extends AppCompatActivity {

    TextView team1Set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        setTitle("Match");

        if (savedInstanceState == null) {
            Fragment fragment = new Scenario_FirstServ_Frag();

            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }

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
                Match.super.onBackPressed();
                Match.this.finish();
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
