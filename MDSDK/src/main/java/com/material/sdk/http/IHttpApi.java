/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:2:4
 */

package com.material.sdk.http;


import com.material.sdk.http.download.IDownloadApi;
import com.material.sdk.http.okhttp.IOkhttpApi;
import com.material.sdk.http.upload.IUploadApi;
import com.material.sdk.http.volley.IVolleyApi;

/**
 * Created by liuyonglong on 16/3/30.
 */
public interface IHttpApi {

    IVolleyApi getVolleyAPI();

    IOkhttpApi getOkhttpAPI();

    IDownloadApi getDownloadAPI();

    IUploadApi getUploadAPI();
}
