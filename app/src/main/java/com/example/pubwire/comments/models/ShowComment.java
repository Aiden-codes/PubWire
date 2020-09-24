package com.example.pubwire.comments.models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.storage.FirebaseStorage;

// [START post_class]
@IgnoreExtraProperties
public class ShowComment {

    public String profilePic;
    //public String uid;
    public String mName;
    public String body;
    public double starCount = 0;
    public String starNum;

    public ShowComment() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public ShowComment(String profilePic, String mName, String body, float starCount) {
        this.profilePic = profilePic;
        //this.uid = uid;
        this.mName = mName;
        this.body = body;
        this.starCount = starCount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /*public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }*/

    public String getUser() {
        return mName;
    }

    public void setUser(String mName) {
        this.mName = mName;
    }

    public double getStarCount() {
        return starCount;
    }

    public void setStarCount(float starCount) {
        this.starCount = starCount;
    }

   /* public String getStarNum() {
        return starNum;
    }*/

    /*public void setStarNum(String starNum) {
        this.starNum = starNum;
    }*/

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}