/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:0:54
 */

package com.gohon.material.http;

/**
 * Created by liuyonglong on 16/4/5.
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
