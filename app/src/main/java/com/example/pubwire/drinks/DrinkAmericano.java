package com.example.pubwire.drinks;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubwire.Chatwin;
import com.example.pubwire.Gravity;
import com.example.pubwire.R;
import com.example.pubwire.Saditappo;
import com.example.pubwire.TopPubs;
import com.example.pubwire.drinks.models.DrinksModel;
import com.example.pubwire.drinks.viewholders.DrinksViewHolder;
import com.example.pubwire.main.MainActivity;
import com.example.pubwire.maps.GoogleMapsActivity;
import com.example.pubwire.profile.AccountActivity;
import com.example.pubwire.profile.Login;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class DrinkAmericano extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;

    RatingBar ratingBar;
    TextView Name, Info;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    private FirebaseRecyclerAdapter<DrinksModel, DrinksViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_maps:
                        Toast.makeText(DrinkAmericano.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DrinkAmericano.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(DrinkAmericano.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DrinkAmericano.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(DrinkAmericano.this, "UBER", Toast.LENGTH_SHORT).show();
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.ubercab");
                        if (launchIntent != null) {
                            startActivity(launchIntent);//null pointer check in case package name was not found
                        }
                        break;
                }
                return true;
            }
        });

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_account: {
                        if (user != null) {
                            startActivity(new Intent(DrinkAmericano.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(DrinkAmericano.this, Login.class));
                        }
                    }
                    default:
                        return DrinkAmericano.super.onOptionsItemSelected(item);
                }
            }
        });

        ratingBar = findViewById(R.id.drink_ratingBar);

        //ratingBar.isIndicator();

        setRatingBarListener();

        Name = findViewById(R.id.drink_name);
        Info = findViewById(R.id.drink_info);
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Info")
                .child("Drinks")
                .child("Americano");

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String drinkname = "";
                String drinkinfo = "";

                for (DataSnapshot s: snapshot.getChildren()) {
                    drinkname = snapshot.child("drinkName").getValue(String.class);
                    drinkinfo = snapshot.child("drinkInfo").getValue(String.class);

                }
                Name.setText(drinkname);
                Info.setText(drinkinfo);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        recyclerView = findViewById(R.id.drink_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetch();
    }

    private void setRatingBarListener() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Info")
                .child("Drinks")
                .child("Americano")
                .child("Pubs");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double total = 0.0;
                double count = 0.0;
                double average = 0.0;

                for (@NonNull DataSnapshot s : snapshot.getChildren()) {
                    double rating = Double.parseDouble(Objects.requireNonNull(s.child("Average").getValue()).toString());
                    total = total + rating;
                    count = count + 1;
                    average = total / count;
                }

                DatabaseReference newdbref = FirebaseDatabase.getInstance().getReference()
                        .child("Info")
                        .child("Drinks")
                        .child("Americano");

                newdbref.child("TotAverage").setValue(average);

                ratingBar.setRating((float) average);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

    }


    public void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Info")
                .child("Drinks")
                .child("Americano")
                .child("Pubs")
                .orderByChild("Average")
                .limitToLast(2);

        FirebaseRecyclerOptions<DrinksModel> options =
                new FirebaseRecyclerOptions.Builder<DrinksModel>()
                        .setQuery(query, DrinksModel.class)
                        .build();


        adapter = new FirebaseRecyclerAdapter<DrinksModel, DrinksViewHolder>(options) {


            @Override
            public DrinksViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_drinkshow, viewGroup, false);
                return new DrinksViewHolder(view);
            }


            @Override
            public void onBindViewHolder(DrinksViewHolder holder, final int position, final DrinksModel model) {
                holder.setNameView(model.getName());
                holder.setAverageView(model.getAverage());
                holder.setPriceView(model.getPrice());

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent;
                        switch (model.getName()) {
                            case "Chatwin Cafè":
                                startActivity(new Intent(DrinkAmericano.this, Chatwin.class));
                                break;
                            case "Saditappo Gourmet":
                                startActivity(new Intent(DrinkAmericano.this, Saditappo.class));
                                break;
                            case "Gravity Lounge & Food":
                                startActivity(new Intent(DrinkAmericano.this, Gravity.class));
                            default:
                                break;
                        }
                    }

                    ;
                });
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}