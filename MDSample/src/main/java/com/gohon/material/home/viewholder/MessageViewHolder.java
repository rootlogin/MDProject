package com.gohon.material.home.viewholder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

import com.gohon.material.databinding.AdapterMessageBinding;

/**
 * Created by liuyonglong on 16/5/9.
 */
public class MessageViewHolder extends RecyclerView.ViewHolder {
    private AdapterMessageBinding adapterMessageBinding;

    public AdapterMessageBinding getAdapterMessageBinding() {
        return adapterMessageBinding;
    }

    public void setAdapterMessageBinding(AdapterMessageBinding adapterMessageBinding) {
        this.adapterMessageBinding = adapterMessageBinding;
    }

    public MessageViewHolder(View itemView) {
        super(itemView);
    }
}
