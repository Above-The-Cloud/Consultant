package com.example.consultant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.consultant.R;
import com.example.consultant.former.v2t2item;

import java.util.List;

public class v2t2_adapter extends ArrayAdapter<v2t2item> {
    private int resourceID;
    public v2t2_adapter(Context context, int textViewResourceId, List<v2t2item> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        v2t2item v2 = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView v2_file = (TextView)view.findViewById(R.id.v2_file);
        v2_file.setText(v2.getv2_file());
        TextView v2_date = (TextView)view.findViewById(R.id.v2_date);
        v2_date.setText(v2.getv2_date());
        TextView v2_time = (TextView)view.findViewById(R.id.v2_time);
        v2_date.setText(v2.getv2_time());
        return view;
    }
}
