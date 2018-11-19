package com.machinsa_laver.machinsalaver.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.machinsa_laver.machinsalaver.R;
import com.machinsa_laver.machinsalaver.adapter.MachineAdapter;
import com.machinsa_laver.machinsalaver.model.Machine;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ListView mListView;
    ArrayList<Machine> dataModels;
    private static MachineAdapter adapter;

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

        mListView = (ListView) finalView.findViewById(R.id.listeResidence);

        dataModels= new ArrayList<>();
        dataModels.add(new Machine("1","Disponible",""));
        dataModels.add(new Machine("1","Disponible",""));
        dataModels.add(new Machine("2","Occupée","40 min"));
        dataModels.add(new Machine("3","Occupée","40 min"));
        dataModels.add(new Machine("4","Occupée","40 min"));
        dataModels.add(new Machine("5","Hors service",""));
        dataModels.add(new Machine("6","Hors service",""));
        dataModels.add(new Machine("7","Hors service",""));

        adapter = new MachineAdapter(dataModels,getActivity().getApplicationContext());

        mListView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return finalView;
    }

}
