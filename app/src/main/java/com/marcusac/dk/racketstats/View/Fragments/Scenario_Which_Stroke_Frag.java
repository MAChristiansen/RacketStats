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
public class Scenario_Which_Stroke_Frag extends Fragment implements View.OnClickListener {


    private ImageView ivDropShot;
    private ImageView ivSmash;
    private ImageView ivVolley;
    private ImageView ivLob;
    private ImageView ivApproach;
    private ImageView ivReturn;
    private ImageView ivBaseline;

    public Scenario_Which_Stroke_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scenario__which__stroke_, container, false);

        ivDropShot = root.findViewById(R.id.ivDropShot);
        ivSmash = root.findViewById(R.id.ivSmash);
        ivVolley = root.findViewById(R.id.ivVolley);
        ivLob = root.findViewById(R.id.ivLob);
        ivApproach = root.findViewById(R.id.ivApproach);
        ivReturn = root.findViewById(R.id.ivReturn);
        ivBaseline = root.findViewById(R.id.ivBaseline);

        ivDropShot.setOnClickListener(this);
        ivSmash.setOnClickListener(this);
        ivVolley.setOnClickListener(this);
        ivLob.setOnClickListener(this);
        ivApproach.setOnClickListener(this);
        ivReturn.setOnClickListener(this);
        ivBaseline.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == ivDropShot) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scanario_ForeOrBack_Hand_Frag())
                    .addToBackStack(null)
                    .commit();


        }
        else if (v == ivSmash) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scanario_ForeOrBack_Hand_Frag())
                    .addToBackStack(null)
                    .commit();


        }
        else if (v == ivVolley) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scanario_ForeOrBack_Hand_Frag())
                    .addToBackStack(null)
                    .commit();


        }
        else if (v == ivLob) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scanario_ForeOrBack_Hand_Frag())
                    .addToBackStack(null)
                    .commit();


        }
        else if (v == ivApproach) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scanario_ForeOrBack_Hand_Frag())
                    .addToBackStack(null)
                    .commit();


        }
        else if (v == ivReturn) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scanario_ForeOrBack_Hand_Frag())
                    .addToBackStack(null)
                    .commit();


        }
        else if (v == ivBaseline) {

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragmentContainer, new Scanario_ForeOrBack_Hand_Frag())
                    .addToBackStack(null)
                    .commit();


        }

    }
}
