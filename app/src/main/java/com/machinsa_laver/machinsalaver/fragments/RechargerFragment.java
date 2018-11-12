package com.machinsa_laver.machinsalaver.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.machinsa_laver.machinsalaver.R;

public class RechargerFragment extends Fragment {

    public RechargerFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RechargerFragment newInstance() {
        RechargerFragment fragment = new RechargerFragment();
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
        return inflater.inflate(R.layout.fragment_recharger, container, false);
    }

}
