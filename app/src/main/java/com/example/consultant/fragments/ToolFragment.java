package com.example.consultant.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.consultant.R;
import com.example.consultant.activities.AcountActivity;
import com.example.consultant.former.alert;
import com.example.consultant.former.client;
import com.example.consultant.former.free;
import com.example.consultant.former.material;
import com.example.consultant.former.voice2text;

public class ToolFragment extends Fragment {
    private ImageView ibtn1=null;
    private ImageView ibtn2=null;
    private ImageView ibtn3=null;
    private ImageView ibtn4=null;
    private ImageView ibtn5=null;
    private ImageView ibtn6=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.tool_page, container, false);
        ibtn1=(ImageView)view.findViewById(R.id.img1);
        ibtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), free.class);
                startActivity(i);
            }
        });
        ibtn2=(ImageView)view.findViewById(R.id.img2);
        ibtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), voice2text.class);
                startActivity(i);
            }
        });
        ibtn3=(ImageView)view.findViewById(R.id.img3);
        ibtn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), alert.class);
                startActivity(i);
            }
        });
        ibtn4=(ImageView)view.findViewById(R.id.img4);
        ibtn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), client.class);
                startActivity(i);
            }
        });
        ibtn5=(ImageView)view.findViewById(R.id.img5);
        ibtn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), AcountActivity.class);
                startActivity(i);
            }
        });
        ibtn6=(ImageView)view.findViewById(R.id.img6);
        ibtn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), material.class);
                startActivity(i);
            }
        });
//        Button bt = (Button)view.findViewById(R.id.bt);
//        bt.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Toast.makeText(getActivity(), "Tool_fragment上的按钮被点击了", Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
