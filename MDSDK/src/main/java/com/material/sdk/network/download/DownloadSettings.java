package com.material.sdk.network.download;

import android.app.DownloadManager;
import android.net.Uri;

/**
 * Created by liuyonglong on 16/8/24.
 */

public class DownloadSettings {
    private  DownloadManager.Request request;

    public DownloadSettings(String downloadUrl){
        Uri uri = Uri.parse(downloadUrl);

        request = new DownloadManager.Request(uri);
    }

}
