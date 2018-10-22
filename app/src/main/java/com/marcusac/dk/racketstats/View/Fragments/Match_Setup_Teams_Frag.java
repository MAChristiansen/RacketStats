package com.marcusac.dk.racketstats.View.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.marcusac.dk.racketstats.Controller.PlayerController;
import com.marcusac.dk.racketstats.R;
import com.marcusac.dk.racketstats.View.Activities.Match_Act;

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

    boolean isMatchSingle;


    public Match_Setup_Teams_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_match__setup__teams_, container, false);

        isMatchSingle = getArguments().getBoolean("isMatchSingle");

        btnContinue = root.findViewById(R.id.btnContinue);
        etTeam1Player1 = root.findViewById(R.id.etTeam1Player1);
        etTeam1Player2 = root.findViewById(R.id.etTeam1Player2);
        etTeam2Player1 = root.findViewById(R.id.etTeam2Player1);
        etTeam2Player2 = root.findViewById(R.id.etTeam2Player2);

        if (isMatchSingle) {
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

            if (isMatchSingle) {
                playerController.saveSingleTeam(etTeam1Player1.getText().toString());
                playerController.saveSingleTeam(etTeam2Player1.getText().toString());
                playerController.createMatch(isMatchSingle);
            } else {
                playerController.saveDoubleTeam(etTeam1Player1.getText().toString(), etTeam1Player2.getText().toString());
                playerController.saveDoubleTeam(etTeam2Player1.getText().toString(), etTeam2Player2.getText().toString());
                playerController.createMatch(isMatchSingle);
            }

            startActivity(new Intent(getActivity(), Match_Act.class));
            getActivity().finish();

        }
    }
}
