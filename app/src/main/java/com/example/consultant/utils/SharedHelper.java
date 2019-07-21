package com.example.consultant.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SpringRain on 2018/12/25.
 */

public class SharedHelper {

        private Context mContext;

        public SharedHelper() {
        }

        public SharedHelper(Context mContext) {
            this.mContext = mContext;
        }


        //定义一个保存数据的方法
        public void saveUser(String username, String passwd, String avatar, String userId, String phone) {
            SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("nickname", username);
            editor.putString("phone", phone);
            editor.putString("password", passwd);
            editor.putString("avatar", avatar);
            editor.putString("userid", userId);
            editor.commit();
        }

        //定义一个读取SP文件的方法
        public Map<String, String> readUser() {
            Map<String, String> data = new HashMap<String, String>();
            SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
            data.put("nickname", sp.getString("nickname", ""));
            data.put("password", sp.getString("password", ""));
            data.put("userid", sp.getString("userid", ""));
            data.put("avatar", sp.getString("avatar", ""));
            data.put("phone", sp.getString("phone", ""));
            return data;
        }

        public void save(String key, String value){
            SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(key,value);
            editor.commit();
        }

        public String read(String key){
            SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
            return sp.getString(key,"");
        }
}
