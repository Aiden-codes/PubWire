package com.example.pubwire;

public class TopDrinksModel {

    String drinkName;
    String drinkInfo;
    private double TotAverage;

    public TopDrinksModel() {
        //empty constructor for Firebase
    }

    public TopDrinksModel(String drinkName, String drinkInfo, double TotAverage) {
        this.drinkName = drinkName;
        this.drinkInfo = drinkInfo;
        this.TotAverage = TotAverage;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkInfo() {
        return drinkInfo;
    }

    public void setDrinkInfo(String drinkInfo) {
        this.drinkInfo = drinkInfo;
    }

    public double getTotAverage() {
        return TotAverage;
    }

    public void setTotAverage(double TotAverage) {
        this.TotAverage = TotAverage;
    }
}
