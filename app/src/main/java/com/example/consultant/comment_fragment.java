package com.example.consultant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class comment_fragment extends Fragment {
    private List<PostMessage> msgList= new ArrayList<>();
    ImageButton ibn;
    Activity mActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.discover_page, container, false);

        return view;
    }
    public void setButtonFunction(){
        ibn = (ImageButton)getActivity().findViewById(R.id.edit_button);
        ibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "edit按钮被点击了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), EditActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mActivity = getActivity();
        setButtonFunction();
        initMessage();
        MsgAdapter adapter = new MsgAdapter(mActivity, R.layout.msg_item, msgList);
        ListView lv = (ListView)mActivity.findViewById(R.id.list_view_msg);
        lv.setAdapter(adapter);
    }
    private void initMessage(){
        for(int i = 0; i < 3; i++){
            Log.d("调试日志", i+"");
            PostMessage msg = new PostMessage("用户名", "2019-05-02 16:30", R.drawable.default_msg, "星期四");
            msgList.add(msg);
        }
    }
}