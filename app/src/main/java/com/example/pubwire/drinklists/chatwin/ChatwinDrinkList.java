package com.example.pubwire.drinklists.chatwin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pubwire.R;
import com.example.pubwire.drinklists.PubExampleDrinkListModel;
import com.example.pubwire.drinklists.PubExampleDrinkListViewHolder;
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

public class ChatwinDrinkList extends AppCompatActivity {

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
                        Toast.makeText(ChatwinDrinkList.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ChatwinDrinkList.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(ChatwinDrinkList.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ChatwinDrinkList.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(ChatwinDrinkList.this, "UBER", Toast.LENGTH_SHORT).show();
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
                            startActivity(new Intent(ChatwinDrinkList.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(ChatwinDrinkList.this, Login.class));
                        }
                    }
                    default:
                        return ChatwinDrinkList.super.onOptionsItemSelected(item);
                }
            }
        });

        //calculate all averages in drinkRating
        ChatwinDrinkListRatingAverage.setRatingAmericano();
        ChatwinDrinkListRatingAverage.setRatingAperolSpritz();
        ChatwinDrinkListRatingAverage.setRatingBlackMojito();
        ChatwinDrinkListRatingAverage.setRatingBramble();
        ChatwinDrinkListRatingAverage.setRatingBrambleWithBrockmans();
        ChatwinDrinkListRatingAverage.setRatingCaipirinha();
        ChatwinDrinkListRatingAverage.setRatingCaipirinhaPremium();
        ChatwinDrinkListRatingAverage.setRatingCaipiroska();
        ChatwinDrinkListRatingAverage.setRatingCaipiroskaFrutta();
        ChatwinDrinkListRatingAverage.setRatingDaiquiri();
        ChatwinDrinkListRatingAverage.setRatingDaiquiri();
        ChatwinDrinkListRatingAverage.setRatingHugoSpritz();
        ChatwinDrinkListRatingAverage.setRatingJapaneseIcedTea();
        ChatwinDrinkListRatingAverage.setRatingLondonMule();
        ChatwinDrinkListRatingAverage.setRatingLongIslandIcedTea();
        ChatwinDrinkListRatingAverage.setRatingMaiTai();
        ChatwinDrinkListRatingAverage.setRatingMargarita();
        ChatwinDrinkListRatingAverage.setRatingMiami();
        ChatwinDrinkListRatingAverage.setRatingMitoDellaSirena();
        ChatwinDrinkListRatingAverage.setRatingMojito();
        ChatwinDrinkListRatingAverage.setRatingMoscowMule();
        ChatwinDrinkListRatingAverage.setRatingNegroni();
        ChatwinDrinkListRatingAverage.setRatingNightTail();
        ChatwinDrinkListRatingAverage.setRatingSbagliato();
        ChatwinDrinkListRatingAverage.setRatingSexOnTheBeach();
        ChatwinDrinkListRatingAverage.setRatingSpecial();
        ChatwinDrinkListRatingAverage.setRatingTimFizz();
        ChatwinDrinkListRatingAverage.setRatingTimSpritz();

        //set up recyclerview with firebase
        recyclerView = findViewById(R.id.pubexample_drinklist_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetch();
    }

    public void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Pub_Example")
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
                        switch (model.getDrinkName()) {
                            case "Americano":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleAmericanoRate.class));
                                break;
                            case "Aperol Spritz":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleAperolSpritzRate.class));
                                break;
                            case "Black Mojito":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleBlackMojitoRate.class));
                                break;
                            case "Bramble":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleBrambleRate.class));
                                break;
                            case "Bramble With Brockman's":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleBrambleWithBrockmansRate.class));
                                break;
                            case "Caipirinha":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleCaipirinhaRate.class));
                                break;
                            case "Caipirinha Premium":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleCaipirinhaPremiumRate.class));
                                break;
                            case "Caipiroska":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleCaipiroskaRate.class));
                                 break;
                            case "Caipiroska Frutta":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleCaipiroskaFruttaRate.class));
                                break;
                            case "Daiquiri":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleDaiquiriRate.class));
                                break;
                            case "HugoSpritz":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleHugoSpritzRate.class));
                                break;
                            case "Japanese Iced Tea":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleJapaneseIcedTeaRate.class));
                                break;
                            case "London Mule":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleLondonMuleRate.class));
                                break;
                            case "Long Island Iced Tea":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleLongIslandIcedTeaRate.class));
                                break;
                            case "Mai Tai":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleMaiTaiRate.class));
                                break;
                            case "Margarita":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleMargaritaRate.class));
                                break;
                            case "Miami":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleMiamiRate.class));
                                break;
                            case "Mito Della Sirena":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleMitoDellaSirenaRate.class));
                                break;
                            case "Mojito":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleMojitoRate.class));
                                break;
                            case "Moscow Mule":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleMoscowMuleRate.class));
                                break;
                            case "Negroni":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleNegroniRate.class));
                                break;
                            case "Night Tail":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleNightTailRate.class));
                                break;
                            case "Sbagliato":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleSbagliatoRate.class));
                                break;
                            case "Sex On The Beach":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleSexOnTheBeachRate.class));
                                break;
                            case "Special":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleSpecialRate.class));
                                break;
                            case "Tim Fizz":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleTimFizzRate.class));
                                break;
                            case "Tim Spritz":
                                startActivity(new Intent(ChatwinDrinkList.this, PubExampleTimSpritzRate.class));
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