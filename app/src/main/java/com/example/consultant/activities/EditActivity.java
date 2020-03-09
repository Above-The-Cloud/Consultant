package com.example.consultant.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consultant.R;
import com.example.consultant.utils.AsyncHttpUtils;
import com.example.consultant.utils.SharedHelper;
import com.example.consultant.utils.ToastUtils;
import com.example.consultant.utils.Constants;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class EditActivity extends AppCompatActivity {
    private Map<String, String> userinfo;
    public static final int SUCCESS_OUT = 1;
    EditText editText;
    Context mcontext;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case SUCCESS_OUT:
                    finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mcontext = this;
        editText = (EditText)findViewById(R.id.post_text);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedHelper sh = new SharedHelper(getApplicationContext());
        userinfo = sh.readUser();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), userinfo.get("点击了发布"), Toast.LENGTH_SHORT).show();
                if(notNull())
                    postMessage(userinfo.get("userid"), editText.getText().toString());
            }
        });
    }
    private boolean notNull()
    {

        if(editText.getText().toString().length() < 1)
        {
            Toast.makeText(mcontext, "发布不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
    public void postMessage(String userid, String content)
    {

//        Log.d("post", userid + " " + content);
        RequestParams params = new RequestParams();
        params.put("user_id", userid);
        params.put("content", content);
        AsyncHttpUtils.post(Constants.disCreate, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                Log.d("Onfailure","fail: " + s);
                ToastUtils.showToast(mcontext, "fail: " + s, Toast.LENGTH_SHORT);
            }

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                Log.d("success",  "success: " + s);

                try{
                    JSONObject jsonRes = new JSONObject(s);
                    if(jsonRes.getInt("code") == 0)
                    {
                        Toast.makeText(mcontext, "发布成功！", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}