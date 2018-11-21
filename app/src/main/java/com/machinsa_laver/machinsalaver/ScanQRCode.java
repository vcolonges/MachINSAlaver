package com.machinsa_laver.machinsalaver;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.machinsa_laver.machinsalaver.fragments.HomeFragment;
import com.machinsa_laver.machinsalaver.model.Machine;

import java.util.ArrayList;

public class ScanQRCode extends AppCompatActivity implements View.OnClickListener {

    private Machine machineChoisie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button retour = findViewById(R.id.retour);
        retour.setOnClickListener(this);

        ArrayList<Machine> newDataModels = new ArrayList<>();

        boolean aDejaTrouveMachineLibre = false;
        for(Machine m : Application.dataModels){
            if(!aDejaTrouveMachineLibre){
                if(m.getEtat().equals("Disponible")){
                    machineChoisie = new Machine("5","Occupée","54 min");
                    aDejaTrouveMachineLibre = true;
                }
            }else {
                if(m.getEtat().equals("Hors service")){
                    newDataModels.add(machineChoisie);
                    newDataModels.add(m);
                }else{
                    newDataModels.add(m);
                }
            }
        }

        Application.dataModels = newDataModels;
        Application.home.adapter.notifyDataSetChanged();
    }

    public void onClick(View v) {
        Application.home.cl.setVisibility(View.VISIBLE);
        this.finish();
        Application.home.adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Application.home.adapter.notifyDataSetChanged();
                Application.home.cl.setVisibility(View.VISIBLE);
                this.finish();
                Application.home.adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
