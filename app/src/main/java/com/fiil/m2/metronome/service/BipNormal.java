package com.fiil.m2.metronome.service;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Handler;
import android.util.Log;

import com.fiil.m2.metronome.Main;
import com.fiil.m2.metronome.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Gaetan on 19/01/2016.
 */

/*
* http://marblemice.blogspot.fr/2010/04/generate-and-play-tone-in-android.html
* freq 500-200 hz
* */
public class BipNormal{

    protected MediaPlayer mediaPlayer;
    private Handler myHandler;


    private int interval;


    public BipNormal(Main main) {

        mediaPlayer = MediaPlayer.create(main, R.raw.son_1023);

        myHandler = new Handler();
        mediaPlayer.setVolume(0.05f, 0.05f);

    }

    public void start(int tempBip,long offset)  {
        interval = tempBip;
        myHandler.postDelayed(doStart,offset);

    }

    public  void stop(){

        if(mediaPlayer.isPlaying())
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
