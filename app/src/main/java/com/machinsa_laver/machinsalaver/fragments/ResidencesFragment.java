package com.machinsa_laver.machinsalaver.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.machinsa_laver.machinsalaver.R;

public class ResidencesFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_residences, container, false);
    }

}
