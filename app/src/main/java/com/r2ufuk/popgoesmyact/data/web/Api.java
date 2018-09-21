package com.r2ufuk.popgoesmyact.data.web;

import com.r2ufuk.popgoesmyact.data.constants.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.Callable;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Api implements Callable<JSONObject> {

    private static final String baseUrl = Constant.base_url;
    private static final String apiKey = Constant.api_key;

    private String url;
    private JSONObject response;

    private Api(int pageNum) {
        this.url = buildApiUrl(pageNum);
    }

    public static Api getPageApi(int pageNum) {
        return new Api(pageNum);
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
                .get()
                .build();
    }

    private void requestResponse() {
        OkHttpClient client = buildClient();
        Request request = buildRequest();
        try {
            String resStr = client.newCall(request).execute().body().string();
            response = new JSONObject(resStr);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject getResponse() {
        requestResponse();
        return response;
    }

    @Override
    public JSONObject call() {
        return getResponse();
    }

}