package com.material.sdk.network.download;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by liuyonglong on 16/8/24.
 */

public class DownloadService extends IntentService {

    public static final String DOWNLOAD_URL="downloadUrl";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DownloadService(String name) {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String downloadUrl = intent.getStringExtra(DOWNLOAD_URL);

        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

        Uri uri = Uri.parse(downloadUrl);

        DownloadManager.Request request = new DownloadManager.Request(uri);

        downloadManager.enqueue(request);
    }
}
