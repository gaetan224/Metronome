package com.fiil.m2.metronome;

import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.util.Log;

import com.fiil.m2.metronome.modele.EcouteurStart;
import com.fiil.m2.metronome.service.Clignote;


public class Main extends Activity {

    // temps de mesure [1,10]
    private static final int Min_Value = 1;
    private static final int Max_Value = 10;


    //button demarrer/arreter
    private ToggleButton start;

    //service clignote
    private Clignote clignote = null;

    //le texte clignotant
    private TextView affichtemps = null;

    private TextView tempo = null;

    private TextView temps = null;

    private Button plustempo = null;
    private Button plustemps = null;
    private Button moinstempo = null;
    private Button moinstemps = null;


    //
    private  int vaLtempo = 20;

    private  int vaLtemps = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buildWidgets();
    }

    private void buildWidgets() {
        //le clignotant
        affichtemps = (TextView) findViewById(R.id.clignote);
        affichtemps.setText(vaLtemps+"coups");
        clignote = new Clignote(affichtemps);
        clignote.blink(1000);

        //button demarrer/arreter
        start = (ToggleButton) findViewById(R.id.demarrer);
        start.setOnClickListener(new EcouteurStart(this));

        tempo = (TextView) findViewById(R.id.tempo);
        tempo.setText(""+vaLtempo);

        temps = (TextView) findViewById(R.id.temps);
        temps.setText(""+vaLtemps);

        plustempo = (Button) findViewById(R.id.plustempo);

    }


}
