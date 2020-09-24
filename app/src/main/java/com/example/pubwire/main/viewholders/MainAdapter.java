package com.example.pubwire.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubwire.AllDrinks;
import com.example.pubwire.AllPubs;
import com.example.pubwire.main.models.MainList;
import com.example.pubwire.R;
import com.example.pubwire.TopDrinks;
import com.example.pubwire.TopPubs;

import java.util.ArrayList;

class MainHolder extends RecyclerView.ViewHolder {


    private TextView btnName;
    private ImageView btnImage;
    CardView cardView;

    public MainHolder(View itemView) {
        super(itemView);
        btnName = itemView.findViewById(R.id.main_title);
        btnImage = itemView.findViewById(R.id.main_image);
        cardView = itemView.findViewById(R.id.cardView_main);
    }

    public void setDetails(MainList main){
        btnName.setText(main.getBtnName());
        btnImage.setImageResource(main.getBtnImage());
    }


}

public class MainAdapter extends RecyclerView.Adapter<MainHolder> {

    private Context context;
    private ArrayList<MainList> mainCards;

    public MainAdapter(Context context, ArrayList<MainList> mainCards){
        this.context = context;
        this.mainCards = mainCards;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mainpage, viewGroup, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, final int position) {

        MainList mainList = mainCards.get(position);
        holder.setDetails(mainList);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context, TopPubs.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, AllPubs.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, TopDrinks.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, AllDrinks.class);
                        context.startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mainCards.size();
    }
}
