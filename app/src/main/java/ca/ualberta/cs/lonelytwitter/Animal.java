/*
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;


/**
 * Created by FeiYang on 04/10/18.
 */


import android.util.Log;

public abstract class Animal {
    protected String type;
    protected String food;

    public Animal(String type, String food){
        this.type = type;
        this.food = food;
    }

    public void setType(String type){
        this.type = type;
    }
    public void setFood(String food){
        this.food = food;
    }

    public String getType(){
        return this.type;
    }

    public String getFood(){
        return this.food;
    }

    public void swim()
     {
     Log.d("cmput-301", "I love to swim");

    }

}
