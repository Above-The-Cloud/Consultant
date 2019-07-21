package com.example.consultant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class alert_adapter extends ArrayAdapter<alertitem> {
    private int resourceID;
    public alert_adapter(Context context, int textViewResourceId, List<alertitem> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        alertitem ali = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView a = (TextView)view.findViewById(R.id.timeitem);
        a.setText(ali.getc_name());
        TextView b = (TextView)view.findViewById(R.id.t_a);
        b.setText(ali.gett_a());
        TextView c = (TextView)view.findViewById(R.id.prb);
        c.setText(ali.getprb());
        TextView d = (TextView)view.findViewById(R.id.reservation);
        d.setText(ali.getreservation());
        return view;
    }
}
