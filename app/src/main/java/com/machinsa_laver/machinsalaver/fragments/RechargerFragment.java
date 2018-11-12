package com.machinsa_laver.machinsalaver.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.machinsa_laver.machinsalaver.R;

public class RechargerFragment extends Fragment {

    private ImageButton buttonInfo;

    public RechargerFragment() {}


    public static RechargerFragment newInstance() {
        RechargerFragment fragment = new RechargerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recharger, container, false);

        this.buttonInfo = (ImageButton)view.findViewById(R.id.button_info);
        this.buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(inflater.inflate(R.layout.dialog_infos, null)).create().show();
            }
        });

        return view;
    }

}
