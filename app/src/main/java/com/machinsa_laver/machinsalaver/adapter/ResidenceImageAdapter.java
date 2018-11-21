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
import com.machinsa_laver.machinsalaver.holder.HolderListResidenceImages;
import com.machinsa_laver.machinsalaver.model.Residence;
import com.machinsa_laver.machinsalaver.model.ResidenceImage;

import java.util.ArrayList;

public class ResidenceImageAdapter extends ArrayAdapter<ResidenceImage> implements View.OnClickListener{

    private ArrayList<ResidenceImage> dataSet;
    Context mContext;

    public ResidenceImageAdapter(ArrayList<ResidenceImage> data, Context context) {
        super(context, R.layout.residences_row, data);
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

    public ResidenceImage getItem(int position){
        return dataSet.get(position);
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ResidenceImage ResidenceImage = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        HolderListResidenceImages viewHolder; // view lookup cache stored in tag
        convertView = null;
        View result = null;

        if (convertView == null) {

            viewHolder = new HolderListResidenceImages();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.residences_row, parent, false);

            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.logo = (ImageView) convertView.findViewById(R.id.logo);

            convertView.setTag(viewHolder);

            result = convertView;
        } else {
            viewHolder = (HolderListResidenceImages) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.nom.setText(ResidenceImage.getNom());

        if(ResidenceImage.getEstLaResidenceCourante()){

      //      viewHolder.logo.setBackgroundResource(R.drawable.star);
        }

        return result;
    }
}
