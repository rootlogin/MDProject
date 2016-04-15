package com.gohon.material.home.viewmodles;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.gohon.material.BR;

/**
 * Created by liuyonglong on 16/4/12.
 */
public class HomeModle extends BaseObservable{
    private String imageUrl;
    private String title;
    private String content;



    @Bindable
    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }


}
