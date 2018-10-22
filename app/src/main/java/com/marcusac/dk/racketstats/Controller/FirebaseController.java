package com.marcusac.dk.racketstats.Controller;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseController {



    static DatabaseReference dbRefPlayer = FirebaseDatabase.getInstance().getReference().child("players");
    static DatabaseReference dbRefTeam = FirebaseDatabase.getInstance().getReference().child("teams");
    static DatabaseReference dbRefMatch = FirebaseDatabase.getInstance().getReference().child("matches");
    //static DatabaseReference dbRefStats = FirebaseDatabase.getInstance().getReference().child("stats");

    public Task<DataSnapshot> getTestPlayerData() {

        final TaskCompletionSource<DataSnapshot> source = new TaskCompletionSource<>();

        dbRefPlayer.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                source.setResult(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                source.setException(databaseError.toException());
            }
        });

        return source.getTask();
    }


    public Task<DataSnapshot> getMatchInfo(String matchID) {

        final TaskCompletionSource<DataSnapshot> source = new TaskCompletionSource<>();

        dbRefMatch.child(matchID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                source.setResult(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                source.setException(databaseError.toException());
            }
        });

        return source.getTask();

    }


}
