package com.machinsa_laver.machinsalaver.model;

/**
 * Created by AlexandreLang on 20/11/2018.
 */

public class ResidenceImage {
    private String nom;
    private boolean estLaResidenceCourante;

    public ResidenceImage(String nom, boolean estLaResidenceCourante) {
        this.nom = nom;
        this.estLaResidenceCourante = estLaResidenceCourante;
    }

    public String getNom() {
        return nom;
    }
    public boolean getEstLaResidenceCourante() {
        return estLaResidenceCourante;
    }
    public void setEstLaResidenceCourante(boolean v){
        this.estLaResidenceCourante = v;
    }

}
