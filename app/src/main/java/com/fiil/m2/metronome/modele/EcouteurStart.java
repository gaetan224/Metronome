package com.fiil.m2.metronome.modele;

import android.view.View;

import com.fiil.m2.metronome.Main;
import com.fiil.m2.metronome.R;

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
                // on démarre le clignotant en lui donnant le temps de clignotement (realval)
                main.getClignote().blink(main.getRealval());

            }else{
                main.getClignote().stop();
            }
        }


    }
}
