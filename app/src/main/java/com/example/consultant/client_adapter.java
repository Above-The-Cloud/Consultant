package com.example.consultant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class client_adapter extends ArrayAdapter<clientitem> {
    private int resourceID;
    public client_adapter(Context context, int textViewResourceId, List<clientitem> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        clientitem bli = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView aa = (TextView)view.findViewById(R.id.cname);
        aa.setText(bli.getcname());
        TextView bb = (TextView)view.findViewById(R.id.count);
        bb.setText(bli.getcount());
        TextView cc = (TextView)view.findViewById(R.id.sta);
        cc.setText(bli.getsta());

        return view;
    }
}
