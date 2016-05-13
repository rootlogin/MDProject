package com.gohon.material.home.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.gohon.material.R;
import com.gohon.material.mduisdk.weight.progressBar.GoogleProgressBar;

/**
 * Created by liuyonglong on 16/5/9.
 */
public class LoadingViewHolder extends RecyclerView.ViewHolder {
    public GoogleProgressBar progressBar;

    public LoadingViewHolder(View itemView) {
        super(itemView);
        progressBar = (GoogleProgressBar) itemView.findViewById(R.id.recyclerview_loading_progressBar);
    }
}