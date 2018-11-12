package com.machinsa_laver.machinsalaver.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.machinsa_laver.machinsalaver.R;
import com.machinsa_laver.machinsalaver.adapter.MachineAdapter;
import com.machinsa_laver.machinsalaver.model.Machine;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ListView mListView;
    ArrayList<Machine> dataModels;
    private static MachineAdapter adapter;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

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
        dataModels.add(new Machine("1bbbb","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("2","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));
        dataModels.add(new Machine("1","deededed","dddddd"));

        adapter = new MachineAdapter(dataModels,getActivity().getApplicationContext());


                //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

     //   final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
     //           android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return finalView;
    }

}
