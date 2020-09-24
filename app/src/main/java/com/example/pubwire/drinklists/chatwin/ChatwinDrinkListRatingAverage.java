package com.example.pubwire.drinklists.chatwin;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ChatwinDrinkListRatingAverage extends ChatwinDrinkList {


    public static void setRatingAmericano() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Americano")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Americano");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Americano")
                        .child("Pubs")
                        .child("Chatwin");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingAperolSpritz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("AperolSpritz")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("AperolSpritz");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("AperolSpritz")
                        .child("Pubs")
                        .child("Chatwin");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingBlackMojito() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("BlackMojito")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("BlackMojito");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingBramble() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Bramble")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Bramble");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingBrambleWithBrockmans() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("BrambleWithBrockmans")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("BrambleWithBrockmans");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingCaipirinha() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Caipirinha")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Caipirinha");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingCaipirinhaPremium() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("CaipirinhaPremium")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("CaipirinhaPremium");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingCaipiroska() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Caipiroska")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Caipiroska");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingCaipiroskaFrutta() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("CaipiroskaFrutta")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("CaipiroskaFrutta");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingDaiquiri() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Daiquiri")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Daiquiri");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Daiquiri")
                        .child("Pubs")
                        .child("Chatwin");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingHugoSpritz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("HugoSpritz")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("HugoSpritz");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingJapaneseIcedTea() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("JapaneseIcedTea")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("JapaneseIcedTea");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingLondonMule() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("LondonMule")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("LondonMule");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("LondonMule")
                        .child("Pubs")
                        .child("Chatwin");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingLongIslandIcedTea() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("LongIslandIcedTea")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("LongIslandIcedTea");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("LongIslandIcedTea")
                        .child("Pubs")
                        .child("Chatwin");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMaiTai() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("MaiTai")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("MaiTai");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMargarita() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Margarita")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Margarita");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMiami() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Miami")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Miami");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMitoDellaSirena() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("MitoDellaSirena")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("MitoDellaSirena");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMojito() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Mojito")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Mojito");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Mojito")
                        .child("Pubs")
                        .child("Chatwin");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMoscowMule() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("MoscowMule")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("MoscowMule");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingNegroni() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Negroni")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Negroni");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingNightTail() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("NightTail")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("NightTail");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingSbagliato() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Sbagliato")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Sbagliato");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingSexOnTheBeach() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("SexOnTheBeach")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("SexOnTheBeach");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingSpecial() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("Special")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("Special");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingTimFizz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("TimFizz")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("TimFizz");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingTimSpritz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Pub_Example")
                .child("DrinkList")
                .child("TimSpritz")
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
                        .child("Pub_Example")
                        .child("DrinkList")
                        .child("TimSpritz");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
}
