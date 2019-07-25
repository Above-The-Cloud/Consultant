package com.example.consultant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.ArrayList;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
public class income extends AppCompatActivity {

    private List<incomeitem> inlist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        initalert();
        income_adapter adapter =new income_adapter(income.this,R.layout.income_item,inlist);
        ListView listview =(ListView)findViewById(R.id.list_income);
        listview.setAdapter(adapter);
    }
    private void initalert()
    {
        for (int i=0;i<=15;i++){
            incomeitem a = new incomeitem("心理咨询收入","收款方式（支付宝、微信、现金）","2019.06.02","+0.00");
            inlist.add(a);}
    }
}
