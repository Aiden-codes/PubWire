package com.example.pubwire;

public class TopPubsModel {

    String Name;
    String OtherInfo;
    String Address;
    private double Average;

    public TopPubsModel () {
        //empty constructor for Firebase
    }

    public TopPubsModel(String Name, String Address, String OtherInfo, double Average) {
        this.Name = Name;
        this.Address = Address;
        this.OtherInfo = OtherInfo;
        this.Average = Average;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }



    public String getAddress(){
        return Address;
    }

    public void setAddress(String Address){
        this.Address = Address;
    }


    public String getOtherInfo() {
        return OtherInfo;
    }

    public void setOtherInfo(String OtherInfo) {
        this.OtherInfo = OtherInfo;
    }


    public double getAverage() {
        return Average;
    }

    public void setAverage(double Average) {
        this.Average = Average;
    }
}
