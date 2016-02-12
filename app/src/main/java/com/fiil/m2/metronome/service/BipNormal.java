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
public class BipNormal implements  Runnable{
    //private ToneGenerator tg;
    private MediaPlayer mediaPlayer;
    private Handler myHandler;
   /*int chimeCount = 0;
    int chime;  */

    private final int repeats;
    private final int interval;
    private int currentRepeat;
    Main main;

    MediaPlayer.OnCompletionListener chimeCompletion;

    public BipNormal(Main main) {
        this.main = main;
        mediaPlayer = MediaPlayer.create(this.main, R.raw.son_1023);
        // bip repeter a l'infini
        //mediaPlayer.setLooping(true);
        //mediaPlayer.setOnPreparedListener(preparedListenerStart);
        myHandler = new Handler();
        mediaPlayer.setVolume(0.03f, 0.03f);
        this.repeats = Integer.MAX_VALUE;
        this.interval = 2000;

        chimeCompletion = new MediaPlayer.OnCompletionListener() {
            //int count = 0;
            //int maxCount = chimeCount;
            @Override
            public void onCompletion(MediaPlayer mp) {
               // if(count < maxCount) {
                   // count++;
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(chimeCompletion);
                //}
            }
        };




        //tg=new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
    }

    public void start(int tempBip,long offset)  {


        mediaPlayer.start();
        if (currentRepeat < repeats) {
            // set to beep again
            currentRepeat = currentRepeat + 1;
            myHandler.postDelayed(this, interval);
        }
        else {
            // beep is over, just reset the counter
            reset();
        }

       /* if (chime == 0) {

            myHandler.postDelayed(tenMinChime, 5000);
            chime = 1;
        }*/

      /* Log.d("Bignormal", "duree = "+mediaPlayer.getDuration());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Log.d("Bignormal", "5 secondes");
                chimeCompletion = new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {

                                 mediaPlayer.seekTo(0);
                                 mediaPlayer.start();

                    }
                };
                //displayData();  // display the data
                //mediaPlayer.seekTo(0);
                // mediaPlayer.start();
            }
        }, offset, 5000);*/





      /*  chimeCompletion = new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.start();

            }
        };
        myHandler.postDelayed(tenMinChime, 5000);*/
        //tg.startTone(ToneGenerator.TONE_DTMF_0, tempBip);

    }

    public  void stop(){
        mediaPlayer.pause();
        myHandler.removeCallbacks(this);
      /*  if (chime == 1) {
          myHandler.removeCallbacks(tenMinChime);
            chime = 0;
        }*/
       // tg.stopTone();
    }

    @Override
    public void run() {
        mediaPlayer.start();
        if (currentRepeat < repeats) {
            // set to beep again
            currentRepeat = currentRepeat + 1;
            myHandler.postDelayed(this, interval);
        }
        else {
            // beep is over, just reset the counter
            reset();
        }
    }

    public void reset() {
        currentRepeat = 0;
    }

    public void destroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }

        mediaPlayer.release();
        myHandler.removeCallbacks(this);
    }


  /*  MediaPlayer.OnPreparedListener preparedListenerStart = new MediaPlayer.OnPreparedListener() {

        @Override
        public void onPrepared(MediaPlayer mp) {
            // Do something. For example: playButton.setEnabled(true);
            mediaPlayer.start();
        }
    };*/

/*

chimeCompletion = new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                //mediaPlayer.pause();

                //mediaPlayer.seekTo(0);
                Log.d("Bignormal", "bip fini");

                int delay = 5000; // delay for 1 sec.
                int period = 5000; // repeat every 10 sec.
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    public void run() {
                        Log.d("Bignormal", "5 secondes");
                        //displayData();  // display the data
                        //mediaPlayer.seekTo(0);
                       // mediaPlayer.start();
                    }
                }, 0,5000);
            }
        };mediaPlayer.setOnCompletionListener(chimeCompletion);
*/

/*

    public Runnable tenMinChime = new Runnable() {
        public void run() {
            //chimeCount+=1;
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(chimeCompletion);
        }
    };*/
}
