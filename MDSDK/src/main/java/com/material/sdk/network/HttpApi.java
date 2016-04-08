/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:20:2
 */

package com.material.sdk.network;

import android.content.Context;

import com.material.sdk.network.download.IDownloadApi;
import com.material.sdk.network.upload.IUploadApi;

/**
 * Created by liuyonglong on 16/3/30.
 */
public class HttpApi implements IHttpApi{
    private static HttpApi instance;
    private static Context context;

    public void initHttpSettings(Context context) {
        HttpApi.context = context;
    }

    public static HttpApi getInstance() {
        synchronized (HttpApi.class) {
            if (instance == null) {
                instance = new HttpApi();
            }
        }
        return instance;
    }


//    @Override
//    public IVolleyApi getVolleyAPI() {
//        return new VolleyRequest(context);
//    }
//
//    @Override
//    public IOkhttpApi getOkhttpAPI() {
//        return null;
//    }

    @Override
    public IDownloadApi getDownloadAPI() {
        return null;
    }

    @Override
    public IUploadApi getUploadAPI() {
        return null;
    }


}
