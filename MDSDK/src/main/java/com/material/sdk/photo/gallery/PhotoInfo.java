/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:1:26
 */

package com.material.sdk.photo.gallery;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * 照片信息
 * Created by liuyonglong on 16/2/25.
 */
public class PhotoInfo implements Serializable{
    private int id;//图片id
    private String path;//原图路径
    private String name;//图片名称
    private String date;//日期
    private Bitmap thumbnails;//缩略图
    private String size;//照片大小
    private boolean isChecked = false;//是否被选中

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Bitmap getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Bitmap thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
