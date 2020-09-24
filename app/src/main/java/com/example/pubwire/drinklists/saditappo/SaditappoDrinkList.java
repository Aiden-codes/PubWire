package com.example.pubwire.drinklists.saditappo;

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
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoAmericanoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoAperolSpritzRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoBloodyMaryRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoCampariOrangeRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoCampariSpritzRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoCubaPestatoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoDaiquiriRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoGinSourRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoHugoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoLondonMuleRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoLongIslandIcedTeaRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMargaritaRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMartiniBiancoSpritzRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMartiniCocktailRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMartiniRossoSummerRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMartiniRoyalRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMilanoCardanoTorinoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMilanoTorinoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMojitoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoMoscowMuleRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoNegroniRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoNegroskiRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoP31GreenSpritzRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoPomodoroConditoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoQuattroBianchiRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoSaditappoAnalcolicoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoSbagliatoRate;
import com.example.pubwire.drinklists.saditappo.ratingpage.SaditappoVodkaSourRate;
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

public class SaditappoDrinkList extends AppCompatActivity {

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
                        Toast.makeText(SaditappoDrinkList.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SaditappoDrinkList.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(SaditappoDrinkList.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SaditappoDrinkList.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(SaditappoDrinkList.this, "UBER", Toast.LENGTH_SHORT).show();
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
                            startActivity(new Intent(SaditappoDrinkList.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(SaditappoDrinkList.this, Login.class));
                        }
                    }
                    default:
                        return SaditappoDrinkList.super.onOptionsItemSelected(item);
                }
            }
        });

        //calculate all averages in drinkRating
        SaditappoDrinkListRatingAverage.setRatingAmericano();
        SaditappoDrinkListRatingAverage.setRatingAperolSpritz();
        SaditappoDrinkListRatingAverage.setRatingBloodyMary();
        SaditappoDrinkListRatingAverage.setRatingCampariOrange();
        SaditappoDrinkListRatingAverage.setRatingCampariSpritz();
        SaditappoDrinkListRatingAverage.setRatingCubaPestato();
        SaditappoDrinkListRatingAverage.setRatingDaiquiri();
        SaditappoDrinkListRatingAverage.setRatingGinSour();
        SaditappoDrinkListRatingAverage.setRatingHugo();
        SaditappoDrinkListRatingAverage.setRatingLondonMule();
        SaditappoDrinkListRatingAverage.setRatingLongIslandIcedTea();
        SaditappoDrinkListRatingAverage.setRatingMargarita();
        SaditappoDrinkListRatingAverage.setRatingMartiniBiancoSpritz();
        SaditappoDrinkListRatingAverage.setRatingMartiniCocktail();
        SaditappoDrinkListRatingAverage.setRatingMartiniRossoSummer();
        SaditappoDrinkListRatingAverage.setRatingMartiniRoyal();
        SaditappoDrinkListRatingAverage.setRatingMilanoCardanoTorino();
        SaditappoDrinkListRatingAverage.setRatingMilanoTorino();
        SaditappoDrinkListRatingAverage.setRatingMojito();
        SaditappoDrinkListRatingAverage.setRatingMoscowMule();
        SaditappoDrinkListRatingAverage.setRatingNegroni();
        SaditappoDrinkListRatingAverage.setRatingNegroski();
        SaditappoDrinkListRatingAverage.setRatingP31GreenSpritz();
        SaditappoDrinkListRatingAverage.setRatingPomodoroCondito();
        SaditappoDrinkListRatingAverage.setRatingQuattroBianchi();
        SaditappoDrinkListRatingAverage.setRatingSaditappoAnalcolico();
        SaditappoDrinkListRatingAverage.setRatingSbagliato();
        SaditappoDrinkListRatingAverage.setRatingVodkaSour();

        //set up recyclerview with firebase
        recyclerView = findViewById(R.id.pubexample_drinklist_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetch();
    }

    public void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("SaditappoGourmet")
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
                            case "Americano":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoAmericanoRate.class));
                                break;
                            case "Aperol Spritz":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoAperolSpritzRate.class));
                                break;
                            case "Bloody Mary":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoBloodyMaryRate.class));
                                break;
                            case "Campari Orange":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoCampariOrangeRate.class));
                                break;
                            case "Campari Spritz":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoCampariSpritzRate.class));
                                break;
                            case "Cuba Pestato":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoCubaPestatoRate.class));
                                break;
                            case "Daiquiri":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoDaiquiriRate.class));
                                break;
                            case "Gin Sour":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoGinSourRate.class));
                                 break;
                            case "Hugo":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoHugoRate.class));
                                break;
                            case "London Mule":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoLondonMuleRate.class));
                                break;
                            case "Long Island Iced Tea":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoLongIslandIcedTeaRate.class));
                                break;
                            case "Margarita":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMargaritaRate.class));
                                break;
                            case "Martini Bianco Spritz":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMartiniBiancoSpritzRate.class));
                                break;
                            case "Martini Cocktail":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMartiniCocktailRate.class));
                                break;
                            case "Martini Rosso 'Summer'":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMartiniRossoSummerRate.class));
                                break;
                            case "Martini Royal":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMartiniRoyalRate.class));
                                break;
                            case "Milano Cardano Torino":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMilanoCardanoTorinoRate.class));
                                break;
                            case "Milano Torino":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMilanoTorinoRate.class));
                                break;
                            case "Mojito":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMojitoRate.class));
                                break;
                            case "Moscow Mule":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoMoscowMuleRate.class));
                                break;
                            case "Negroni":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoNegroniRate.class));
                                break;
                            case "Negroski":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoNegroskiRate.class));
                                break;
                            case "P31 Green Spritz":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoP31GreenSpritzRate.class));
                                break;
                            case "Pomodoro Condito":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoPomodoroConditoRate.class));
                                break;
                            case "Quattro Bianchi":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoQuattroBianchiRate.class));
                                break;
                            case "Saditappo Analcolico":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoSaditappoAnalcolicoRate.class));
                                break;
                            case "Sbagliato":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoSbagliatoRate.class));
                                break;
                            case "Vodka Sour":
                                startActivity(new Intent(SaditappoDrinkList.this, SaditappoVodkaSourRate.class));
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