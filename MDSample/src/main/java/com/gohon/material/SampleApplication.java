/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:3:52
 */

package com.gohon.material;

import android.app.Application;
import com.material.sdk.api.SDKManager;

/**
 * Created by liuyonglong on 16/3/30.
 */
public class SampleApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SDKManager sdkManager = new SDKManager();
        sdkManager.onCreateAllApi(this);
    }
}
