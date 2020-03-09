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
import com.example.consultant.adapters.alert_adapter;

public class alert extends AppCompatActivity {
    private ImageView ibtn1=null;
    private List<alertitem> altlist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        ibtn1=(ImageView)findViewById(R.id.add1);
        ibtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(alert.this, alert_add.class);
                startActivity(i);
            }
        });
        initalert();
        alert_adapter adapter =new alert_adapter(alert.this,R.layout.alert_item,altlist);
        ListView listview =(ListView)findViewById(R.id.list_alert);
        listview.setAdapter(adapter);
    }
    private void initalert()
    {
        for (int i=0;i<=15;i++){
            alertitem a = new alertitem("客户","时间 地点","待解问题","预约");
            altlist.add(a);}
    }
}
