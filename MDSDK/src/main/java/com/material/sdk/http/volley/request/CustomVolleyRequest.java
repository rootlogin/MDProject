/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:52:32
 */

package com.material.sdk.http.volley.request;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;

/**
 * Created by liuyonglong on 16/3/30.
 */
public class CustomVolleyRequest<T> extends AbsCustomVolleyRequest<T> {
    private Class<T> tClass;

    public CustomVolleyRequest(int method, String url, Class<T> tClass, Response.Listener<T> successlistener, Response.ErrorListener listener) {
        super(method, url, successlistener, listener);
        this.tClass = tClass;
    }

    @Override
    protected void deliverResponse(T response) {
        successlistener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonStr = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(jsonStr, tClass),HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }


}