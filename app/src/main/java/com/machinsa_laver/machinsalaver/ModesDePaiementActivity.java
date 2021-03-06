package com.machinsa_laver.machinsalaver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ModesDePaiementActivity extends AppCompatActivity {

    private Button button_ajouter_cb;
    private Button button_modifier_cb;
    private Button button_supprimer_cb;

    private TextView tv_titre_cb;
    private TextView tv_numero_cb;
    private TextView tv_date_expiration;
    private TextView tv_cvv;
    private TextView tv_ajout;

    private LinearLayout ll_cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes_de_paiement);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_ajouter_cb = findViewById(R.id.button_ajouter_cb);
        button_modifier_cb = findViewById(R.id.button_modifier_cb);
        button_supprimer_cb = findViewById(R.id.button_supprimer_cb);

        tv_titre_cb = findViewById(R.id.tv_titre_cb);
        tv_numero_cb = findViewById(R.id.tv_numeroCB);
        tv_date_expiration = findViewById(R.id.tv_dateExpiration);
        tv_cvv = findViewById(R.id.tv_cvv);
        tv_ajout = findViewById(R.id.tv_ajout);

        ll_cb = findViewById(R.id.ll_cb);

        initializeListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeValues();
    }

    private void initializeValues(){

        if(Application.NUMERO_CB.equals("")){
            tv_titre_cb.setVisibility(View.GONE);
            tv_ajout.setVisibility(View.VISIBLE);
            button_ajouter_cb.setVisibility(View.VISIBLE);
            ll_cb.setVisibility(View.GONE);
            button_modifier_cb.setVisibility(View.GONE);
            button_supprimer_cb.setVisibility(View.GONE);
        }else{
            tv_titre_cb.setVisibility(View.VISIBLE);
            tv_ajout.setVisibility(View.GONE);
            button_ajouter_cb.setVisibility(View.GONE);
            ll_cb.setVisibility(View.VISIBLE);
            button_modifier_cb.setVisibility(View.VISIBLE);
            button_supprimer_cb.setVisibility(View.VISIBLE);
            tv_numero_cb.setText(Application.NUMERO_CB.substring(0,4)+" xxxx xxxx xxxx");
            tv_date_expiration.setText(Application.DATE_EXPIRATION);
            tv_cvv.setText("***");
        }

    }

    public void initializeListeners(){
        button_supprimer_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Application.NUMERO_CB = "";
                Application.DATE_EXPIRATION = "";
                Application.CVV = "";
                Application.TMP_NUMERO_CB = "";
                Application.TMP_DATE_EXPIRATION = "";
                Application.TMP_CVV = "";

                Toast.makeText(ModesDePaiementActivity.this,"Carte bancaire supprimée !",Toast.LENGTH_LONG).show();
                ModesDePaiementActivity.this.onResume();
            }
        });

        button_ajouter_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModesDePaiementActivity.this, EditionCBActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        button_modifier_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModesDePaiementActivity.this, EditionCBActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
