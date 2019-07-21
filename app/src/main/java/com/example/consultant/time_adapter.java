package com.example.consultant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class time_adapter extends ArrayAdapter<time> {
    private int resourceID;
    public time_adapter(Context context, int textViewResourceId, List<time> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        time t = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView timeitem = (TextView)view.findViewById(R.id.timeitem);
        timeitem.setText(t.getb_e());

        return view;
    }
}
