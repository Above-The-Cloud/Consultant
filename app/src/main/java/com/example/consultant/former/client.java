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
import com.example.consultant.adapters.client_adapter;

public class client extends AppCompatActivity {
    private ImageView ibtn1=null;
    private List<clientitem> cltlist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        ibtn1=(ImageView)findViewById(R.id.add2);
        ibtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(client.this, client_add.class);
                startActivity(i);
            }
        });
        initclient();
        client_adapter adapterc =new client_adapter(client.this,R.layout.client_item,cltlist);
        ListView listview =(ListView)findViewById(R.id.list_client);
        listview.setAdapter(adapterc);
    }
    private void initclient()
    {
        for (int i=0;i<=15;i++){
            clientitem clti = new clientitem("客户","咨询次数","客户情况");
            cltlist.add(clti);}
    }
}
