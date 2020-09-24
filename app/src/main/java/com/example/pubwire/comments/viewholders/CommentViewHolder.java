package com.example.pubwire.comments.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pubwire.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout root;
    public CircleImageView profilePicView;
    public TextView userView;
    public RatingBar starView;
    //public TextView numStarsView;
    public TextView bodyView;

    public CommentViewHolder(View itemView) {
        super(itemView);

        root = itemView.findViewById(R.id.layout_root);
        profilePicView = itemView.findViewById(R.id.commentshow_image);
        userView = itemView.findViewById(R.id.commentshow_user);
        starView = itemView.findViewById(R.id.commentshow_ratingBar);
        //numStarsView = itemView.findViewById(R.id.commentshow_starNum);
        bodyView = itemView.findViewById(R.id.commentshow_body);
    }


    public void setBodyView(String string) {
       bodyView.setText(string);
    }


    public void setUserView(String string) {
        userView.setText(string);
    }

    public void setStarView(double num) {
        starView.setRating((float) num);
    }

    /*public void setNumStarsView(String string) {
        numStarsView.setText(string);
    }*/

    public void setUserPicView(String profilePic) {

        Picasso.get().load(profilePic).placeholder(R.drawable.ic_action_account_circle_40).into(profilePicView);
    }
}
