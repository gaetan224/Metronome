package com.fiil.m2.metronome.modele;

import android.os.SystemClock;
import android.view.View;

import com.fiil.m2.metronome.Main;
import com.fiil.m2.metronome.R;
import com.fiil.m2.metronome.service.Compteur;

import android.os.Handler;
/**
 * Created by Gaetan on 24/12/2015.
 */
public class EcouteurStart implements View.OnClickListener {

    private Main main;


    public EcouteurStart(Main m) {
        this.main = m;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.demarrer){
            if(main.getStart().isChecked()){

                main.startMetronome(50);
               // startMetronome();
            }else{
                main.stopMetronome();
                //stopMetronome();

            }
        }
    }


    // on démarre le clignotant en lui donnant le temps de clignotement (realval)
    public  void startMetronome(){
        long i = System.currentTimeMillis();
        main.getClignote().blink(main.getRealval(), 30);
        long j = System.currentTimeMillis();
        main.getCompteur().start(main.getRealval(), 30 - (j - i));

    }

    public void stopMetronome(){
        main.getClignote().stop();
        main.getCompteur().stop();

    }



}
