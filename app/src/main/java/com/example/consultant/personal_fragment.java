package com.example.consultant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.consultant.utils.SharedHelper;

public class personal_fragment extends Fragment {
    private ImageButton ibtn1 = null;
    private ImageButton ibtn2 = null;
    private ImageButton ibtn3 = null;
    private ImageButton ibtn4 = null;
    private ImageView ibtnIcon = null;
    private TextView tx1 = null;
    private TextView tx2 = null;
    private TextView tx3 = null;
    private TextView tx4 = null;
    private TextView userName;

    @Nullable
    @Override
    public void onResume()
    {
        super.onResume();
        SharedHelper sh = new SharedHelper(getContext());
        try {
            String name = sh.read("nickname");
            if (name.length() > 0)
                userName.setText(name);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.personal_page, container, false);
        userName = (TextView)view.findViewById(R.id.userTextView);
        ibtnIcon = (ImageView)view.findViewById(R.id.userIconview);
        SharedHelper sh = new SharedHelper(getContext());
        try {
            String name = sh.read("nickname");
            if (name.length() > 0)
                userName.setText(name);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ibtnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginAndRegisterActivity.class);
                startActivity(i);
            }
        });
        ibtn1=(ImageButton)view.findViewById(R.id.imageView3);
        ibtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), attention.class);
                startActivity(i);
            }
        });
        ibtn2=(ImageButton)view.findViewById(R.id.imageView4);
        ibtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), collect.class);
                startActivity(i);
            }
        });
        ibtn3=(ImageButton)view.findViewById(R.id.imageView5);
        ibtn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), publish.class);
                startActivity(i);
            }
        });
        ibtn4=(ImageButton)view.findViewById(R.id.imageView6);
        ibtn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), scan.class);
                startActivity(i);
            }
        });
        tx1=(TextView)view.findViewById(R.id.textView6);
        tx1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), help.class);
                startActivity(i);
            }
        });
        tx2=(TextView)view.findViewById(R.id.textView9);
        tx2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), corporation.class);
                startActivity(i);
            }
        });
        tx3=(TextView)view.findViewById(R.id.textView10);
        tx3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), settings.class);
                startActivity(i);
            }
        });
        tx4=(TextView)view.findViewById(R.id.textView8);
        tx4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), advice.class);
                startActivity(i);
            }
        });
        return view;
}}