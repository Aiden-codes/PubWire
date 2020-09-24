package com.example.pubwire;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TopDrinksViewHolder extends RecyclerView.ViewHolder {

    public TextView drinkNameView, drinkInfoView;
    public RatingBar totAverageView;
    public CardView cardView;

    public TopDrinksViewHolder(@NonNull View itemView) {
        super(itemView);

        drinkNameView = itemView.findViewById(R.id.topdrinks_name);
        drinkInfoView = itemView.findViewById(R.id.topdrinks_info);
        totAverageView = itemView.findViewById(R.id.topdrinks_ratingBar);
        cardView = itemView.findViewById(R.id.topdrinks_cardView);
    }

    public void setDrinkInfoView(String string) {
        drinkInfoView.setText(string);
    }

    public void setDrinkNameView(String string) {
        drinkNameView.setText(string);
    }

    public void setTotAverageView(double num) {
        totAverageView.setRating((float)num);
    }
}
