package com.gohon.material.home.viewholder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

import com.gohon.material.R;
import com.gohon.material.databinding.AdapterMessageBinding;
import com.gohon.material.home.events.OnRecyclerItemClickListener;

/**
 * Created by liuyonglong on 16/5/9.
 */
public class MessageViewHolder extends RecyclerView.ViewHolder {
    private AdapterMessageBinding adapterMessageBinding;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public AdapterMessageBinding getAdapterMessageBinding() {
        return adapterMessageBinding;
    }

    public void setAdapterMessageBinding(AdapterMessageBinding adapterMessageBinding) {
        this.adapterMessageBinding = adapterMessageBinding;
    }

    public MessageViewHolder(View itemView, final OnRecyclerItemClickListener onRecyclerItemClickListener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerItemClickListener.OnItemClickListener(adapterMessageBinding);
            }
        });
    }
}
