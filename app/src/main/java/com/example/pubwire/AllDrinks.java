package com.example.pubwire;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubwire.drinks.DrinkAmericano;
import com.example.pubwire.drinks.DrinkAperolSpritz;
import com.example.pubwire.drinks.DrinkDaiquiri;
import com.example.pubwire.drinks.DrinkLondonMule;
import com.example.pubwire.drinks.DrinkLongIslandIcedTea;
import com.example.pubwire.drinks.DrinkMargarita;
import com.example.pubwire.drinks.DrinkMojito;
import com.example.pubwire.drinks.DrinkTommys1492;
import com.example.pubwire.main.MainActivity;
import com.example.pubwire.maps.GoogleMapsActivity;
import com.example.pubwire.profile.AccountActivity;
import com.example.pubwire.profile.Login;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class AllDrinks extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    private FirebaseRecyclerAdapter<TopDrinksModel, TopDrinksViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topdrinks);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_maps:
                        Toast.makeText(AllDrinks.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AllDrinks.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(AllDrinks.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AllDrinks.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(AllDrinks.this, "UBER", Toast.LENGTH_SHORT).show();
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
                            startActivity(new Intent(AllDrinks.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(AllDrinks.this, Login.class));
                        }
                    }
                    default:
                        return AllDrinks.super.onOptionsItemSelected(item);
                }
            }
        });

        //set up recyclerview with firebase
        recyclerView = findViewById(R.id.topdrinks_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetch();
    }

    public void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Info")
                .child("Drinks");

        FirebaseRecyclerOptions<TopDrinksModel> options =
                new FirebaseRecyclerOptions.Builder<TopDrinksModel>()
                        .setQuery(query, TopDrinksModel.class)
                        .build();


        adapter = new FirebaseRecyclerAdapter<TopDrinksModel, TopDrinksViewHolder>(options) {


            @Override
            public TopDrinksViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_topdrinks, viewGroup, false);
                return new TopDrinksViewHolder(view);
            }


            @Override
            public void onBindViewHolder(final TopDrinksViewHolder holder, final int position, final TopDrinksModel model) {
                holder.setDrinkNameView(model.getDrinkName());
                holder.setDrinkInfoView(model.getDrinkInfo());
                holder.setTotAverageView(model.getTotAverage());

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (model.getDrinkName()) {
                            case "Mojito":
                                startActivity(new Intent(AllDrinks.this, DrinkMojito.class));
                                break;
                            case "Americano":
                                startActivity(new Intent(AllDrinks.this, DrinkAmericano.class));
                                break;
                            case "Aperol Spritz":
                                startActivity(new Intent(AllDrinks.this, DrinkAperolSpritz.class));
                                break;
                            case "Daiquiri":
                                startActivity(new Intent(AllDrinks.this, DrinkDaiquiri.class));
                                break;
                            case "London Mule":
                                startActivity(new Intent(AllDrinks.this, DrinkLondonMule.class));
                                break;
                            case "Long Island Iced Tea":
                                startActivity(new Intent(AllDrinks.this, DrinkLongIslandIcedTea.class));
                                break;
                            case "Margarita":
                                startActivity(new Intent(AllDrinks.this, DrinkMargarita.class));
                                break;
                            case "Tommys1492":
                                startActivity(new Intent(AllDrinks.this, DrinkTommys1492.class));
                                break;
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