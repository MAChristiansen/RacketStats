package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.marcusac.dk.racketstats.Controller.PlayerController;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Match_Setup_Teams_Frag extends Fragment implements View.OnClickListener {

    FloatingActionButton btnContinue;

    EditText etTeam1Player1;
    EditText etTeam1Player2;
    EditText etTeam2Player1;
    EditText etTeam2Player2;

    PlayerController playerController = new PlayerController();


    public Match_Setup_Teams_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_match__setup__teams_, container, false);

        btnContinue = root.findViewById(R.id.btnContinue3);
        etTeam1Player1 = root.findViewById(R.id.etTeam1Player1);
        etTeam1Player2 = root.findViewById(R.id.etTeam1Player2);
        etTeam2Player1 = root.findViewById(R.id.etTeam2Player1);
        etTeam2Player2 = root.findViewById(R.id.etTeam2Player2);

        if (CurrentMatch.isMatchSingle) {
            etTeam1Player2.setVisibility(View.INVISIBLE);
            etTeam2Player2.setVisibility(View.INVISIBLE);
            etTeam1Player1.setHint("Player name");
            etTeam2Player1.setHint("Player name");
        }

        btnContinue.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == btnContinue) {

            Bundle b = new Bundle();
            Fragment fragment = new Match_Setup_Config_Frag();

            if (CurrentMatch.isMatchSingle) {
                b.putString("team1Player1", etTeam1Player1.getText().toString());
                b.putString("team2Player1", etTeam2Player1.getText().toString());
            } else {
                b.putString("team1Player1", etTeam1Player1.getText().toString());
                b.putString("team1Player2", etTeam1Player2.getText().toString());
                b.putString("team2Player1", etTeam2Player1.getText().toString());
                b.putString("team2Player2", etTeam2Player2.getText().toString());
            }

            fragment.setArguments(b);

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
