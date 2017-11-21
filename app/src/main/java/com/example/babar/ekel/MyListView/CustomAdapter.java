package com.example.babar.ekel.MyListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.babar.ekel.R;

import java.util.ArrayList;

/**
 * Created by silentnauscopy on 11/19/17.
 */

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener {

    private ArrayList<DataModel> dataSet;
    Context mContext;
    private int lastPosition = -1;

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);
        DataModel dataModel = (DataModel)object;
    }

    private static class ViewHolder {
        TextView name;
        TextView price;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context){
        super(context, R.layout.custom_row, data);
        this.dataSet = data;
        this.mContext = context;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_row, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.txtTitle);
            viewHolder.price = (TextView) convertView.findViewById(R.id.txtPrice);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.name.setText(dataModel.getName());
        viewHolder.price.setText(dataModel.getPrice());

        // Return the completed view to render on screen
        return convertView;
    }
}
