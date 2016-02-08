package com.fiil.m2.metronome.service;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import com.fiil.m2.metronome.Main;
import com.fiil.m2.metronome.R;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Gaetan on 06/01/2016.
 */
public class Compteur  {

    private Main main;
    private int  counter=0;

  /*  private long startTime = 0L;
    private Handler customHandler = new Handler();
    private long timeInMilliseconds = 0L;
    private long timeSwapBuff = 0L;
    private long updatedTime = 0L;*/
  Timer timer;
    TimerTask task;
    //le texte clignotant
    private TextView affichtemps = null;

    public Compteur(Main main) {

        this.main = main;
    }




    public  void start(int tempsACompter,long offset){ // temps a compter

        //Log.d("Start : ", "starting ... compteur");
        stop();
        timer = new Timer();
        task = new TimerTask(){

            public void run() {
                counter++;
                //Log.d("bat", "bat dans TimerTask "+main.getBat());
                if(counter > main.getBat()) counter = main.getMin_Value();
                //if(counter < main.getMin_Value()) counter = main.getBat();



                // pour que la modification se fasse dans le meme thread que le main
                main.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                      //  Log.d("Compteur UITHread", "Compteur ="+counter);


                        main.getAffichtemps().setText("" + counter);
                    }});

                }
            };


        timer.scheduleAtFixedRate(task, offset, tempsACompter);


    }

    public void stop(){

      /*  timeSwapBuff += timeInMilliseconds;
        customHandler.removeCallbacks(updateTimerThread);*/
        if(timer != null)
        timer.cancel();
    }



}
