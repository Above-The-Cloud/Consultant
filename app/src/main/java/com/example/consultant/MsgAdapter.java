package com.example.consultant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
//7161315508
public class MsgAdapter extends ArrayAdapter<PostMessage> {
    private int resourceID;
    public MsgAdapter(Context context, int textViewResourceId, List<PostMessage> objects)
    {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        PostMessage msgRes = getItem(position);
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
        TextView txcontent = (TextView)view.findViewById(R.id.tv_postcontent);
        txcontent.setText(msgRes.getContent());
        return view;
    }
}
