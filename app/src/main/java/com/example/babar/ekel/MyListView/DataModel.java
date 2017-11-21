package com.example.babar.ekel.MyListView;

/**
 * Created by silentnauscopy on 11/19/17.
 */

public class DataModel {
    String name;
    String price;

    public DataModel(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }
}
