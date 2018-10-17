package com.marcusac.dk.racketstats.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.marcusac.dk.racketstats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scanario_ForeOrBack_Hand_Frag extends Fragment implements View.OnClickListener {


    private ImageView ivForeHand;
    private ImageView ivBackHand;

    public Scanario_ForeOrBack_Hand_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scanario__fore_or_back__hand_, container, false);

        ivForeHand = root.findViewById(R.id.ivForeHand);
        ivBackHand = root.findViewById(R.id.ivBackHand);

        ivForeHand.setOnClickListener(this);
        ivBackHand.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        if (v == ivForeHand) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scenario_Score())
                    .addToBackStack(null)
                    .commit();

        }

        else if (v == ivBackHand) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scenario_Score())
                    .addToBackStack(null)
                    .commit();
        }

    }
}
