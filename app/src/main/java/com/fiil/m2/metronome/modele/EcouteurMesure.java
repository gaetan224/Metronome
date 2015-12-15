package com.fiil.m2.metronome.modele;

import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by Gaetan on 15/12/2015.
 */
public class EcouteurMesure implements NumberPicker.OnValueChangeListener {


    private  TextView txt;
    public EcouteurMesure(TextView txt) {
        this.txt = txt;
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

    }
}
