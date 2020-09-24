package com.example.pubwire;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TopPubsViewHolder extends RecyclerView.ViewHolder {

    public TextView NameView, InfoView, AddressView;
    public RatingBar AverageView;
    public CardView cardView;

    public TopPubsViewHolder(@NonNull View itemView) {
        super(itemView);

        NameView = itemView.findViewById(R.id.publist_name);
        InfoView = itemView.findViewById(R.id.publist_info);
        AddressView = itemView.findViewById(R.id.publist_address);
        AverageView = itemView.findViewById(R.id.publist_ratingBar);
        cardView = itemView.findViewById(R.id.publist_cardView);
    }

    public void setAddressView(String string) {
        AddressView.setText(string);
    }

    public void setInfoView(String string) {
        InfoView.setText(string);
    }

    public void setNameView(String string) {
        NameView.setText(string);
    }

    public void setAverage(double num) {
        AverageView.setRating((float) num);
    }
}
