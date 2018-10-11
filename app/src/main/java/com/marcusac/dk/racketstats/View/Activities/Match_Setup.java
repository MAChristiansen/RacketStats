package com.marcusac.dk.racketstats.View.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marcusac.dk.racketstats.R;
import com.marcusac.dk.racketstats.View.Fragments.Match_Setup_Category_Frag;

public class Match_Setup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match__setup);

        setTitle("Match Setup");

        if (savedInstanceState == null) {
            Fragment fragment = new Match_Setup_Category_Frag();

            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }


    }
}
