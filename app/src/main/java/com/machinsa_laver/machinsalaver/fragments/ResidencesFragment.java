package com.machinsa_laver.machinsalaver.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.machinsa_laver.machinsalaver.Application;
import com.machinsa_laver.machinsalaver.R;
import com.machinsa_laver.machinsalaver.SaisirVA;
import com.machinsa_laver.machinsalaver.adapter.MachineAdapter;
import com.machinsa_laver.machinsalaver.adapter.ResidenceImageAdapter;
import com.machinsa_laver.machinsalaver.model.Machine;
import com.machinsa_laver.machinsalaver.model.Residence;
import com.machinsa_laver.machinsalaver.model.ResidenceImage;

import java.util.ArrayList;

public class ResidencesFragment extends Fragment {
    private ListView mListView;
    private TextView residenceC;
    ArrayList<ResidenceImage> dataModels;
    private static ResidenceImageAdapter adapter;

    public ResidencesFragment() {
        // Required empty public constructor
    }

    public static ResidencesFragment newInstance(String param1, String param2) {
        ResidencesFragment fragment = new ResidencesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View finalView = inflater.inflate(R.layout.fragment_residences, container, false);

        mListView = (ListView) finalView.findViewById(R.id.listResi);

        dataModels= new ArrayList<>();
        ArrayList<String> listeResi = new ArrayList<>();
        listeResi.add("Résidence B");
        listeResi.add("Résidence D");
        listeResi.add("Résidence E");
        listeResi.add("Résidence F");
        listeResi.add("Résidence G/J");
        listeResi.add("Résidence H");
        listeResi.add("Résidence I");

        for (String res : listeResi){
            boolean resCourante = false;
            if(Application.RESIDENCE.equals(res)) {
                resCourante = true;
            }
            dataModels.add(new ResidenceImage(res, resCourante));
        }

        adapter = new ResidenceImageAdapter(dataModels,getActivity().getApplicationContext());

        mListView.setAdapter(adapter);

        this.residenceC = (TextView) finalView.findViewById(R.id.residencecourante);
        residenceC.setText("Résidence actuelle : "+Application.RESIDENCE);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                ResidenceImage entry = (ResidenceImage) parent.getItemAtPosition(position);

                Application.RESIDENCE = entry.getNom();
                residenceC.setText("Résidence actuelle : "+Application.RESIDENCE);

              //  entry.setEstLaResidenceCourante(true);

     /*           Fragment frag = new HomeFragment();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);


                val transaction = supportFragmentManager.beginTransaction()
                val tag = fragments[index].tag

                // if the fragment has not yet been added to the container, add it first
                if (supportFragmentManager.findFragmentByTag(tag) == null) {
                    transaction.add(R.id.container, fragments[index], tag)
                }

                transaction.hide(fragments[navigationBar.currentTabPosition])
                transaction.show(fragments[index])
                transaction.commit()



                ft.commit();*/
            }
        });

        return finalView;
    }

}
