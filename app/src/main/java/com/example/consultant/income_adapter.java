package com.example.consultant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class income_adapter extends ArrayAdapter<incomeitem> {
    private int resourceID;
    public income_adapter(Context context, int textViewResourceId, List<incomeitem> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        incomeitem ali = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView a = (TextView)view.findViewById(R.id.psy_income);
        a.setText(ali.getpsy_income());
        TextView b = (TextView)view.findViewById(R.id.mode);
        b.setText(ali.getmode());
        TextView c = (TextView)view.findViewById(R.id.in_date);
        c.setText(ali.getin_date());
        TextView d = (TextView)view.findViewById(R.id.come);
        d.setText(ali.getcome());
        return view;
    }
}
