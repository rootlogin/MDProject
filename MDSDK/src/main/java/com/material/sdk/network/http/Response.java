/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:11:27
 */

package com.material.sdk.network.http;


/**
 * Created by liuyonglong on 16/4/1.
 */
public interface Response {
    void onSuccess(String data);

    void onError(HttpError e);
}
