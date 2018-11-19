package com.machinsa_laver.machinsalaver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

public class EditionCBActivity extends AppCompatActivity {

    private boolean edition;
    private boolean sauvegarder;

    private Button button_valider;

    private EditText et_numero_cb;
    private EditText et_date_expiration;
    private EditText et_cvv;

    private LinearLayout ll_sauvegarder;
    private Switch sw_sauvegarder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition_cb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edition = getIntent().getBooleanExtra("edition",true);

        button_valider = findViewById(R.id.button_valider_cb);

        et_numero_cb = findViewById(R.id.et_numero_cb);
        et_date_expiration = findViewById(R.id.et_date);
        et_cvv = findViewById(R.id.et_cvv);

        ll_sauvegarder = findViewById(R.id.ll_sauvegarder);
        if(!edition){
            ll_sauvegarder.setVisibility(View.VISIBLE);
        }
        sw_sauvegarder = findViewById(R.id.switch1);

        initializeListeners();
    }

    public void initializeListeners(){
        button_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edition || sauvegarder){
                    Application.NUMERO_CB = et_numero_cb.getText().toString();
                    Application.DATE_EXPIRATION = et_date_expiration.getText().toString();
                    Application.CVV = et_cvv.getText().toString();
                }
                Application.TMP_NUMERO_CB = et_numero_cb.getText().toString();
                Application.TMP_DATE_EXPIRATION = et_date_expiration.getText().toString();
                Application.TMP_CVV = et_cvv.getText().toString();
                EditionCBActivity.this.finish();
            }
        });


        et_numero_cb.addTextChangedListener(new TextWatcher() {
            private int pos;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                pos=et_numero_cb.getText().length();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(et_numero_cb.getText().length()==4 && pos!=5){
                    et_numero_cb.setText(et_numero_cb.getText().toString()+" ");
                    et_numero_cb.setSelection(5);
                }else if(et_numero_cb.getText().length()==9 && pos!=10){
                    et_numero_cb.setText(et_numero_cb.getText().toString()+" ");
                    et_numero_cb.setSelection(10);
                }else if(et_numero_cb.getText().length()==14 && pos!=15){
                    et_numero_cb.setText(et_numero_cb.getText().toString()+" ");
                    et_numero_cb.setSelection(15);
                }
            }
        });

        et_date_expiration.addTextChangedListener(new TextWatcher() {
            private int pos;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                pos=et_date_expiration.getText().length();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(et_date_expiration.getText().length()==2 && pos!=3){
                    et_date_expiration.setText(et_date_expiration.getText().toString()+"/");
                    et_date_expiration.setSelection(3);
                }
            }
        });

        sw_sauvegarder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sauvegarder = isChecked;
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
