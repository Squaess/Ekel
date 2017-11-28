package com.example.babar.ekel.MyListView;

/**
 * Created by silentnauscopy on 11/19/17
 */

public class DataModel {

    Boolean available;
    int mealId;
    String name;
    String price;

    public DataModel(Boolean available, int mealId, String name, String price){
        this.available = available;
        this.mealId = mealId;
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }

    public int getMealId(){
        return mealId;
    }

    public boolean isAvailable(){
        return available;
    }
}
