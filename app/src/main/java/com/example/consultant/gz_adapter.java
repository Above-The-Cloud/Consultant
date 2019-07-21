package com.example.consultant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class gz_adapter extends ArrayAdapter<gz_user> {
    private int resourceID;
    public gz_adapter(Context context, int textViewResourceId, List<gz_user> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        gz_user gz = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView gzuser = (TextView)view.findViewById(R.id.gzuser);
        gzuser.setText(gz.getUserName());
        TextView gzlts = (TextView)view.findViewById(R.id.gzlts);
        gzlts.setText(gz.getLatestMsg());
        return view;
    }
}
