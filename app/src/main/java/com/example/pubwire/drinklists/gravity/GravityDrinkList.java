package com.example.pubwire.drinklists.gravity;

import android.content.Context;
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

import com.example.pubwire.R;
import com.example.pubwire.drinklists.PubExampleDrinkListModel;
import com.example.pubwire.drinklists.PubExampleDrinkListViewHolder;
import com.example.pubwire.drinklists.chatwin.ChatwinDrinkListRatingAverage;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleAmericanoRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleAperolSpritzRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleBlackMojitoRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleBrambleRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleBrambleWithBrockmansRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleCaipirinhaPremiumRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleCaipirinhaRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleCaipiroskaFruttaRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleCaipiroskaRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleDaiquiriRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleHugoSpritzRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleJapaneseIcedTeaRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleLondonMuleRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleLongIslandIcedTeaRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleMaiTaiRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleMargaritaRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleMiamiRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleMitoDellaSirenaRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleMojitoRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleMoscowMuleRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleNegroniRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleNightTailRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleSbagliatoRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleSexOnTheBeachRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleSpecialRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleTimFizzRate;
import com.example.pubwire.drinklists.chatwin.ratingpage.PubExampleTimSpritzRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityAppletiniRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityCaipirinaDeAipoRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityCerisePunchRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityGrayAppleRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityIndianSpritzRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityIngleseSpagnoloItalianoRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityMartiniDoItBitterRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityMexicoNuvoleRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityRosaMoskataRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityRosaRosaRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravitySMayfairRate;
import com.example.pubwire.drinklists.gravity.ratingpage.GravityTommys1492Rate;
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

public class GravityDrinkList extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    private FirebaseRecyclerAdapter<PubExampleDrinkListModel, PubExampleDrinkListViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubexample_drinklist);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_maps:
                        Toast.makeText(GravityDrinkList.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(GravityDrinkList.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(GravityDrinkList.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(GravityDrinkList.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(GravityDrinkList.this, "UBER", Toast.LENGTH_SHORT).show();
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
                            startActivity(new Intent(GravityDrinkList.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(GravityDrinkList.this, Login.class));
                        }
                    }
                    default:
                        return GravityDrinkList.super.onOptionsItemSelected(item);
                }
            }
        });

        //calculate all averages in drinkRating
        GravityDrinkListRatingAverage.setRatingAppletini();
        GravityDrinkListRatingAverage.setRatingCaipirinaDeAipo();
        GravityDrinkListRatingAverage.setRatingCerisePunch();
        GravityDrinkListRatingAverage.setRatingGrayApple();
        GravityDrinkListRatingAverage.setRatingIndianSpritz();
        GravityDrinkListRatingAverage.setRatingIngleseSpagnoloItaliano();
        GravityDrinkListRatingAverage.setRatingMartiniDoItBitter();
        GravityDrinkListRatingAverage.setRatingMexicoNuvole();
        GravityDrinkListRatingAverage.setRatingRosaMoskata();
        GravityDrinkListRatingAverage.setRatingRosaRosa();
        GravityDrinkListRatingAverage.setRatingSMayfair();
        GravityDrinkListRatingAverage.setRatingTommys1492();


        //set up recyclerview with firebase
        recyclerView = findViewById(R.id.pubexample_drinklist_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetch();
    }

    public void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Gravity")
                .child("DrinkList");

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
            public void onBindViewHolder(PubExampleDrinkListViewHolder holder, final int position, final PubExampleDrinkListModel model) {
                holder.setDrinkNameView(model.getDrinkName());
                holder.setDrinkRatingView(model.getDrinkRating());
                holder.setDrinkPriceView(model.getDrinkPrice());
                holder.setDrinkInfoView(model.getDrinkInfo());

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent;
                        switch (model.getDrinkName()) {
                            case "Appletini L'Originale":
                                startActivity(new Intent(GravityDrinkList.this, GravityAppletiniRate.class));
                                break;
                            case "Caipirina de Aipo":
                                startActivity(new Intent(GravityDrinkList.this, GravityCaipirinaDeAipoRate.class));
                                break;
                            case "Cerise Punch":
                                startActivity(new Intent(GravityDrinkList.this, GravityCerisePunchRate.class));
                                break;
                            case "Gray Apple":
                                startActivity(new Intent(GravityDrinkList.this, GravityGrayAppleRate.class));
                                break;
                            case "Indian Spritz":
                                startActivity(new Intent(GravityDrinkList.this, GravityIndianSpritzRate.class));
                                break;
                            case "C’erano un inglese, uno spagnolo e un italiano":
                                startActivity(new Intent(GravityDrinkList.this, GravityIngleseSpagnoloItalianoRate.class));
                                break;
                            case "Martini Do It Bitter":
                                startActivity(new Intent(GravityDrinkList.this, GravityMartiniDoItBitterRate.class));
                                break;
                            case "Mexico e Nuvole":
                                startActivity(new Intent(GravityDrinkList.this, GravityMexicoNuvoleRate.class));
                                 break;
                            case "Rosa Moskata":
                                startActivity(new Intent(GravityDrinkList.this, GravityRosaMoskataRate.class));
                                break;
                            case "Rosa Rosa":
                                startActivity(new Intent(GravityDrinkList.this, GravityRosaRosaRate.class));
                                break;
                            case "S-Mayfair":
                                startActivity(new Intent(GravityDrinkList.this, GravitySMayfairRate.class));
                                break;
                            case "Tommy’s 1492":
                                startActivity(new Intent(GravityDrinkList.this, GravityTommys1492Rate.class));
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