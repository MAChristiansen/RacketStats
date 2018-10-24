package com.marcusac.dk.racketstats.View.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marcusac.dk.racketstats.R;

public class Login_Menu_Act extends AppCompatActivity implements View.OnClickListener {

    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);

        btnContinue = findViewById(R.id.btnContinue3);

        btnContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnContinue) {
            startActivity(new Intent(this, Match_Setup_Act.class));
        }
    }
}
