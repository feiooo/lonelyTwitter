/*
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 */

/**
 * Created by FeiYang on 04/10/18.
 */

package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

/**
 * The type Dommestic duck.
 */
public class DommesticDuck extends Animal implements FlyingBehaviour{

    /**
     * Instantiates a new Dommestic duck.
     *
     * @param type the type
     * @param food the food
     */
    public DommesticDuck(String type, String food){

        super(type, food);
    }

    public void swim(){

        Log.d("cmput-301", "Year, I love to swim");
    }

    public void doesLikeFlying(){

        Log.d("chowdhury", "No, I fly only when a cat attacks me");
    }

}
