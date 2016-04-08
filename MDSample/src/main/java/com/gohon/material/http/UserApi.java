/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:0:28
 */

package com.gohon.material.http;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by liuyonglong on 16/4/5.
 */
public interface UserApi {

    @GET("userApi")
    Call<User> getUser();
}
