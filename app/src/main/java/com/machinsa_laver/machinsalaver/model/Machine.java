package com.machinsa_laver.machinsalaver.model;

/**
 * Created by AlexandreLang on 12/11/2018.
 */

public class Machine {

    private String num, etat, temps;

    public Machine(String num, String etat, String temps) {
        this.num = num;
        this.etat = etat;
        this.temps = temps;
    }

    public String getEtat() {
        return etat;
    }

    public String getNum() {
        return num;
    }

    public String getTemps() {
        return temps;
    }
}
