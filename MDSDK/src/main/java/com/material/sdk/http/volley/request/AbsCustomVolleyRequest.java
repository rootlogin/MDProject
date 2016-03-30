/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:51:50
 */

package com.material.sdk.http.volley.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;

/**
 * Created by liuyonglong on 16/3/30.
 */
public abstract class AbsCustomVolleyRequest<T> extends Request<T> {
    protected Response.Listener<T> successlistener;
    protected Gson gson = new Gson();

    public AbsCustomVolleyRequest(int method, String url,Response.Listener<T> successlistener, Response.ErrorListener listener) {
        super(method, url, listener);
        this.successlistener = successlistener;
        setTag(this);
    }
}
