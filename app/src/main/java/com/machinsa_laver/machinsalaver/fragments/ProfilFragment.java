package com.machinsa_laver.machinsalaver.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.machinsa_laver.machinsalaver.ModesDePaiementActivity;
import com.machinsa_laver.machinsalaver.R;


public class ProfilFragment extends Fragment {

    private ImageButton button_edit_carte_VA;
    private ImageButton button_register_carte_VA;
    private ImageButton button_edit_modes;
    private EditText et_carte_VA;

    public ProfilFragment() {}

    public static ProfilFragment newInstance() {
        ProfilFragment fragment = new ProfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        button_edit_carte_VA = view.findViewById(R.id.button_edit_carte_VA);
        button_register_carte_VA = view.findViewById(R.id.button_register_carte_VA);
        et_carte_VA = view.findViewById(R.id.et_carte_VA);
        button_edit_modes = view.findViewById(R.id.button_edit_modes);

        button_edit_carte_VA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_carte_VA.setFocusable(true);
                et_carte_VA.setFocusableInTouchMode(true);
                et_carte_VA.setSelectAllOnFocus(true);
                et_carte_VA.requestFocus();
                button_edit_carte_VA.setVisibility(View.GONE);
                button_register_carte_VA.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(et_carte_VA, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        button_register_carte_VA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Nouvelle carte VA enregistrée", Toast.LENGTH_SHORT).show();
                InputMethodManager inputMethodManager = (InputMethodManager)  getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                et_carte_VA.setFocusable(false);
                et_carte_VA.setFocusableInTouchMode(false);
                button_edit_carte_VA.setVisibility(View.VISIBLE);
                button_register_carte_VA.setVisibility(View.GONE);
            }
        });

        button_edit_modes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModesDePaiementActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        et_carte_VA.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Toast.makeText(getContext(), "Nouvelle carte VA enregistrée", Toast.LENGTH_SHORT).show();
                    InputMethodManager inputMethodManager = (InputMethodManager)  getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                    et_carte_VA.setFocusable(false);
                    et_carte_VA.setFocusableInTouchMode(false);
                    button_edit_carte_VA.setVisibility(View.VISIBLE);
                    button_register_carte_VA.setVisibility(View.GONE);
                    return true;
                }
                return false;
            }
        });

        return view;
    }



}
