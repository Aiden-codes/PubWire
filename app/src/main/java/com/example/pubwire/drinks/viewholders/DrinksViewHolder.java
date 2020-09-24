package com.example.pubwire.drinks.viewholders;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubwire.R;

public class DrinksViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView nameView;
    public RatingBar averageView;
    public TextView priceView;


    public DrinksViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.drinkshow_cardView);
        nameView = itemView.findViewById(R.id.drinkshow_name);
        averageView = itemView.findViewById(R.id.drinkshow_rating);
        priceView = itemView.findViewById(R.id.drinkshow_price);
    }

    public void setNameView(String string) {
        nameView.setText(string);
    }

    public void setAverageView (double num) {
        averageView.setRating((float)num);
    }

    public void setPriceView (String string) {
        priceView.setText(string);
    }
}
