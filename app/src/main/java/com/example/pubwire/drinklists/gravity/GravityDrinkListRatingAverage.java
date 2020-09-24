package com.example.pubwire.drinklists.gravity;

import androidx.annotation.NonNull;

import com.example.pubwire.drinklists.chatwin.ChatwinDrinkList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class GravityDrinkListRatingAverage extends ChatwinDrinkList {


    public static void setRatingAppletini() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("Appletini")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("Appletini");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Appletini")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingCaipirinaDeAipo() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("CaipirinaDeAipo")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("CaipirinaDeAipo");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("CaipirinaDeAipo")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingCerisePunch() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("CerisePunch")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("CerisePunch");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("CerisePunch")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingGrayApple() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("GrayApple")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("GrayApple");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("GrayApple")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingIndianSpritz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("IndianSpritz")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("IndianSpritz");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("IndianSpritz")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingIngleseSpagnoloItaliano() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("IngleseSpagnoloItaliano")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("IngleseSpagnoloItaliano");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("IngleseSpagnoloItaliano")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMartiniDoItBitter() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("MartiniDoItBitter")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("MartiniDoItBitter");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Appletini")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMexicoNuvole() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("MexicoNuvole")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("MexicoNuvole");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("MexicoNuvole")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingRosaMoskata() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("RosaMoskata")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("RosaMoskata");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("RosaMoskata")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingRosaRosa() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("RosaRosa")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("RosaRosa");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("RosaRosa")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingSMayfair() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("SMayfair")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("SMayfair");

                newdbref.child("drinkRating").setValue(average);

                /*DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("SMayfair")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingTommys1492() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("Tommys1492")
                .child("Ratings");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("drinkRating").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("DrinkList")
                        .child("Tommys1492");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Tommys1492")
                        .child("Pubs")
                        .child("Gravity");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
}