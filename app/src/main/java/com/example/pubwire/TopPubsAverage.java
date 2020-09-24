package com.example.pubwire;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TopPubsAverage {

    public static void setRatingChatwin(){

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("Comments");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(String.valueOf(s.child("starCount").getValue(Double.class)));
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Pub_Example");

                newdbref.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });
    }

    public static void setRatingSaditappo(){

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("Comments");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(String.valueOf(s.child("starCount").getValue(Double.class)));
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("SaditappoGourmet");

                newdbref.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });
    }

    public static void setRatingGravity(){

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("Comments");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(String.valueOf(s.child("starCount").getValue(Double.class)));
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Gravity");

                newdbref.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });
    }
}
