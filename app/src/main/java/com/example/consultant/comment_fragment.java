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

import com.example.consultant.utils.AsyncHttpUtils;
import com.example.consultant.utils.SharedHelper;
import com.example.consultant.utils.ToastUtils;
import com.example.consultant.utils.UrlConstants;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class comment_fragment extends Fragment {
    private List<PostMessage> msgList= new ArrayList<>();
    ImageButton ibn;
    Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.discover_page, container, false);
        RequestParams params = new RequestParams();
        AsyncHttpUtils.post(UrlConstants.disShow, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("Onfailure","fail: " + responseString);
                ToastUtils.showToast(getContext(), "fail: " + responseString, Toast.LENGTH_SHORT);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("success",  "success: " + responseString);
                JSONObject jsonRes = null;
                try{
                    jsonRes = new JSONObject(responseString);
                    if(jsonRes.getInt("code") == 0) {
//                        Toast.makeText(mcontext, "登录成功！", Toast.LENGTH_SHORT).show();
                        JSONArray datalist = jsonRes.getJSONObject("data").getJSONArray("discussion");
                        for(int i = 0; i < datalist.length(); i++)
                        {
                            JSONObject object = (JSONObject) datalist.get(i);
                            PostMessage msg = new PostMessage(object.getJSONObject("user_info").getString("username"), object.getString("mtime"), object.getString("content"), R.drawable.default_msg, "星期四");
                            msgList.add(msg);

                        }
                        MsgAdapter adapter = new MsgAdapter(mActivity, R.layout.msg_item, msgList);
                        ListView lv = (ListView)mActivity.findViewById(R.id.list_view_msg);
                        lv.setAdapter(adapter);

                    }
                    else{
                        ToastUtils.showToast(getContext(), jsonRes.getString("msg"), Toast.LENGTH_SHORT);
                    }
                }catch(JSONException e)
                {
                    e.printStackTrace();
                }

            }

        });
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
//        initMessage();

    }
    private void initMessage(){
        for(int i = 0; i < 3; i++){
            Log.d("调试日志", i+"");
            PostMessage msg = new PostMessage("用户名", "2019-05-02 16:30", "content",R.drawable.default_msg, "星期四");

            msgList.add(msg);
        }
    }
}