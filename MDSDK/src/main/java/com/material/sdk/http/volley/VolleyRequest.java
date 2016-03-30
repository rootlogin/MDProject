/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:55:38
 */

package com.material.sdk.http.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by liuyonglong on 16/3/30.
 */
public class VolleyRequest implements IVolleyApi {
    private  RequestQueue requestQueue;

    public VolleyRequest(Context context) {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);
    }


    @Override
    public Object requestPost(IRequest request) {
        return this.requestQueue.add(request.onRequest()).getTag();
    }

    @Override
    public Object requestGet(IRequest request) {
        return this.requestQueue.add(request.onRequest()).getTag();
    }

    @Override
    public void cancelAll() {
        RequestQueue.RequestFilter requestFilter = new RequestQueue.RequestFilter(){

            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        };
        this.requestQueue.cancelAll(requestFilter);

    }

    @Override
    public void cancelByTag(Object tag) {
        this.requestQueue.cancelAll(tag);
    }

}
