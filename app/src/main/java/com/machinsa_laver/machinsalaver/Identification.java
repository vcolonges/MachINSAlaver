package com.machinsa_laver.machinsalaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Identification extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        Button connecter = (Button) findViewById(R.id.connecter);
        connecter.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent = new Intent(this, ChoixResidence.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
}
