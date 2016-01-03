package com.fiil.m2.metronome.service;

/**
 * Created by sarra on 03/01/2016.
 */
public enum Temps{
        un("1"),
        deux("2"),
        trois("3"),
        quatre("4"),
        cinq("5"),
        six("6"),
        sept("7"),
        huit("8"),
        neuf("9"),
        dix("10");

        private String battement;

        Temps(String battement) {
            this.battement = battement;
        }

        @Override public String toString() {
            return battement;
        }

         public int getNum() {
             return Integer.parseInt(battement);
         }

}


