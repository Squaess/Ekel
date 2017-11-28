package com.example.babar.ekel.MyListView;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babar.ekel.R;

import java.util.ArrayList;

/**
 * Created by silentnauscopy on 11/19/17
 */

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener {

    private Context mContext;
    private int lastPosition = -1;
    private int[] imageresources = {R.drawable.picture_test, R.drawable.a1,
            R.drawable.a2, R.drawable.picture_test, R.drawable.picture_test, R.drawable.picture_test,
            R.drawable.picture_test, R.drawable.picture_test, R.drawable.a8, R.drawable.picture_test,
            R.drawable.picture_test, R.drawable.picture_test, R.drawable.a12, R.drawable.picture_test,
            R.drawable.picture_test, R.drawable.picture_test, R.drawable.picture_test, R.drawable.picture_test,
            R.drawable.picture_test, R.drawable.picture_test, R.drawable.picture_test};

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();

        Object object = getItem(position);
        DataModel dataModel = (DataModel)object;
    }

    private static class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context){
        super(context, R.layout.custom_row, data);
        this.mContext = context;
    }


    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_row, parent, false);
            viewHolder.image = convertView.findViewById(R.id.imgIcon);
            viewHolder.name = convertView.findViewById(R.id.txtTitle);
            viewHolder.price = convertView.findViewById(R.id.txtPrice);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        assert dataModel != null;
        viewHolder.image.setImageResource(imageresources[dataModel.getMealId()]);
        viewHolder.name.setText(dataModel.getName());
        viewHolder.price.setText(dataModel.getPrice());
        if (dataModel.isAvailable()) {
            viewHolder.price.setTextColor(Color.GREEN);
        }else {
            viewHolder.price.setTextColor(Color.RED);
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
