package com.fiil.m2.metronome;

import android.widget.NumberPicker;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.fiil.m2.metronome.modele.EcouteurMesure;

public class Main extends Activity {

    // temps de mesure [1,10]
    private NumberPicker np = null;
    private static final int Min_Value = 1;
    private static final int Max_Value = 10;

    //text temps
    private TextView temps = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buildWidgets();
    }


    public void buildWidgets(){

        //text temps
        temps = (TextView)findViewById(R.id.temps);

        //config temps mesure (la roulette)
        np = (NumberPicker) findViewById(R.id.temps_mesure);
        np.setMinValue(Min_Value);
        np.setMaxValue(Max_Value);
        np.setWrapSelectorWheel(true);
        np.setOnValueChangedListener(new EcouteurMesure(temps));


    }

}
