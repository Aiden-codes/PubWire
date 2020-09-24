package com.example.pubwire.main;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.pubwire.profile.AccountActivity;
import com.example.pubwire.maps.GoogleMapsActivity;
import com.example.pubwire.profile.Login;
import com.example.pubwire.main.viewholders.MainAdapter;
import com.example.pubwire.main.models.MainList;
import com.example.pubwire.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

//TODO : Change pictures to overcome stretch

public class MainActivity extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;

    LinearLayoutManager horizontalLayout;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ArrayList<MainList> mainArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_main);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        horizontalLayout = new LinearLayoutManager
                (MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayout);

        SnapHelper helper = new PagerSnapHelper();
        helper.attachToRecyclerView(recyclerView);


        mainArrayList = new ArrayList<>();

        adapter = new MainAdapter(this, mainArrayList);

        recyclerView.setAdapter(adapter);

        createListDataMain();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_maps:
                        Toast.makeText(MainActivity.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_touber:
                        Toast.makeText(MainActivity.this, "UBER", Toast.LENGTH_SHORT).show();
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
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_account: {
                        if (user != null) {
                                startActivity(new Intent(MainActivity.this, AccountActivity.class));
                            } else {
                                startActivity(new Intent(MainActivity.this, Login.class));
                            }
                        }
                    default:
                        return MainActivity.super.onOptionsItemSelected(item);
                }
            }
        });

    }

    private void createListDataMain() {
        MainList main = new MainList("TOP PUBS", R.drawable.manybottles);
        mainArrayList.add(main);

        main = new MainList("ALL PUBS", R.drawable.glasses);
        mainArrayList.add(main);

        main = new MainList("TOP DRINKS", R.drawable.drinkprep);
        mainArrayList.add(main);

        main = new MainList("ALL DRINKS", R.drawable.drinksprepper);
        mainArrayList.add(main);
    }
}