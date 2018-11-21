package com.machinsa_laver.machinsalaver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    public static String residence;
    public static String carteVa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

        String isPremiereConnexionTerminee = pref.getString("isPremiereConnexionTerminee", null);

        if(isPremiereConnexionTerminee == null){
            Intent intent = new Intent(this, Identification.class);
            startActivity(intent);
            this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
    }
}
