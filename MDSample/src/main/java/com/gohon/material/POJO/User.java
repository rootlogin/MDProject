package com.gohon.material.POJO;

import android.annotation.TargetApi;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;

import com.gohon.material.BR;

import java.util.Objects;

/**
 * Created by liuyonglong on 16/3/22.
 */
public class User extends BaseObservable {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

//    @Bindable
//    public ObservableField<String> getText() {
//        return text;
//    }
//
//    public void setText(ObservableField<String> text) {
//        this.text = text;
//        notifyPropertyChanged(BR.text);
//    }

    //    private ObservableField<String> text = new ObservableField<>();
    @Bindable
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
        notifyPropertyChanged(BR.file);
    }

    private String file;


}
