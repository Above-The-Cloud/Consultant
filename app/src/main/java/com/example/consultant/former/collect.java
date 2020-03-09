package com.example.consultant.former;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import android.app.Activity;
import android.widget.ListView;

import com.example.consultant.R;
import com.example.consultant.adapters.MsgAdapter;

public class collect extends AppCompatActivity {
    private List<PostMessage> msgList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initMessage();
        Activity mActivity=collect.this;
        ListView lv = (ListView)mActivity.findViewById(R.id.list_sc);
        MsgAdapter adapter=new MsgAdapter(mActivity, msgList,lv);
        lv.setAdapter(adapter);

    }
    private void initMessage()
    {
        for (int i=0;i<=15;i++){
            PostMessage msg = new PostMessage("用户名", "时间", "content","2019-10");
            msgList.add(msg);}
    }
}
