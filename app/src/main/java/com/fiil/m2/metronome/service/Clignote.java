package com.fiil.m2.metronome.service;

import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
/**
 * Created by Gaetan on 24/12/2015.
 */
public class Clignote {

    private TextView text;
    /*protected volatile boolean running = true;
    final Handler handler;

    Thread t;*/

    Animation anim ;


    public Clignote(TextView text) {
        this.text = text;
        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setStartOffset(20);
        //anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
    }

    public void blink(int tempsAclignoter){

        anim.setDuration(tempsAclignoter);
        text.startAnimation(anim);

    }

    public void stop(){
        if(anim.hasStarted())
        text.clearAnimation();

    }


    /*
    public void blink(int tempsAclignoter ){ //timeToBlink en milissecondes

        final int timeToBlink = tempsAclignoter;

        t = new Thread(new Runnable() {
            @Override
            public void run() {

                try{Thread.sleep(timeToBlink);}catch (Exception e) {}

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        if(text.getVisibility() == View.VISIBLE){
                            text.setVisibility(View.INVISIBLE);
                        }else{
                            text.setVisibility(View.VISIBLE);
                        }
                        blink(timeToBlink);
                    }
                });
            }
        });
        t.start();
    }

    Runnable doblink = new Runnable() {
        @Override
        public void run() {

            if(text.getVisibility() == View.VISIBLE){
                text.setVisibility(View.INVISIBLE);
            }else{
                text.setVisibility(View.VISIBLE);
            }
        }
    };

    public void stop(){
    t.stop();

    }

    public void start(){

        running = true;
    }*/


}
