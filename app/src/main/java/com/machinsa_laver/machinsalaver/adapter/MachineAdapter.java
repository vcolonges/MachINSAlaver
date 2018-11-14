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
import com.machinsa_laver.machinsalaver.holder.HolderListMachine;
import com.machinsa_laver.machinsalaver.model.Machine;

import java.util.ArrayList;

public class MachineAdapter extends ArrayAdapter<Machine> implements View.OnClickListener{

    private ArrayList<Machine> dataSet;
    Context mContext;

    public MachineAdapter(ArrayList<Machine> data, Context context) {
        super(context, R.layout.home_row_machine, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Machine Machine =(Machine)object;

   /*     switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +Machine.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }*/
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Machine Machine = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        HolderListMachine viewHolder; // view lookup cache stored in tag

        View result = null;

        if (convertView == null) {

            viewHolder = new HolderListMachine();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.home_row_machine, parent, false);

            viewHolder.num = (TextView) convertView.findViewById(R.id.num);
            viewHolder.etat = (TextView) convertView.findViewById(R.id.etat);
            viewHolder.temps = (TextView) convertView.findViewById(R.id.temps);
            viewHolder.logoMachine = (ImageView) convertView.findViewById(R.id.logo);

            convertView.setTag(viewHolder);

            convertView.setBackgroundColor(Color.parseColor("#CFCFCF"));

            if(Machine.getEtat().equals("Disponible")){
                convertView.setBackgroundColor(Color.parseColor("#B6E4A8"));
            }
            if(Machine.getEtat().equals("Occupée")){
                convertView.setBackgroundColor(Color.parseColor("#F9D69C"));
            }

            result = convertView;
        } else {
            viewHolder = (HolderListMachine) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.num.setText(Machine.getNum());
        viewHolder.etat.setText(Machine.getEtat());
        viewHolder.temps.setText(Machine.getTemps());
        viewHolder.logoMachine.setBackgroundResource(R.drawable.washer);
        viewHolder.logoMachine.setTag(position);

        return convertView;
    }
}
