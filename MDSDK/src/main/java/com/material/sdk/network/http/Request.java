/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:10:31
 */

package com.material.sdk.network.http;


/**
 * Created by liuyonglong on 16/4/1.
 */
public abstract class Request {

    public abstract void doRequest(String url,String params,Response response);
}
