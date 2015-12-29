package com.fiil.m2.metronome.service;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
/**
 * Created by Gaetan on 24/12/2015.
 */
public class Clignote {

    private TextView text;

    public Clignote(TextView text) {
        this.text = text;
    }

    public void blink(int tempsAclignoter ){ //timeToBlink en milissegunds
        final Handler handler = new Handler();
        final int timeToBlink = tempsAclignoter;

        new Thread(new Runnable() {
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
        }).start();
    }
}
