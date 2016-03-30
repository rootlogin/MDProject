/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:59:21
 */

package com.material.sdk.photo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.material.sdk.photo.gallery.FolderInfo;
import com.material.sdk.photo.gallery.PhotoInfo;
import com.material.sdk.photo.gallery.PhotoLoader;

import java.util.List;


/**
 * Created by liuyonglong on 16/2/29.
 */
public class PhotoManager {
    private static PhotoManager instance;

    public static PhotoManager getInstance() {
        if (instance == null) {
            synchronized (PhotoManager.class) {//线程安全
                instance = new PhotoManager();
            }
        }
        return instance;
    }

    public static final int IMAGE = 1;//图片
    public static final int VEDIO = 2;//视频
    public static String MSG_CAMERA_FAIL = "相机不可用";//根据业务修改提示语句
    public static String MSG_SDCARD_FAIL = "SDCard不可用";//根据业务修改提示语句
    public static String MSG_MKDIRS_FAIL = "创建相册错误";//根据业务修改提示语句
    public static String cameraFolder = "QDFolder";


    @IntDef({IMAGE, VEDIO})//自定义约束类型
    public @interface CameraType {

    }

    /**
     * 图库
     *
     * @param context
     * @param galleryFolderNotify
     * @param filters
     */
    public void onLoaderPhoto(@Nullable Context context, GalleryFolderNotify galleryFolderNotify, String... filters) {
        PhotoLoader.getInstance().onLoader(context, galleryFolderNotify, filters);
    }

    /**
     * 系统图库
     *
     * @param context
     * @param galleryFolderNotify
     */
    public void onLoaderPhoto(@Nullable Context context, GalleryFolderNotify galleryFolderNotify) {
        PhotoLoader.getInstance().onLoader(context, galleryFolderNotify);
    }

    /**
     * 调用系统相机拍照
     *
     * @param activity
     * @param requestCode
     * @param cameraNotify
     * @return
     */
    public void onTakePhoto(Activity activity, int requestCode, CameraNotify cameraNotify) {
//        CameraUtils.getInstance(cameraNotify).takePhotos(activity, requestCode);
    }


    /**
     * 调用系统相机拍照
     *
     * @param activity
     * @param requestCode
     * @param cameraNotify
     * @param cameraType
     * @return
     */
    public void onTakePhoto(Activity activity, int requestCode, CameraNotify cameraNotify, @CameraType int cameraType) {
//        CameraUtils.getInstance(cameraNotify).takePhotos(activity, requestCode, cameraType);
    }

    /**
     * 拍照设置
     *
     * @param folderName  文件夹名称
     * @param cameraError 相机不可用错误信息
     * @param sdCardError SDCard不可用错误信息
     * @param fileError   文件夹错误信息
     * @return
     */
    public PhotoManager settingsCameraParams(@Nullable String folderName, String cameraError, String sdCardError, String fileError) {
        this.cameraFolder = folderName;
        this.MSG_CAMERA_FAIL = cameraError;
        this.MSG_SDCARD_FAIL = sdCardError;
        this.MSG_MKDIRS_FAIL = fileError;
        return instance;
    }


    public void onDestroy() {
//        if (CameraUtils.getCameraUtils() != null) {
//            CameraUtils.getCameraUtils().onDestroy();
//        }
        if (PhotoLoader.getInstance() != null) {
            PhotoLoader.getInstance().onDestroy();
        }

        this.instance = null;
    }

    public interface CameraNotify {

        void onLoading();

        void onSuccess(Uri uri);

        void onError(String msg);
    }


    public interface GalleryFolderNotify {

        void onLoading();

        void Folder(List<FolderInfo> folders);

        void Photoes(List<PhotoInfo> photoes);

        void onError();
    }

}
