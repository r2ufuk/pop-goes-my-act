package com.r2ufuk.popgoesmyact.data.web;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.r2ufuk.popgoesmyact.data.constants.Constant;
import com.r2ufuk.popgoesmyact.presentation.MyApplication;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class ApiUtil {

    private static final String baseUrl = Constant.base_url;
    private static final String apiKey = Constant.api_key;

    private RequestQueue requestQueue;

    private static final int PAGE_MAX = 100;

    private static final int WAIT_DURATION = 25; //in milliseconds

    public ApiUtil() {
        this.requestQueue = newRequestQueue(MyApplication.getContext());
    }

    private String buildUrl(int pageNum) {
        return baseUrl +
                "?" +
                "api_key=" +
                apiKey +
                "&" +
                "page=" +
                Integer.toString(pageNum);
    }

    private StringRequest buildRequest(int pageNum) {
        RequestFuture<String> future = RequestFuture.newFuture();
        String url = buildUrl(pageNum);
        int method = com.android.volley.Request.Method.GET;
        return new StringRequest(method, url, future, future);
    }

    private void addRequest(int pageNum) {
        this.requestQueue.add(buildRequest(pageNum));
    }

    private void addMultiRequests(int count) {
        for (int i = 1; i < count + 1; i++) {
            addRequest(i);
        }
    }

    @Nullable
    private Cache.Entry getFromCache(int pageNum) {
        Cache cache = this.requestQueue.getCache();
        return cache.get(buildUrl(pageNum));
    }

    private Cache.Entry waitForCacheEntry(int pageNum) {
        Cache.Entry cacheEntry;
        do {
            SystemClock.sleep(WAIT_DURATION);
            cacheEntry = getFromCache(pageNum);
        } while (cacheEntry == null);
        return cacheEntry;
    }

    private List<Cache.Entry> waitForMultiCacheEntry(int pageCount) {
        List<Cache.Entry> entryList = new ArrayList<>();
        for (int i = 1; i < pageCount + 1; i++) {
            entryList.add(waitForCacheEntry(i));
        }
        return entryList;
    }

    private String cachedDataToString(Cache.Entry cacheEntry) {
        String str = null;
        try {
            str = new String(cacheEntry.data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String requestResponse(int pageNum) {
        return cachedDataToString(waitForCacheEntry(pageNum));
    }

    private List<String> requestMultiResponse(int pageCount) {
        List<String> responseList = new ArrayList<>();
        for (int i = 0; i < pageCount + 1; i++) {
            responseList.add(cachedDataToString(waitForCacheEntry(i)));
        }
        return responseList;
    }

    public String getResponse(int pageNum, boolean cleanFlag) {
        if (cleanFlag) {
            this.requestQueue.getCache().clear();
            addMultiRequests(PAGE_MAX);
            return requestResponse(1);
        }
        return requestResponse(pageNum);
    }

    public List<String> getMultiResponse(int pageCount, boolean cleanFlag) {
        if (cleanFlag) {
            this.requestQueue.getCache().clear();
            addMultiRequests(PAGE_MAX);
        }
        return requestMultiResponse(pageCount);
    }

//    private searchName(){}
}