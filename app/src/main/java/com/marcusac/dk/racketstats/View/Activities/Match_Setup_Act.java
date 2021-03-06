package com.marcusac.dk.racketstats.View.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.marcusac.dk.racketstats.Controller.PlayerController;
import com.marcusac.dk.racketstats.R;
import com.marcusac.dk.racketstats.View.Fragments.Match_Setup_Category_Frag;

public class Match_Setup_Act extends AppCompatActivity {

    PlayerController playerController = new PlayerController();

    TextView tvMatchSetup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match__setup);

        tvMatchSetup = findViewById(R.id.tvMatchSetup);

        setTitle("Match_Act setup");

        if (savedInstanceState == null) {
            Fragment fragment = new Match_Setup_Category_Frag();

            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }


    }
}
