package com.example.pubwire.drinklists;

public class PubExampleDrinkListModel {

    String drinkName;
    double drinkRating;
    String drinkPrice;
    String drinkInfo;

    public PubExampleDrinkListModel () {
        //Default empty constructor for Firebase
    }

    public PubExampleDrinkListModel(String drinkName, double drinkRating, String drinkPrice, String drinkInfo) {
        this.drinkName = drinkName;
        this.drinkRating = drinkRating;
        this.drinkPrice = drinkPrice;
        this.drinkInfo = drinkInfo;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public double getDrinkRating() {
        return drinkRating;
    }

    public void setDrinkRating(double drinkRating) {
        this.drinkRating = drinkRating;
    }

    public String getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(String drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String getDrinkInfo() {
        return drinkInfo;
    }

    public void setDrinkInfo(String drinkInfo) {
        this.drinkInfo = drinkInfo;
    }
}
