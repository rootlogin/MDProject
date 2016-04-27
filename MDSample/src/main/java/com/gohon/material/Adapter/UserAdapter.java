/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:18:27
 */

package com.gohon.material.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.gohon.material.BR;
import com.gohon.material.pojo.User;
import com.gohon.material.R;
import com.gohon.material.databinding.AdapterMainBinding;
import java.util.List;

/**
 * Created by liuyonglong on 16/3/23.
 */
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> data;

    public UserAdapter(List<User> data) {
        this.data = data;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterMainBinding adapterMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_main, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(adapterMainBinding.getRoot());
        userViewHolder.setAdapterMainBinding(adapterMainBinding);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.getAdapterMainBinding().setVariable(BR.user, user);
        holder.getAdapterMainBinding().executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
