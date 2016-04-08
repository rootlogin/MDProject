/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:33:35
 */

package com.gohon.material.http;

import org.json.JSONStringer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by liuyonglong on 16/4/5.
 */
public interface TransportApi {

    @Headers("Content-type: application/json")
    @POST("api/hospital/list")
    Call<ResponseData> getData(@Body TransportParamsObject holder);
}
