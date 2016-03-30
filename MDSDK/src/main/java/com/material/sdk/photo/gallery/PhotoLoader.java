/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:1:26
 */

package com.material.sdk.photo.gallery;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;

import com.material.sdk.photo.PhotoManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 系统相册
 * Created by liuyonglong on 16/2/25.
 */
public class PhotoLoader {


    private static PhotoLoader instance;

    private String filterPath = "/DCIM";

    private final String[] projectionPhotos = {
            MediaStore.Images.Media._ID, //照片ID
            MediaStore.Images.Media.BUCKET_ID,//相册ID
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,//相册名称
            MediaStore.Images.Media.PICASA_ID,
            MediaStore.Images.Media.DATA,//照片路径
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.TITLE,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.DATE_MODIFIED
    };

    public static PhotoLoader getInstance() {
        if (instance == null) {
            instance = new PhotoLoader();
        }
        return instance;
    }

    /**
     * 加载系统照片
     * 默认加载系统相册和QDFolder
     *
     * @param context
     * @param galleryFolderNotify
     */
    public void onLoader(@Nullable final Context context, final PhotoManager.GalleryFolderNotify galleryFolderNotify) {
        onLoader(context, galleryFolderNotify, filterPath, PhotoManager.cameraFolder);
    }

    /**
     * 加载系统照片
     *
     * @param context
     * @param galleryFolderNotify
     */
    public void onLoader(@Nullable final Context context, final PhotoManager.GalleryFolderNotify galleryFolderNotify, final String... filter) {
        final HashMap<String, FolderInfo> bucketMap = new HashMap<>();
        final List<FolderInfo> folderInfoList = new ArrayList<>();
        final List<PhotoInfo> photoInfos = new ArrayList<>();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                galleryFolderNotify.onLoading();
                ContentResolver mContentResolver = context.getContentResolver();

                Cursor cursor = mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        projectionPhotos, null, null, null);

                if (cursor == null) {
                    galleryFolderNotify.onError();
                    return;
                }

                if (cursor.moveToFirst()) {
                    do {
                        //照片ID
                        int _id = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                        //照片路径
                        String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                        //照片大小
                        String size = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE));
                        //照片名称
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                        //修改日期
                        String modifiedDate = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED));
                        //相册名
                        String bucketName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME));
                        //相册ID
                        String bucketId = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_ID));
                        if (onFilter(path, filter)) {//过滤照片信息
                            FolderInfo folderInfo = bucketMap.get(bucketId);
                            PhotoInfo photo = new PhotoInfo();
                            photo.setId(_id);
                            photo.setName(name);
                            photo.setPath(path);
                            photo.setDate(modifiedDate);
                            photo.setSize(size);

                            if (folderInfo == null) {// 如果不存在这个相册,保存ID、及相册名称
                                folderInfo = new FolderInfo();
                                folderInfo.setFolderName(bucketName);
                                folderInfo.setFolderId(bucketId);
                                //创建一个照片封面对象
                                folderInfo.setCoverPhoto(photo);
                                //将照片封面加入到相册中
                                folderInfo.getPhotoList().add(photo);
                                bucketMap.put(bucketId, folderInfo);
                            } else {// 如果存在,将相册相片数量
                                //将照片加入到相册中
                                folderInfo.getPhotoList().add(photo);
                            }
                            photoInfos.add(photo);
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
                galleryFolderNotify.Photoes(photoInfos);
                Iterator<Map.Entry<String, FolderInfo>> itr = bucketMap.entrySet()
                        .iterator();
                while (itr.hasNext()) {
                    Map.Entry<String, FolderInfo> entry = (Map.Entry<String, FolderInfo>) itr
                            .next();
                    folderInfoList.add(entry.getValue());
                }
                galleryFolderNotify.Folder(folderInfoList);
            }
        });
    }

    /**
     * 过滤器，根据绝对路径过滤
     *
     * @param path
     * @param filters
     * @return
     */
    private boolean onFilter(String path, String... filters) {
        if (filters == null) {//如果过滤数据为NULL，代表不过滤
            return true;
        }
        for (String filter : filters) {
//            Log.e("Filter","filter-->"+filter+"    是否包含-->"+path.contains(filter)+"    path-->"+path);
            if (path.contains(filter)) {
                return true;
            }
        }
        return false;
    }


    public void onDestroy(){
        instance = null;
    }
}
