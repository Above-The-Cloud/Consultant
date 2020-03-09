package com.example.consultant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;

import com.example.consultant.R;
import com.example.consultant.former.income;
import com.example.consultant.former.note_bill;

public class AcountActivity extends AppCompatActivity {
    private ImageView ibtn1=null;
    private ImageView ibtn2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount);
        ibtn1=(ImageView)findViewById(R.id.zd);
        ibtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(AcountActivity.this, income.class);
                startActivity(i);
            }
        });
        ibtn2=(ImageView)findViewById(R.id.bill);
        ibtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(AcountActivity.this, note_bill.class);
                startActivity(i);
            }
        });
    }
}
