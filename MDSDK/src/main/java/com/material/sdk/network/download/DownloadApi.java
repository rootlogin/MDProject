package com.material.sdk.network.download;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.SyncStateContract;


/**
 * Created by liuyonglong on 16/8/24.
 */

public class DownloadApi {
    private DownloadManager downloadManager;
    private long downloadId;

    public DownloadApi(Context context, String downloadUrl) {
        downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        Uri uri = Uri.parse(downloadUrl);

        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);

        downloadId = downloadManager.enqueue(request);

    }

    private void downloadCompleteListener(Context context){
        IntentFilter completeFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);

        BroadcastReceiver completeReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                long referenceId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                if(downloadId == referenceId){

                }
            }
        };
        context.registerReceiver(completeReceiver,completeFilter);
    }



}
