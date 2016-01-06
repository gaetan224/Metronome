package com.fiil.m2.metronome;

import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.util.Log;

import com.fiil.m2.metronome.modele.EcouteurPlusMoinsTempo;
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



    //valeur du tempo (vitesse)
    private  int vaLtempo = 100;

    private  int vaLtemps = 1;

    //temps pour une battement
    private int realval = (int) ((60.0/vaLtempo)*1000);

    //numero de battment ou son ou clignote [1 .. 10]
    private int bat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buildWidgets();
    }

    private void buildWidgets() {
        //le clignotant
        affichtemps = (TextView) findViewById(R.id.clignote);
        affichtemps.setText(vaLtemps+"");
        clignote = new Clignote(affichtemps);
        //clignote.blink(vaLtempo);




        //affichtemps.clearAnimation();




        //button demarrer/arreter
        start = (ToggleButton) findViewById(R.id.demarrer);
        start.setOnClickListener(new EcouteurStart(this));

        tempo = (TextView) findViewById(R.id.tempo);
        tempo.setText(""+vaLtempo);

        temps = (TextView) findViewById(R.id.temps);
        temps.setText(""+vaLtemps);

        //recuperation des bouton plus et moins du tempo(vitesse)
        plustempo = (Button) findViewById(R.id.plustempo);
        moinstempo = (Button) findViewById(R.id.moinstempo);
        //onjet ecouteur
        EcouteurPlusMoinsTempo ecouteurPlusMoinsTempo = new EcouteurPlusMoinsTempo(this);

        plustempo.setOnClickListener(ecouteurPlusMoinsTempo);
        moinstempo.setOnClickListener(ecouteurPlusMoinsTempo);

        plustempo.setOnTouchListener(ecouteurPlusMoinsTempo);
        moinstempo.setOnTouchListener(ecouteurPlusMoinsTempo);

        //le temps du battement
        temps = (TextView) findViewById(R.id.temps);


        plustempo = (Button) findViewById(R.id.plustempo);

        plustemps = (Button) findViewById(R.id.plustemps);
        plustemps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView temps = (TextView) findViewById(R.id.temps);
                String battement = temps.getText().toString();
                bat = Integer.parseInt(battement);
                bat++;
                if (bat > Max_Value)
                    bat=Min_Value;
                temps.setText(""+bat);

            }
        });

        moinstemps = (Button) findViewById(R.id.moinstemps);
        moinstemps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView temps = (TextView) findViewById(R.id.temps);
                String battement = temps.getText().toString();
                int bat = Integer.parseInt(battement);
                bat--;
                if (bat < Min_Value)
                    bat = Max_Value;
                temps.setText("" + bat);
            }
        });


    }



    public static int getMax_Value() {
        return Max_Value;
    }

    public static int getMin_Value() {
        return Min_Value;
    }

    public Clignote getClignote() {
        return clignote;
    }

    public ToggleButton getStart() {
        return start;
    }

    public TextView getAffichtemps() {
        return affichtemps;
    }

    public TextView getTempo() {
        return tempo;
    }

    public TextView getTemps() {
        return temps;
    }

    public Button getPlustempo() {
        return plustempo;
    }

    public Button getPlustemps() {
        return plustemps;
    }

    public Button getMoinstempo() {
        return moinstempo;
    }

    public Button getMoinstemps() {
        return moinstemps;
    }

    public int getVaLtempo() {return vaLtempo;}

    public int getVaLtemps() {
        return vaLtemps;
    }

    public void setStart(ToggleButton start) {
        this.start = start;
    }

    public void setClignote(Clignote clignote) {
        this.clignote = clignote;
    }

    public void setAffichtemps(TextView affichtemps) {
        this.affichtemps = affichtemps;
    }

    public void setTempo(TextView tempo) {
        this.tempo = tempo;
    }

    public void setTemps(TextView temps) {
        this.temps = temps;
    }

    public void setPlustempo(Button plustempo) {
        this.plustempo = plustempo;
    }

    public void setPlustemps(Button plustemps) {
        this.plustemps = plustemps;
    }

    public void setMoinstempo(Button moinstempo) {
        this.moinstempo = moinstempo;
    }

    public void setMoinstemps(Button moinstemps) {
        this.moinstemps = moinstemps;
    }

   public void setVaLtempo(int vaLtempo) {this.vaLtempo = vaLtempo;}

    public void setVaLtemps(int vaLtemps) {
        this.vaLtemps = vaLtemps;
    }

    public void setRealval(int realval) {
        this.realval = realval;
    }

    public int getRealval() {
        return realval;
    }
}
