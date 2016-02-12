package com.fiil.m2.metronome.service;



import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;

import com.fiil.m2.metronome.Main;
import com.fiil.m2.metronome.R;

/**
 * Created by Gaetan on 19/01/2016.
 */
public class BipAccentuer {

    protected MediaPlayer mediaPlayer;
    private Handler myHandler;


    private int interval;


    public BipAccentuer(Main main) {

        mediaPlayer = MediaPlayer.create(main, R.raw.son_1024);

        myHandler = new Handler();
        mediaPlayer.setVolume(0.05f, 0.05f);

    }

    public void start(int tempBip,long offset)  {
        interval = tempBip;
        myHandler.postDelayed(doStart,offset);

    }

    public  void stop(){

        mediaPlayer.pause();
        myHandler.removeCallbacks(doStart);

    }




    private Runnable doStart = new Runnable() {
        @Override
        public void run() {

            mediaPlayer.start();
            myHandler.postDelayed(doStart, interval);


        }
    };




    public void destroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }

        mediaPlayer.release();
        myHandler.removeCallbacks(doStart);
    }
}
