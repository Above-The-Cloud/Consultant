package com.example.consultant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.consultant.R;
import com.example.consultant.former.materialitem;

import java.util.List;

public class material_adapter extends ArrayAdapter<materialitem> {
    private int resourceID;
    public material_adapter(Context context, int textViewResourceId, List<materialitem> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        materialitem ali = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView a = (TextView)view.findViewById(R.id.mt_name);
        a.setText(ali.getmt_name());
        TextView b = (TextView)view.findViewById(R.id.introduce);
        b.setText(ali.getintroduce());
        TextView c = (TextView)view.findViewById(R.id.dld);
        c.setText(ali.getdld());
        TextView d = (TextView)view.findViewById(R.id.mt_detail);
        d.setText(ali.getmt_detail());
        return view;
    }
}
