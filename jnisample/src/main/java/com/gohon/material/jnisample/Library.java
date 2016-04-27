package com.gohon.material.jnisample;

/**
 * Created by liuyonglong on 16/4/25.
 */
public class Library {
    static {
        System.loadLibrary("jniLibrary");
    }

    public native int getNum();

    public native String getString();
}
