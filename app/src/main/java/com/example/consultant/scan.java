package com.example.consultant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import android.widget.ListView;

public class scan extends AppCompatActivity {
    private List<Message> msgList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        initMessage();
        MsgAdapter adapter = new MsgAdapter(scan.this, R.layout.msg_item, msgList);
        ListView listview =(ListView)findViewById(R.id.list_ll);
        listview.setAdapter(adapter);
    }
    private void initMessage()
    {
        for (int i=0;i<=15;i++){
            Message msg = new Message("用户名", "时间", R.drawable.default_msg, "星期四");
            msgList.add(msg);}
    }
}
