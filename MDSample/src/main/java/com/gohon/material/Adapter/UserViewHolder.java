/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:20:16
 */

package com.gohon.material.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gohon.material.databinding.AdapterMainBinding;

/**
 * Created by liuyonglong on 16/3/23.
 */
public class UserViewHolder extends RecyclerView.ViewHolder{
    private AdapterMainBinding adapterMainBinding;

    public AdapterMainBinding getAdapterMainBinding() {
        return adapterMainBinding;
    }

    public void setAdapterMainBinding(AdapterMainBinding adapterMainBinding) {
        this.adapterMainBinding = adapterMainBinding;
    }

    public UserViewHolder(View itemView) {
        super(itemView);
    }
}
