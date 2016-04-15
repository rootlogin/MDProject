package com.gohon.material.home.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gohon.material.databinding.AdapterHomeBinding;

/**
 * Created by liuyonglong on 16/4/13.
 */
public class HomeViewHolder extends RecyclerView.ViewHolder{
    public AdapterHomeBinding getAdapterHomeBinding() {
        return adapterHomeBinding;
    }

    public void setAdapterHomeBinding(AdapterHomeBinding adapterHomeBinding) {
        this.adapterHomeBinding = adapterHomeBinding;
    }

    private AdapterHomeBinding adapterHomeBinding;

    public HomeViewHolder(View itemView) {
        super(itemView);
    }
}
