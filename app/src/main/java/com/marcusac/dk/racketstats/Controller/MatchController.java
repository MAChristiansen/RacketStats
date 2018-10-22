package com.marcusac.dk.racketstats.Controller;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;


public class MatchController extends AsyncTask {

    FirebaseController firebaseController = new FirebaseController();

    public void AsyncTest(TextView name1) {



    }


    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}
