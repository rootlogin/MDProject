package com.gohon.material.home.events;

import android.databinding.ViewDataBinding;

/**
 * Created by liuyonglong on 16/5/11.
 */
public interface OnRecyclerItemClickListener<T extends ViewDataBinding> {

    void OnItemClickListener(T t);
}
