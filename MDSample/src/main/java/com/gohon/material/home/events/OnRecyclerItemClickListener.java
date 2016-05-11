package com.gohon.material.home.events;

import android.databinding.ViewDataBinding;
import android.widget.ImageView;

/**
 * Created by liuyonglong on 16/5/11.
 */
public interface OnRecyclerItemClickListener<T extends ViewDataBinding> {

    void OnItemClickListener(T t,ImageView imageView);
}
