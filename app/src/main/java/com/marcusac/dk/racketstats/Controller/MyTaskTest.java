package com.marcusac.dk.racketstats.Controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marcusac.dk.racketstats.Model.CurrentMatch;
import com.marcusac.dk.racketstats.Model.Match;

public class MyTaskTest extends AsyncTask<Match, Void, Match> {

    Match currentMatch;


    @Override
    protected Match doInBackground(Match... matches) {

        FirebaseController.dbRefMatch.child(CurrentMatch.currentMatchID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Match match = dataSnapshot.getValue(Match.class);
                currentMatch = match;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return currentMatch;
    }

    @Override
    protected void onPostExecute(Match match) {
        super.onPostExecute(match);


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
