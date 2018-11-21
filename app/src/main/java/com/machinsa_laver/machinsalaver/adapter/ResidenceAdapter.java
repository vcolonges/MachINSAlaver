package com.machinsa_laver.machinsalaver.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.machinsa_laver.machinsalaver.R;
import com.machinsa_laver.machinsalaver.holder.HolderListResidence;
import com.machinsa_laver.machinsalaver.model.Residence;

import java.util.ArrayList;

public class ResidenceAdapter extends ArrayAdapter<Residence> implements View.OnClickListener{

    private ArrayList<Residence> dataSet;
    Context mContext;

    public ResidenceAdapter(ArrayList<Residence> data, Context context) {
        super(context, R.layout.home_row_machine, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Residence Machine =(Residence)object;

   /*     switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +Machine.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }*/
    }

    public Residence getItem(int position){
        return dataSet.get(position);
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Residence Residence = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        HolderListResidence viewHolder; // view lookup cache stored in tag
        convertView = null;
        View result = null;

        if (convertView == null) {

            viewHolder = new HolderListResidence();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.inscription_row_residence, parent, false);

            viewHolder.nomResidence = (TextView) convertView.findViewById(R.id.nom);

            convertView.setTag(viewHolder);

            result = convertView;
        } else {
            viewHolder = (HolderListResidence) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.nomResidence.setText(Residence.getNom());

        return result;
    }
}
