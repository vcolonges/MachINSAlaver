package com.machinsa_laver.machinsalaver.fragments;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.machinsa_laver.machinsalaver.Application;
import com.machinsa_laver.machinsalaver.R;
import com.machinsa_laver.machinsalaver.ScanQRCode;
import com.machinsa_laver.machinsalaver.adapter.MachineAdapter;
import com.machinsa_laver.machinsalaver.model.Machine;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private ListView mListView;
    private TextView solde, residence;

    public ConstraintLayout cl;
    public MachineAdapter adapter;
    ProgressBar mprogressBar;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View finalView = inflater.inflate(R.layout.fragment_home, container, false);

        mprogressBar = (ProgressBar) finalView.findViewById(R.id.circular_progress_bar);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 47, 0);
        anim.setDuration(54*1000);
        //  anim.setInterpolator(new DecelerateInterpolator());
        anim.start();

        mListView = (ListView) finalView.findViewById(R.id.listeResidence);

        adapter = new MachineAdapter(Application.dataModels,getActivity().getApplicationContext());

        mListView.setAdapter(adapter);

        this.solde = (TextView) finalView.findViewById(R.id.solde);
        solde.setText(Application.SOLDE);
        this.residence= (TextView) finalView.findViewById(R.id.residence);
        this.residence.setText(Application.RESIDENCE);
        Button payer = (Button) finalView.findViewById(R.id.payer);
        payer.setOnClickListener(this);

        Application.home = this;

        cl = finalView.findViewById(R.id.timer);
        if(Application.premier == false){
            cl.setVisibility(View.GONE);
            Application.premier = true;
        }

        return finalView;
    }

    public void onClick(View view) {

        int soldeRestant = Integer.parseInt(solde.getText().toString());

        int montant = 2;

        if(Application.CARTE_VA.equals("")){
            montant = 5;
        }

        if(soldeRestant >= montant) {

            boolean aDejaTrouveMachineLibre = false;
            for(Machine m : Application.dataModels){
                if(!aDejaTrouveMachineLibre){
                    if(m.getEtat().equals("Disponible")){
                        aDejaTrouveMachineLibre = true;
                    }
                }
            }

            if(!aDejaTrouveMachineLibre){
                Toast.makeText(view.getContext().getApplicationContext(), "Aucune machine n'est disponible pour le moment",
                        Toast.LENGTH_SHORT).show();
            }else {
                solde.setText(String.valueOf(soldeRestant - montant));
                Application.SOLDE = String.valueOf(soldeRestant - montant);
                Intent intent = new Intent(getActivity(), ScanQRCode.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        }else{
            Toast.makeText(view.getContext().getApplicationContext(), "Votre solde est insuffisant.\nVeuillez recharger votre compte",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
