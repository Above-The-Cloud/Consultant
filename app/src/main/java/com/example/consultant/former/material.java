package com.example.consultant.former;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.ArrayList;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;

import com.example.consultant.R;
import com.example.consultant.adapters.material_adapter;

public class material extends AppCompatActivity {
    private ImageView ibtn1=null;
    private List<materialitem> mtlist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        ibtn1=(ImageView)findViewById(R.id.add3);
        ibtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(material.this, material_add.class);
                startActivity(i);
            }
        });
        initalert();
        material_adapter adapter =new material_adapter(material.this,R.layout.material_item,mtlist);
        ListView listview =(ListView)findViewById(R.id.list_material);
        listview.setAdapter(adapter);
    }
    private void initalert()
    {
        for (int i=0;i<=15;i++){
            materialitem a = new materialitem("心理测验名字","简介","下载","详情 >");
            mtlist.add(a);}
    }
}
