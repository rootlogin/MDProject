package com.gohon.material.home.viewmodles;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.gohon.material.BR;

/**
 * Message Observable Model
 * Created by liuyonglong on 16/5/9.
 */
public class MessageModel extends BaseObservable {

    private String title;
    private String description;
    private String image;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }




}

