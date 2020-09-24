package com.example.pubwire;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubwire.comments.chatwin.MainCommentActivity;
import com.example.pubwire.drinklists.PubExampleDrinkListModel;
import com.example.pubwire.drinklists.PubExampleDrinkListViewHolder;
import com.example.pubwire.drinklists.chatwin.ChatwinDrinkList;
import com.example.pubwire.drinklists.gravity.GravityDrinkList;
import com.example.pubwire.main.MainActivity;
import com.example.pubwire.maps.GoogleMapsActivity;
import com.example.pubwire.profile.AccountActivity;
import com.example.pubwire.profile.Login;
import com.example.pubwire.profile.Register;
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


public class Gravity extends AppCompatActivity {

        FirebaseUser user;
        FirebaseAuth mAuth;

        RatingBar ratingBar;
        ImageButton imgbutton;
        TextView Name, Address, OtherInfo;

        private RecyclerView recyclerView;
        private LinearLayoutManager linearLayoutManager;


        private FirebaseRecyclerAdapter<PubExampleDrinkListModel, PubExampleDrinkListViewHolder> adapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_pubexample);


                BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
                bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                switch (item.getItemId()) {
                                        case R.id.action_maps:
                                                Toast.makeText(Gravity.this, "MAPS", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(Gravity.this, GoogleMapsActivity.class));
                                                break;
                                        case R.id.action_home:
                                                Toast.makeText(Gravity.this, "HOME", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(Gravity.this, MainActivity.class));
                                                break;
                                        case R.id.action_touber:
                                                Toast.makeText(Gravity.this, "UBER", Toast.LENGTH_SHORT).show();
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
                                                        startActivity(new Intent(Gravity.this, AccountActivity.class));
                                                } else {
                                                        startActivity(new Intent(Gravity.this, Login.class));
                                                }
                                        }
                                        default:
                                                return Gravity.super.onOptionsItemSelected(item);
                                }
                        }
                });


                ImageButton button = (ImageButton) findViewById(R.id.btn_tocomment);
                button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(Gravity.this, com.example.pubwire.comments.gravity.MainCommentActivity.class));
                        }
                });


                ratingBar = findViewById(R.id.pub_example_ratingBar);

                setRatingBarListener();

                imgbutton = findViewById(R.id.pubexample_btntolist);
                imgbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(Gravity.this, GravityDrinkList.class));
                        }
                });



                //set up different pub info
                Name = findViewById(R.id.pub_name);
                Address = findViewById(R.id.pub_address);
                OtherInfo = findViewById(R.id.pub_otherInfo);
                DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                        .child("Gravity")
                        .child("Info");

                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String pubname = "";
                                String pubaddress = "";
                                String pubotherinfo= "";
                                for (DataSnapshot s: snapshot.getChildren()) {
                                        pubname = snapshot.child("Name").getValue(String.class);
                                        pubaddress = snapshot.child("Address").getValue(String.class);
                                        pubotherinfo = snapshot.child("OtherInfo").getValue(String.class);

                                }
                                Name.setText(pubname);
                                Address.setText(pubaddress);
                                OtherInfo.setText(pubotherinfo);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                                throw error.toException();
                        }
                });


                //set up recyclerview with firebase
                recyclerView = findViewById(R.id.pubexample_recyclerViewDrinkList);
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
                                        .child("Gravity")
                                        .child("AverageRating");

                                newdbref.child("current").setValue(average);

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
                        .child("Gravity")
                        .child("DrinkList")
                        .orderByChild("drinkRating")
                        .limitToLast(5);

                FirebaseRecyclerOptions<PubExampleDrinkListModel> options =
                        new FirebaseRecyclerOptions.Builder<PubExampleDrinkListModel>()
                                .setQuery(query, PubExampleDrinkListModel.class)
                                .build();


                adapter = new FirebaseRecyclerAdapter<PubExampleDrinkListModel, PubExampleDrinkListViewHolder>(options) {


                        @Override
                        public PubExampleDrinkListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                                View view = LayoutInflater.from(viewGroup.getContext())
                                        .inflate(R.layout.item_pubexample_drinklist, viewGroup, false);
                                return new PubExampleDrinkListViewHolder(view);
                        }


                        @Override
                        public void onBindViewHolder(PubExampleDrinkListViewHolder holder, final int position, PubExampleDrinkListModel model) {
                                holder.setDrinkNameView(model.getDrinkName());
                                holder.setDrinkRatingView(model.getDrinkRating());
                                holder.setDrinkPriceView(model.getDrinkPrice());
                                holder.setDrinkInfoView(model.getDrinkInfo());
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


