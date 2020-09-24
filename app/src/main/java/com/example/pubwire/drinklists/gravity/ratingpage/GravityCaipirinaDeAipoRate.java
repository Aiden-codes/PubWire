package com.example.pubwire.drinklists.gravity.ratingpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pubwire.R;
import com.example.pubwire.drinklists.gravity.GravityDrinkList;
import com.example.pubwire.main.MainActivity;
import com.example.pubwire.maps.GoogleMapsActivity;
import com.example.pubwire.profile.AccountActivity;
import com.example.pubwire.profile.Login;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class GravityCaipirinaDeAipoRate extends AppCompatActivity {

    Button button;
    String userID;
    TextView name;
    ImageView profilePic;
    FirebaseUser user;
    FirebaseAuth mAuth;
    TextView title;

    FirebaseFirestore mStore;
    StorageReference storageReference;

    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubexample_rate);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_maps:
                        Toast.makeText(GravityCaipirinaDeAipoRate.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(GravityCaipirinaDeAipoRate.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(GravityCaipirinaDeAipoRate.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(GravityCaipirinaDeAipoRate.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(GravityCaipirinaDeAipoRate.this, "UBER", Toast.LENGTH_SHORT).show();
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
                            startActivity(new Intent(GravityCaipirinaDeAipoRate.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(GravityCaipirinaDeAipoRate.this, Login.class));
                        }
                    }
                    default:
                        return GravityCaipirinaDeAipoRate.super.onOptionsItemSelected(item);
                }
            }
        });

        button = findViewById(R.id.pubexample_rating_sendbtn);
        ratingBar = findViewById(R.id.pubexample_rating_ratingbar);
        addListenerOnRatingBar();

        //Set title of rater
        title = findViewById(R.id.pubexample_rating_title);
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                .child("Gravity")
                .child("DrinkList")
                .child("CaipirinaDeAipo");

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String titlename = "";
                for (DataSnapshot s : snapshot.getChildren()) {
                    titlename = snapshot.child("drinkName").getValue(String.class);

                }
                title.setText(titlename);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });



        if(user != null) {
            FirebaseStorage storage = FirebaseStorage.getInstance();

            storageReference = FirebaseStorage.getInstance().getReference();

            profilePic = findViewById(R.id.pubexample_rating_img);
            final StorageReference profileImg = storage.getReference().child("users/" + mAuth.getCurrentUser().getUid() + "/profilepic.jpg");
            profileImg.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).into(profilePic);
                }
            });

            mStore = FirebaseFirestore.getInstance();

            userID = mAuth.getCurrentUser().getUid();
            name = findViewById(R.id.pubexample_rating_username);
            DocumentReference documentReference = mStore.collection("users").document(userID);
            documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    if (e == null) {
                        if (documentSnapshot.exists()) {
                            name.setText(documentSnapshot.getString("mName"));

                        } else {
                            Log.d("tag", "onEvent: Document does not exists");
                        }
                    }
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                            .child("Gravity")
                            .child("DrinkList")
                            .child("CaipirinaDeAipo")
                            .child("Ratings")
                            .push();

                    Map<String, Object> map = new HashMap<>();
                    map.put("drinkRating", ratingBar.getRating());

                    databaseReference.setValue(map);

                    startActivity(new Intent(GravityCaipirinaDeAipoRate.this, GravityDrinkList.class));

                    Toast.makeText(GravityCaipirinaDeAipoRate.this, "Rating submitted!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(GravityCaipirinaDeAipoRate.this, "You need to Log In to rate!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    public void addListenerOnRatingBar() {

        ratingBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float touchPositionX = event.getX();
                    float width = ratingBar.getWidth();
                    float starsF = (touchPositionX / width) * 5.0f;
                    int stars = (int)starsF + 1;
                    ratingBar.setRating(stars);

                    Toast.makeText(GravityCaipirinaDeAipoRate.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
                    v.setPressed(false);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setPressed(true);
                }

                if (event.getAction() == MotionEvent.ACTION_CANCEL) {
                    v.setPressed(false);
                }

                return true;
            }});

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

            }
        });
    }
}