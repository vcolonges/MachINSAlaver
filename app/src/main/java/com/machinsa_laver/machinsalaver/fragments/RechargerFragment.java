package com.machinsa_laver.machinsalaver.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.machinsa_laver.machinsalaver.ChoisirMontantActivity;
import com.machinsa_laver.machinsalaver.EditionCBActivity;
import com.machinsa_laver.machinsalaver.R;

public class RechargerFragment extends Fragment {

    private ImageButton button_info;
    private Button button_recharger_cb;

    public RechargerFragment() {}


    public static RechargerFragment newInstance() {
        RechargerFragment fragment = new RechargerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recharger, container, false);

        button_info = view.findViewById(R.id.button_info);
        button_recharger_cb = view.findViewById(R.id.button_recharger_cb);

        initializeListeners();

        return view;
    }

    private void initializeListeners(){
        button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(inflater.inflate(R.layout.dialog_infos, null)).create().show();
            }
        });

        button_recharger_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(inflater.inflate(R.layout.dialog_validation_connection, null));
                builder.setNeutralButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), ChoisirMontantActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); //create a new one
                layoutParams.weight = 1.0f;
                layoutParams.gravity = Gravity.CENTER; //this is layout_gravity
                dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setLayoutParams(layoutParams);
            }
        });
    }

}
