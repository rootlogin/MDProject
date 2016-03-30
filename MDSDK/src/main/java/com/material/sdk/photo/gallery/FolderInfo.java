/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:1:26
 */

package com.material.sdk.photo.gallery;

import java.util.ArrayList;
import java.util.List;

/**
 * 图库信息
 * Created by liuyonglong on 16/2/25.
 */
public class FolderInfo {
    private String folderId;
    private String folderName;
    private PhotoInfo coverPhoto;
    private List<PhotoInfo> photoList = new ArrayList<>();

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public PhotoInfo getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(PhotoInfo coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public List<PhotoInfo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoInfo> photoList) {
        this.photoList = photoList;
    }
}
