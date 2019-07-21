package com.example.consultant.utils;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;


/**
 * Created by eminem on 2017/4/28.
 *
 */

public class AsyncHttpUtils {

    private static final String BASE_URL = UrlConstants.domain;

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, TextHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static String getAbsoluteUrl(String relativeUrl) {
        String res = BASE_URL + relativeUrl;
        Log.d("url", res);
        return res;
    }

}
