package com.gohon.material.plugsample;

import java.io.Serializable;

/**
 * Created by liuyonglong on 16/4/15.
 */
public class User implements Serializable{
    private String name;
    private String test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
