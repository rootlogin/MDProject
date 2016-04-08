/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:54:16
 */

package com.material.sdk.api;

import android.content.Context;

import com.material.sdk.cache.CacheApi;
import com.material.sdk.network.HttpApi;

/**
 * Created by liuyonglong on 16/3/30.
 */
public class SDKManager {
    private String cachePath = "sdkCache";//缓存路径
    private String httpCachePath;//网络请求缓存路径;
    private String downloadPath;//文件下载路径;
    private String photoPath;//拍照,裁剪,旋转路径

    public String getCachePath() {
        return cachePath;
    }

    public void setCachePath(String cachePath) {
        this.cachePath = cachePath;
    }

    public String getHttpCachePath() {
        return httpCachePath;
    }

    public void setHttpCachePath(String httpCachePath) {
        this.httpCachePath = httpCachePath;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }


    /**
     * 初始化缓存API
     * @param context
     * @param cachePath
     */
    public void onCreateCacheApi(Context context,String cachePath){
        new CacheApi(context,cachePath);
    }

    /**
     * 初始化网络API
     * @param context
     * @param cachePath
     */
    public void onCreateHttpApi(Context context,String cachePath){
        new HttpApi().initHttpSettings(context);
    }

    /**
     * 初始化SDK所有API
     * @param context
     */
    public void onCreateAllApi(Context context){
        new CacheApi(context,cachePath);
        new HttpApi().initHttpSettings(context);
    }

}
