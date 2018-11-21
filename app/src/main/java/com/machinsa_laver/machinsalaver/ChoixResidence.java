package com.machinsa_laver.machinsalaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.machinsa_laver.machinsalaver.adapter.MachineAdapter;
import com.machinsa_laver.machinsalaver.adapter.ResidenceAdapter;
import com.machinsa_laver.machinsalaver.model.Machine;
import com.machinsa_laver.machinsalaver.model.Residence;

import java.util.ArrayList;

public class ChoixResidence extends AppCompatActivity {
    private ListView mListView;
    private TextView solde;
    ArrayList<Residence> dataModels;
    private static ResidenceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_residence);

        mListView = (ListView) findViewById(R.id.list);

        dataModels= new ArrayList<>();
        dataModels.add(new Residence("Résidence B"));
        dataModels.add(new Residence("Résidence D"));
        dataModels.add(new Residence("Résidence E"));
        dataModels.add(new Residence("Résidence F"));
        dataModels.add(new Residence("Résidence G/J"));
        dataModels.add(new Residence("Résidence H"));
        dataModels.add(new Residence("Résidence I"));

        adapter = new ResidenceAdapter(dataModels,this);

        mListView.setAdapter(adapter);


        Application.dataModels = new ArrayList<>();
        Application.dataModels.add(new Machine("5.","Disponible",""));
        Application.dataModels.add(new Machine("6.","Occupée","7 min"));
        Application.dataModels.add(new Machine("3.","Occupée","10 min"));
        Application.dataModels.add(new Machine("4.","Occupée","12 min"));
        Application.dataModels.add(new Machine("1.","Occupée","50 min"));
        Application.dataModels.add(new Machine("2.","Hors service",""));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Residence entry = (Residence) parent.getItemAtPosition(position);

                Application.RESIDENCE = entry.getNom();

                Intent intent = new Intent(view.getContext(), SaisirVA.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }
        });
    }
}
