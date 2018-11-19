package com.machinsa_laver.machinsalaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoisirMontantActivity extends AppCompatActivity {

    private ImageButton button_valider_rechargement;
    private ImageButton button_editer_cb;
    private Button button_ajouter_cb;

    private TextView tv_numero_cb;
    private TextView tv_date_expiration;
    private TextView tv_solde;

    private LinearLayout ll_infos;

    private EditText et_montant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_montant);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button_valider_rechargement = findViewById(R.id.button_valider_rechargement);
        button_editer_cb = findViewById(R.id.button_editer_cb);
        button_ajouter_cb = findViewById(R.id.button_ajouter_cb);

        tv_numero_cb = findViewById(R.id.tv_numeroCB);
        tv_date_expiration = findViewById(R.id.tv_dateExpiration);
        tv_solde = findViewById(R.id.tv_solde);
        tv_solde.setText(Application.SOLDE+"€");

        ll_infos = findViewById(R.id.ll_infos);

        et_montant = findViewById(R.id.et_montant);
        et_montant.setFilters(new InputFilter[] {new DecimalDigitsInputFilter()});

        initializeListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeValues();
    }

    private void initializeValues(){

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

        if(Application.TMP_NUMERO_CB.equals("")){
            button_editer_cb.setVisibility(View.GONE);
            ll_infos.setVisibility(View.GONE);
            button_ajouter_cb.setVisibility(View.VISIBLE);
        }else{
            button_editer_cb.setVisibility(View.VISIBLE);
            ll_infos.setVisibility(View.VISIBLE);
            button_ajouter_cb.setVisibility(View.GONE);
        }

    }

    private void initializeListeners(){

        button_editer_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoisirMontantActivity.this, EditionCBActivity.class);
                intent.putExtra("edition",false);
                startActivity(intent);
            }
        });

        button_ajouter_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoisirMontantActivity.this, EditionCBActivity.class);
                intent.putExtra("edition",false);
                startActivity(intent);
            }
        });

        button_valider_rechargement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Application.TMP_NUMERO_CB.equals("")){
                    Toast.makeText(ChoisirMontantActivity.this, "Carte bancaire non rensignée !",Toast.LENGTH_LONG).show();
                    return;
                }
                if(et_montant.getText().toString().equals("")){
                    Toast.makeText(ChoisirMontantActivity.this, "Aucun montant rensigné !",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(ChoisirMontantActivity.this, ConfirmerInformationsActivity.class);
                intent.putExtra("montant",et_montant.getText().toString());
                startActivityForResult(intent,12);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==12){
            finish();
        }
    }

    public class DecimalDigitsInputFilter implements InputFilter {

        Pattern mPattern;

        public DecimalDigitsInputFilter() {
            mPattern=Pattern.compile("^[0-9]+[.]?[0-9]{0,2}$");
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Toast.makeText(ChoisirMontantActivity.this,dest.toString()+source,Toast.LENGTH_LONG).show();
            Matcher matcher=mPattern.matcher(dest.toString()+source);
            if(!matcher.matches())
                return "";
            return null;
        }

    }

}
