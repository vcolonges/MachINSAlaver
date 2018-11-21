package com.machinsa_laver.machinsalaver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ConfirmerInformationsActivity extends AppCompatActivity {

    private boolean valide = false;

    private String montant;

    private Button button_confirmer;
    private Button button_accueil;

    private TextView tv_numero_cb;
    private TextView tv_date_expiration;
    private TextView tv_montant;

    private LinearLayout ll_validation;
    private LinearLayout ll_nouveau_solde;
    private TextView tv_nouveau_solde;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirmer_informations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        montant = getIntent().getStringExtra("montant");

        button_confirmer = findViewById(R.id.button_confirmer);
        button_accueil = findViewById(R.id.button_accueil);

        tv_numero_cb = findViewById(R.id.tv_numero_CB);
        tv_date_expiration = findViewById(R.id.tv_dateExpiration);
        tv_montant = findViewById(R.id.tv_montant);

        ll_validation = findViewById(R.id.ll_validation);
        ll_nouveau_solde = findViewById(R.id.ll_nouveau_solde);
        tv_nouveau_solde = findViewById(R.id.tv_nouveau_solde);
        tv_title = findViewById(R.id.tv_title);

        initializeListeners();
        initializeValues();
    }

    private void initializeValues() {
        tv_montant.setText(montant+"€");

        if(Application.TMP_NUMERO_CB.equals("")){
            tv_numero_cb.setText("Non renseigné");
        }else{
            tv_numero_cb.setText(Application.TMP_NUMERO_CB.substring(0,4)+" xxxx xxxx xxxx");
        }

        if(Application.TMP_DATE_EXPIRATION.equals("")){
            tv_date_expiration.setText("Non renseigné");
        }else{
            tv_date_expiration.setText(Application.TMP_DATE_EXPIRATION);
        }
    }

    private void initializeListeners() {
        button_confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dmontant = Integer.parseInt(montant);
                int dsolde = Integer.parseInt(Application.SOLDE)+dmontant;
                tv_nouveau_solde.setText(dsolde+"€");
                Application.SOLDE = String.valueOf(dsolde);
                ll_validation.setVisibility(View.VISIBLE);
                ll_nouveau_solde.setVisibility(View.VISIBLE);
                button_accueil.setVisibility(View.VISIBLE);
                tv_title.setVisibility(View.GONE);
                button_confirmer.setVisibility(View.GONE);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                valide = true;
            }
        });

        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(12);
                finish();
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
    public void onBackPressed() {
        if(!valide){
            super.onBackPressed();
        }
    }
}
