package com.fiil.m2.metronome.service;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;

import com.fiil.m2.metronome.Main;
import com.fiil.m2.metronome.R;

import java.io.IOException;

/**
 * Created by Gaetan on 19/01/2016.
 */

/*
* http://marblemice.blogspot.fr/2010/04/generate-and-play-tone-in-android.html
* freq 500-200 hz
* */
public class BipNormal {
    //private ToneGenerator tg;
    private MediaPlayer mediaPlayer;

    public BipNormal(Main main) {
        mediaPlayer = MediaPlayer.create(main, R.raw.song_400);
        // bip repeter a l'infini
        mediaPlayer.setLooping(true);
        //mediaPlayer.setOnPreparedListener(preparedListenerStart);





        //tg=new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
    }

    public void start(int tempBip)  {

        mediaPlayer.start();
        //tg.startTone(ToneGenerator.TONE_DTMF_0, tempBip);

        }

    public  void stop(){
        mediaPlayer.pause();

       // tg.stopTone();
    }


  /*  MediaPlayer.OnPreparedListener preparedListenerStart = new MediaPlayer.OnPreparedListener() {

        @Override
        public void onPrepared(MediaPlayer mp) {
            // Do something. For example: playButton.setEnabled(true);
            mediaPlayer.start();
        }
    };*/


}
