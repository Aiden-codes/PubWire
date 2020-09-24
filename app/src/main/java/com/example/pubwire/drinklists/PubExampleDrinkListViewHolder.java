package com.example.pubwire.drinklists;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubwire.R;

public class PubExampleDrinkListViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView drinkNameView;
    public RatingBar drinkRatingView;
    public TextView drinkPriceView;
    public TextView drinkInfoView;

    public PubExampleDrinkListViewHolder(@NonNull View itemView) {
        super(itemView);

        drinkNameView = itemView.findViewById(R.id.pubexample_drinklist_name);
        drinkRatingView = itemView.findViewById(R.id.pubexample_drinklist_rating);
        drinkPriceView = itemView.findViewById(R.id.pubexample_drinklist_price);
        drinkInfoView = itemView.findViewById(R.id.pubexample_drinklist_description);
        cardView = itemView.findViewById(R.id.pubexample_drinklist_cardView);
    }

    public void setDrinkNameView(String string) {
        drinkNameView.setText(string);
    }

    public void setDrinkRatingView(double num) {
        drinkRatingView.setRating((float) num);
    }

    public void setDrinkPriceView(String string) {
        drinkPriceView.setText(string);
    }

    public void setDrinkInfoView(String string) {
        drinkInfoView.setText(string);
    }
}
