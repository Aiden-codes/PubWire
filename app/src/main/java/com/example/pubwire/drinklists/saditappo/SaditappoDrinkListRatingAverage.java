package com.example.pubwire.drinklists.saditappo;

import androidx.annotation.NonNull;

import com.example.pubwire.drinklists.chatwin.ChatwinDrinkList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class SaditappoDrinkListRatingAverage extends SaditappoDrinkList {


    public static void setRatingAmericano() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("Americano");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Americano")
                        .child("Pubs")
                        .child("SaditappoGourmet");

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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("AperolSpritz");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("AperolSpritz")
                        .child("Pubs")
                        .child("SaditappoGourmet");

                infolist.child("Average").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingBloodyMary() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("BloodyMary")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("BloodyMary");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingCampariOrange() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("CampariOrange")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("CampariOrange");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingCampariSpritz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("CampariSpritz")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("CampariSpritz");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingCubaPestato() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("CubaPestato")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("CubaPestato");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingGinSour() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("GinSour")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("GinSour");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingHugo() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("Hugo")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("Hugo");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMartiniBiancoSpritz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("MartiniBiancoSpritz")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("MartiniBiancoSpritz");

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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
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
    public static void setRatingMartiniCocktail() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("MartiniCocktail")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("MartiniCocktail");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMartiniRossoSummer() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("MartiniRossoSummer")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("MartiniRossoSummer");

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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
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
    public static void setRatingMartiniRoyal() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("MartiniRoyal")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("MartiniRoyal");

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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
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
    public static void setRatingMilanoCardanoTorino() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("MilanoCardanoTorino")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("MilanoCardanoTorino");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingMilanoTorino() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("MilanoTorino")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("MilanoTorino");

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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("Mojito");

                newdbref.child("drinkRating").setValue(average);

                DatabaseReference infolist = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Mojito")
                        .child("Pubs")
                        .child("SaditappoGourmet");

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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
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
    public static void setRatingNegroski() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("Negroski")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("Negroski");

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
                .child("SaditappoGourmet")
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
                        .child("SaditappoGourmet")
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
    public static void setRatingP31GreenSpritz() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("P31GreenSpritz")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("P31GreenSpritz");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingPomodoroCondito() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("PomodoroCondito")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("PomodoroCondito");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingQuattroBianchi() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("QuattroBianchi")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("QuattroBianchi");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
    public static void setRatingSaditappoAnalcolico() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("SaditappoAnalcolico")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("SaditappoAnalcolico");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }

    public static void setRatingVodkaSour() {

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("SaditappoGourmet")
                .child("DrinkList")
                .child("VodkaSour")
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
                        .child("SaditappoGourmet")
                        .child("DrinkList")
                        .child("VodkaSour");

                newdbref.child("drinkRating").setValue(average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }
}
