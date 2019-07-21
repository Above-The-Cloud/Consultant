package com.example.consultant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
//7161315508
public class MsgAdapter extends ArrayAdapter<Message> {
    private int resourceID;
    public MsgAdapter(Context context, int textViewResourceId, List<Message> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Message msgRes = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
        }
        else
            view = convertView;
        TextView tvtitle = (TextView)view.findViewById(R.id.tv_title);
        tvtitle.setText(msgRes.getUserName());
        TextView tvartist = (TextView)view.findViewById(R.id.tv_artist);
        tvartist.setText(msgRes.getLatestMsg());
        return view;
    }
}
