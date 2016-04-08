/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:48:50
 */

package com.gohon.material.http;




/**
 * Created by liuyonglong on 16/3/31.
 */
public class PostJsonRequest<T> {
    private static PostJsonRequest instance;

    public static PostJsonRequest getInstance(){
        if(instance == null){
            synchronized (PostJsonRequest.class){
                instance = new PostJsonRequest();
            }
        }
        return instance;
    }






}
