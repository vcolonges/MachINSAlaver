package com.machinsa_laver.machinsalaver;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SaisirVA extends AppCompatActivity implements View.OnClickListener{
    private Button passer, suivant;
    private TextView textVa, message;
    private EditText va;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisir_v);

        this.passer = (Button) findViewById(R.id.passer);
        this.suivant = (Button) findViewById(R.id.suivant);
        this.textVa = (TextView) findViewById(R.id.textva);
        this.message = (TextView) findViewById(R.id.message);
        this.va = (EditText) findViewById(R.id.va);

        passer.setOnClickListener(this);
        suivant.setOnClickListener(this);

        message.setVisibility(View.INVISIBLE);

    }

    public void goToMain(View v){
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void onClick(View v){
        switch (v.getId()) {

            case R.id.passer: {
                goToMain(v);
                break;
            }
            case R.id.suivant: {
                if(va.getText().toString().equals("")){
                    message.setVisibility(View.VISIBLE);
                    textVa.setTextColor(Color.parseColor("#ff0000"));
                    va.setTextColor(Color.parseColor("#ff0000"));
                    va.setHintTextColor(Color.parseColor("#ff0000"));
                    va.setBackground(ContextCompat.getDrawable(v.getContext(), R.drawable.redwithborder));
                }else{
                    Application.CARTE_VA = va.getText().toString();
                    goToMain(v);
                }
                break;
            }

            default:
                break;
        }
    }
}
