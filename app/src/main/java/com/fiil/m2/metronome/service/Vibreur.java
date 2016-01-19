package com.fiil.m2.metronome.service;

import android.content.Context;
import android.os.Vibrator;

import com.fiil.m2.metronome.Main;

/**
 * Created by Gaetan on 19/01/2016.
 */
public class Vibreur {

    private Main main;
    private Vibrator vibreur;

    public Vibreur(Main main) {
        this.main = main;
        vibreur = (Vibrator) main.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void vibre(int tempAvibrer, long offset){

        long temps = tempAvibrer -100;
        long[] pattern = {offset, temps, 100}; // 1: temps avant de commencer 2: durée d'une vibration, 3: intervale de temps qui sépare les vibration


        vibreur.vibrate(pattern, 0); // repeter a l'infini
        //vibreur.vibrate(tempAvibrer);
    }

    public  void stop(){

        vibreur.cancel();
    }
}
