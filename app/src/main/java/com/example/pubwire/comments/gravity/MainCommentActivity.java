package com.example.pubwire.comments.gravity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubwire.R;
import com.example.pubwire.comments.models.ShowComment;
import com.example.pubwire.comments.viewholders.CommentViewHolder;
import com.example.pubwire.main.MainActivity;
import com.example.pubwire.maps.GoogleMapsActivity;
import com.example.pubwire.profile.AccountActivity;
import com.example.pubwire.profile.Login;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
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

public class MainCommentActivity extends AppCompatActivity {

    ImageView showprofilePic;
    RatingBar ratingBar;
    TextView ratingNum;
    Button button;
    String userID;
    TextView name;
    EditText editText;
    ImageView profilePic;
    FirebaseUser user;
    FirebaseAuth mAuth;

    FirebaseFirestore mStore;
    StorageReference storageReference;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    private FirebaseRecyclerAdapter<ShowComment, CommentViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_maps:
                        Toast.makeText(MainCommentActivity.this, "MAPS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainCommentActivity.this, GoogleMapsActivity.class));
                        break;
                    case R.id.action_home:
                        Toast.makeText(MainCommentActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainCommentActivity.this, MainActivity.class));
                        break;
                    case R.id.action_touber:
                        Toast.makeText(MainCommentActivity.this, "UBER", Toast.LENGTH_SHORT).show();
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
                            startActivity(new Intent(MainCommentActivity.this, AccountActivity.class));
                        } else {
                            startActivity(new Intent(MainCommentActivity.this, Login.class));
                        }
                    }
                    default:
                        return MainCommentActivity.super.onOptionsItemSelected(item);
                }
            }
        });

        ratingBar = findViewById(R.id.commentadd_ratingBar);
        addListenerOnRatingBar();

        button = findViewById(R.id.commentadd_sendbtn);

        if(user != null) {
            FirebaseStorage storage = FirebaseStorage.getInstance();

            storageReference = FirebaseStorage.getInstance().getReference();

            profilePic = findViewById(R.id.commentadd_image);
            final StorageReference profileImg = storage.getReference().child("users/" + mAuth.getCurrentUser().getUid() + "/profilepic.jpg");
            profileImg.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).into(profilePic);
                }
            });

            mStore = FirebaseFirestore.getInstance();

            userID = mAuth.getCurrentUser().getUid();
            name = findViewById(R.id.commentadd_user);
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

            editText = findViewById(R.id.commentadd_edit);
            //starNum = findViewById(R.id.addComment_ratingBar)



            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Gravity").child("Comments").push();
                    Map<String, Object> map = new HashMap<>();
                    map.put("mName", name.getText().toString());
                    map.put("body", editText.getText().toString());
                    map.put("starCount", (double) ratingBar.getRating());
                    map.put("profilePic", profileImg.getDownloadUrl().toString());

                    databaseReference.setValue(map);
                    editText.setText("");
                    ratingBar.setRating(0);

                }
            });
        } else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainCommentActivity.this, "Log in to Comment", Toast.LENGTH_SHORT).show();
                }
            });
        }

        recyclerView = findViewById(R.id.showcomment_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        showprofilePic = findViewById(R.id.commentshow_image);

        fetch();


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

                    Toast.makeText(MainCommentActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
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


    public void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Gravity")
                .child("Comments");

        FirebaseRecyclerOptions<ShowComment> options =
                new FirebaseRecyclerOptions.Builder<ShowComment>()
                        .setQuery(query, ShowComment.class)
                        .build();


        adapter = new FirebaseRecyclerAdapter<ShowComment, CommentViewHolder>(options) {

            @Override
            public CommentViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_comment, viewGroup, false);
                return new CommentViewHolder(view);
            }


            @Override
            public void onBindViewHolder(CommentViewHolder holder, final int position, final ShowComment model) {
                holder.setUserView(model.getUser());
                holder.setUserPicView(model.getProfilePic());
                holder.setBodyView(model.getBody());
                holder.setStarView(model.getStarCount());
                //holder.setNumStarsView(model.getStarNum());

                holder.root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainCommentActivity.this, String.valueOf(model.getStarCount()), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        };
        recyclerView.setAdapter(adapter);

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int commentCount = adapter.getItemCount();
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();

                if(lastPosition == -1 || (positionStart >= (commentCount - 1) && lastPosition == (positionStart - 1))) {
                    recyclerView.scrollToPosition(positionStart);
                }
            }
        });


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