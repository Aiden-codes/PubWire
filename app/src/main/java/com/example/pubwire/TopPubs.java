package com.example.pubwire;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class TopPubs extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    private FirebaseRecyclerAdapter<TopPubsModel, TopPubsViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppubs);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_maps:
                        Toast.makeText(TopPubs.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TopPubs.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(TopPubs.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TopPubs.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(TopPubs.this, "UBER", Toast.LENGTH_SHORT).show();
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
                            startActivity(new Intent(TopPubs.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(TopPubs.this, Login.class));
                        }
                    }
                    default:
                        return TopPubs.super.onOptionsItemSelected(item);
                }
            }
        });

        TopPubsAverage.setRatingChatwin();
        TopPubsAverage.setRatingSaditappo();
        TopPubsAverage.setRatingGravity();

        //set up recyclerview with firebase
        recyclerView = findViewById(R.id.toppubs_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetch();
    }

    public void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Info")
                .orderByChild("Average")
                .limitToLast(3);

        FirebaseRecyclerOptions<TopPubsModel> options =
                new FirebaseRecyclerOptions.Builder<TopPubsModel>()
                        .setQuery(query, TopPubsModel.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<TopPubsModel, TopPubsViewHolder>(options) {

            @Override
            public TopPubsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_publist, viewGroup, false);
                return new TopPubsViewHolder(view);
            }

            @Override
            public void onBindViewHolder(final TopPubsViewHolder holder, final int position, final TopPubsModel model) {
                if (adapter.getRef(position).getKey().equals("Drinks")) {
                    holder.cardView.setVisibility(View.INVISIBLE);
                    holder.cardView.setLayoutParams(new CardView.LayoutParams(0, 0));
                } else {
                    holder.setNameView(model.getName());
                    holder.setAddressView(model.getAddress());
                    holder.setInfoView(model.getOtherInfo());
                    holder.setAverage(model.getAverage());

                    holder.cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent;
                            switch (model.getName()) {
                                case "Chatwin Cafè":
                                    startActivity(new Intent(TopPubs.this, Chatwin.class));
                                    break;
                                case "Saditappo Gourmet":
                                    startActivity(new Intent(TopPubs.this, Saditappo.class));
                                    break;
                                case "Gravity Lounge & Food":
                                    startActivity(new Intent(TopPubs.this, Gravity.class));
                                default:
                                    break;
                            }
                        }

                        ;
                    });

                }
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