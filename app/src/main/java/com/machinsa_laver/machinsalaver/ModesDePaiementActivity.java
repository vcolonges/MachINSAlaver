package com.machinsa_laver.machinsalaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModesDePaiementActivity extends AppCompatActivity {

    private Button button_modifier_cb;

    private TextView tv_numero_cb;
    private TextView tv_date_expiration;
    private TextView tv_cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes_de_paiement);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_modifier_cb = findViewById(R.id.button_modifier_cb);
        tv_numero_cb = findViewById(R.id.tv_numeroCB);
        tv_date_expiration = findViewById(R.id.tv_dateExpiration);
        tv_cvv = findViewById(R.id.tv_cvv);

        initializeListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeValues();
    }

    private void initializeValues(){

        tv_numero_cb.setText(Application.NUMERO_CB.substring(0,4)+" xxxx xxxx xxxx");
        tv_date_expiration.setText(Application.DATE_EXPIRATION);
        tv_cvv.setText(Application.NUMERO_CB.substring(0,0)+"xxx");

    }

    public void initializeListeners(){
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
