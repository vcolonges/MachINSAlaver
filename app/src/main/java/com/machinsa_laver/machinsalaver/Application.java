package com.machinsa_laver.machinsalaver;

import com.machinsa_laver.machinsalaver.fragments.HomeFragment;
import com.machinsa_laver.machinsalaver.model.Machine;

import java.util.ArrayList;

public class Application {

    public static String NUMERO_CB = "1234 1234 1234 1234";
    public static String DATE_EXPIRATION = "08/20";
    public static String CVV = "123";

    public static String TMP_NUMERO_CB = NUMERO_CB;
    public static String TMP_DATE_EXPIRATION = DATE_EXPIRATION;
    public static String TMP_CVV = CVV;

    public static String SOLDE = "8";

    public static String NOM = "Renard";
    public static String PRENOM = "Pierre";
    public static String DATE_NAISSANCE = "01/01/1997";
    public static String EMAIL = "pierre.renard@insa-lyon.fr";
    public static String TELEPHONE = "06.43.57.09.09";
    public static String CARTE_VA = "";

    public static String RESIDENCE = "";

    public static ArrayList<Machine> dataModels;
    public static HomeFragment home;
    public static boolean premier = false;
}
