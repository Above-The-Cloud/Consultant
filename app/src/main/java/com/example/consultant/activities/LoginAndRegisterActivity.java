package com.example.consultant.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consultant.R;
import com.example.consultant.utils.AsyncHttpUtils;
import com.example.consultant.utils.SharedHelper;
import com.example.consultant.utils.ToastUtils;
import com.example.consultant.utils.Constants;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class LoginAndRegisterActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText username;
    private EditText password;
    Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);
        mcontext = this;
        loginButton = (Button)findViewById(R.id.lgnButton);
        username = (EditText)findViewById(R.id.lgnUsername);
        password = (EditText)findViewById(R.id.lgnPassword);
        loginButton.setBackgroundColor(Color.parseColor("#f76968"));
        loginButton.setTextColor(Color.parseColor("#ffffff"));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check())
                {
                    login(username.getText().toString(), password.getText().toString());
                }
            }
        });
    }
    private boolean check()
    {
        if(username.getText().toString().length() < 1 || password.getText().toString().length() < 1)
        {
            Toast.makeText(mcontext, "用户名获密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
    private void login(String lgnid, String pwd)
    {
        RequestParams params = new RequestParams();
        params.put("username", lgnid);
        params.put("password", pwd);
        AsyncHttpUtils.post(Constants.UserLgn, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("Onfailure","fail: " + responseString);
                ToastUtils.showToast(mcontext, "fail: " + responseString, Toast.LENGTH_SHORT);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("success",  "success: " + responseString);
                JSONObject jsonRes = null;
                try{
                    jsonRes = new JSONObject(responseString);
                    if(jsonRes.getInt("code") == 0) {
//                        Toast.makeText(mcontext, "登录成功！", Toast.LENGTH_SHORT).show();
                        JSONObject data = jsonRes.getJSONObject("data");
                        SharedHelper sh = new SharedHelper(mcontext);
                        sh.saveUser(data.getString("username"), "password", data.getString("avatar"), data.getString("user_id"), data.getString("phone"));
                        ToastUtils.showToast(mcontext, "登录成功！ 欢迎 "+data.getString("username"), Toast.LENGTH_SHORT);
                        Intent i = new Intent(LoginAndRegisterActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                    else{
                        ToastUtils.showToast(mcontext, jsonRes.getString("msg"), Toast.LENGTH_SHORT);
                    }
                }catch(JSONException e)
                {
                    e.printStackTrace();
                }

            }

        });
    }
}

