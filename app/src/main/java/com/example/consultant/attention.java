package com.example.consultant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import android.widget.ListView;

public class attention extends AppCompatActivity {
    private List<gz_user> gzlist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        initgz_user();
        gz_adapter adapter =new gz_adapter(attention.this,R.layout.gz_item,gzlist);
        ListView listview =(ListView)findViewById(R.id.list_gz);
        listview.setAdapter(adapter);
    }
    private void initgz_user()
    {
        for (int i=0;i<=15;i++){
            gz_user gzuser = new gz_user("用户名", "最新消息", R.drawable.default_msg);
        gzlist.add(gzuser);}
    }
}
