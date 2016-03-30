/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:54:13
 */

package com.material.sdk.http.volley;

import com.android.volley.Request;

/**
 * 对Volley的基础操作
 * Created by liuyonglong on 16/3/30.
 */
public interface IVolleyApi {

    Object requestPost(IRequest request);

    Object requestGet(IRequest request);

    void cancelAll();

    void cancelByTag(Object tag);


    interface IRequest<T> {
        Request<T> onRequest();
    }
}
