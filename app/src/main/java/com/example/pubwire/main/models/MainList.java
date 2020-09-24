package com.example.pubwire.main.models;

public class MainList {

    private String btnName;
    private int btnImage;

    public MainList(String btnName, int btnImage){
        this.btnName = btnName;
        this.btnImage = btnImage;
    }

    public String getBtnName(){
        return btnName;
    }

    public void setBtnName(String btnName){
        this.btnName = btnName;
    }

    public int getBtnImage(){
        return btnImage;
    }

    public void setBtnImage(int btnImage){
        this.btnImage = btnImage;
    }
}
