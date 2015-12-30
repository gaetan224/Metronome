package com.fiil.m2.metronome.modele;

import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fiil.m2.metronome.Main;
import com.fiil.m2.metronome.R;



/**
 * Created by Gaetan on 30/12/2015.
 */
public class EcouteurPlusMoinsTempo implements  View.OnClickListener, View.OnTouchListener{

    //l'activité principal pour recuperer ses view let les mettre  a jour
    private Main main;

    //valeur du tempo (vitesse)
    private  int vaLtempo = 100;

    //valeur min et max du tempo
    private static final int Min_Value = 10;
    private static final int Max_Value = 260;
    private static final int Maintain_Value = 5;

    // pour gerer l'incrémentation et décrementation continue des bouton tempo plus et moins
    private Handler mHandler;

    public EcouteurPlusMoinsTempo(Main main) {

        this.main = main;
    }

        // si on click on incémente par pas de 1
    @Override
    public void onClick(View v) {
     //   doAction(v,1);

        switch (v.getId()) {
            // si c'est plus
            case R.id.plustempo:
                doActionInc(1);
                break;
            // si c'est moins
            case R.id.moinstempo:
                doActionDec(1);
                break;

        }


    }

        // si on click on maintien en incrémente par pas de 5
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN: // si on maintien le bouton plus ou moins
                if (mHandler != null) return true;
                mHandler = new Handler();

                switch (v.getId()) {
                    // si c'est plus
                    case R.id.plustempo:

                        mHandler.postDelayed(ActionInc, 500);
                        break;
                    // si c'est moins
                    case R.id.moinstempo:

                        mHandler.postDelayed(ActionDec, 500);
                        break;

                }

                break;
            case MotionEvent.ACTION_UP: // si on relashe le bouton plus ou moins
                if (mHandler == null) return true;

                switch (v.getId()) {
                    // si c'est plus
                    case R.id.plustempo: // si on relashe le bouton plus

                        mHandler.removeCallbacks(ActionInc); // on retire la callback de l'incrémention (on arrete d'incrémenter)
                        break;
                    // si c'est moins
                    case R.id.moinstempo: // si on relashe le bouton moins

                        mHandler.removeCallbacks(ActionDec); // on retire la callback de d"crementation (on arrete de decrémenter)
                        break;

                }
                mHandler = null;
                break;
        }

            // false pour ne pas absorber le click simple
        return false;
    }

  // la callback de l'incrémentation continue
    Runnable ActionInc = new Runnable() {
        @Override public void run() {
            Log.d("actionInc", "Performing actionINc...");
            doActionInc(Maintain_Value);
            mHandler.postDelayed(this, 500);
        }
    };

    Runnable ActionDec = new Runnable() {
        @Override public void run() {
            Log.d("actionDec", "Performing actionDec...");
            doActionDec(Maintain_Value);
            mHandler.postDelayed(this, 500);
        }
    };


    //private static final int factplus = 350;



    public void  doActionInc( int inc){
        // si c'est plus


        vaLtempo+=inc;
        realval-=inc;
        realval = (realval < 0 || vaLtempo > Max_Value)? Max_Value:realval;
        vaLtempo = (vaLtempo > Max_Value)? Min_Value:vaLtempo;

        Log.d("realval: ", "realval = "+realval);
        main.setVaLtempo(vaLtempo);
        if(main.getStart().isChecked()){

            main.getClignote().blink(realval);
        }else{
            main.getClignote().stop();
        }
        //mise a jour de la valeur tempo de l'activité principal
        main.setVaLtempo(vaLtempo);
        main.getTempo().setText(vaLtempo+"");
    }

    //static int realvaldec = 100;
    //static int realvalInc = 100;
    int realval = Max_Value - 100;

    public void  doActionDec( int inc){
        // si c'est moins
        vaLtempo-=inc;
        realval+=inc;
        realval = (realval > Max_Value  || vaLtempo < Min_Value)? Min_Value:realval;
        vaLtempo = (vaLtempo < Min_Value)? Max_Value:vaLtempo;

        Log.d("realval: ", "realval = "+realval);
        if(main.getStart().isChecked()){

            main.getClignote().blink((realval));
        }else{
            main.getClignote().stop();
        }
        //mise a jour de la valeur tempo de l'activité principal
        main.setVaLtempo(vaLtempo);
        main.getTempo().setText(vaLtempo+"");
    }

}
