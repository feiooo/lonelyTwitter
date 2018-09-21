package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

public class DommesticDuck extends Animal implements FlyingBehaviour{

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
