package com.example.pubwire.drinks.models;

public class DrinksModel {

    String Name;
    String Price;
    double Average;

    public DrinksModel (){
        //empty for Firebase
    }

    public DrinksModel(String Name, double Average, String Price) {
        this.Name = Name;
        this.Average = Average;
        this.Price = Price;
    }

    public double getAverage() {
        return Average;
    }

    public void setAverage(double Average) {
        this.Average = Average;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
}
