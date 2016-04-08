/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:8:0
 */

package com.material.sdk.network.http;


/**
 * Created by liuyonglong on 16/4/1.
 */
public interface IActionApi {



    /**
     * 发送请求
     * @param request
     * @return
     */
    Object request(Request request);

    /**
     * 取消所有请求
     */
    void cancelAll();

    /**
     * 取消某个请求
     * @param tag
     */
    void cancelByTag(Object tag);

}
