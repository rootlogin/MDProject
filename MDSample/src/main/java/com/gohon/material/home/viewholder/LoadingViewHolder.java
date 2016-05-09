package com.gohon.material.home.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.gohon.material.R;

/**
 * Created by liuyonglong on 16/5/9.
 */
public class LoadingViewHolder extends RecyclerView.ViewHolder {
    public ProgressBar progressBar;

    public LoadingViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar) itemView.findViewById(R.id.recyclerview_loading_progressBar);
    }
}