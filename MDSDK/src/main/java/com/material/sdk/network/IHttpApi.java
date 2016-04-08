/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:2:4
 */

package com.material.sdk.network;


import com.material.sdk.network.download.IDownloadApi;
import com.material.sdk.network.upload.IUploadApi;

/**
 * Created by liuyonglong on 16/3/30.
 */
public interface IHttpApi {

//    IVolleyApi getVolleyAPI();
//
//    IOkhttpApi getOkhttpAPI();

    IDownloadApi getDownloadAPI();

    IUploadApi getUploadAPI();
}
