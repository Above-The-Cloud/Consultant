package com.example.consultant.data;

import android.util.Log;

import com.example.consultant.data.model.LoggedInUser;
import com.example.consultant.data.model.UserLgn;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    
    public Result<LoggedInUser> login(final String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
//            LoggedInUser fakeUser =
//                    new LoggedInUser(
//                            UUID.randomUUID().toString(),
//                            "Jane Doe");
            final LoggedInUser resUser = new LoggedInUser(UUID.randomUUID().toString(), "Jane Doe");
            //构造formbody
            OkHttpClient okHttpClient = new OkHttpClient();
            FormBody formBody = new FormBody.Builder().add("username", username)
                    .add("password", password).build();

            //构造request
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(ConstantUrl.UserLgn).post(formBody).build();

            //创建一个Call对象
            Call call = okHttpClient.newCall(request);

            //异步请求enqueue(Callback)
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("TAG", "登录失败=" + e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    Log.d("resjson", json);
                    UserLgn userLgn = new Gson().fromJson(json, UserLgn.class);
                    if(userLgn.getCode() == 0){
                        resUser.setUserId(userLgn.getData().getUser_id());
                        resUser.setDisplayName(userLgn.getData().getUsername());
                    }
                    else{
                        Log.d("Login","用户名或密码错误");
                    }

                }
            });
//            LoggedInUser logUser = new LoggedInUser();
            return new Result.Success<>(resUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }



}
