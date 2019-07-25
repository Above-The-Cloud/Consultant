package com.example.consultant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.ImageView;
public class note_bill extends AppCompatActivity {
    private TextView txt_consult;
    private TextView txt_love;
    private ImageView img_consult;
    private ImageView img_love;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_bill);
        txt_consult=(TextView)findViewById(R.id.txt_consult);
        txt_consult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt_consult.setTextColor(Color.parseColor("#7D3FB5"));
                txt_love.setTextColor(Color.parseColor("#809E9E9E"));

            }
        });
        txt_love=(TextView)findViewById(R.id.txt_love);
        txt_love.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt_love.setTextColor(Color.parseColor("#7D3FB5"));
                txt_consult.setTextColor(Color.parseColor("#809E9E9E"));
            }
        });
        img_love=(ImageView)findViewById(R.id. img_love);
        img_love.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt_love.setTextColor(Color.parseColor("#7D3FB5"));
                txt_consult.setTextColor(Color.parseColor("#809E9E9E"));
            }
        });
        img_consult=(ImageView)findViewById(R.id. img_consult);
        img_consult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt_consult.setTextColor(Color.parseColor("#7D3FB5"));
                txt_love.setTextColor(Color.parseColor("#809E9E9E"));
            }
        });
    }
}
