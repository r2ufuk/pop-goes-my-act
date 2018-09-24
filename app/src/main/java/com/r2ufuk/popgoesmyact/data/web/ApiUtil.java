package com.r2ufuk.popgoesmyact.data.web;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.r2ufuk.popgoesmyact.data.constants.Constant;
import com.r2ufuk.popgoesmyact.presentation.MyApplication;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class ApiUtil {

    private static final String baseUrl = Constant.base_url;
    private static final String apiKey = Constant.api_key;

    private String url;
    private String response;

    private ApiUtil(int pageNum) {
        this.url = buildApiUrl(pageNum);
    }

    public static ApiUtil getPageApi(int pageNum) {
        return new ApiUtil(pageNum);
    }

    private String buildApiUrl(int pageNum) {
        return baseUrl +
                "?" +
                "api_key=" +
                apiKey +
                "&" +
                "page=" +
                Integer.toString(pageNum);
    }

    private OkHttpClient buildClient() {
        return new OkHttpClient();
    }

    private Request buildRequest() {
        return new Request.Builder()
                .url(this.url)
                .build();
    }

    private void requestResponse() {

        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, this.url, future, future);
        RequestQueue requestQueue = newRequestQueue(MyApplication.getContext());
        requestQueue.add(stringRequest);
        Cache cache = requestQueue.getCache();
//        cache.clear();

        Cache.Entry cacheEntry;


        do  {
            cacheEntry = cache.get(this.url);
            SystemClock.sleep(200);
        } while(cacheEntry == null);

        String str;

        try {
            str = new String(cacheEntry.data, "UTF-8");
            this.response = str;
            Log.d("str", str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public String getResponse() {
        requestResponse();
        return response;
    }
}