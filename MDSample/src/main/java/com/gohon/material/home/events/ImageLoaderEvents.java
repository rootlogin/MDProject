package com.gohon.material.home.events;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gohon.material.R;

/**
 * Created by liuyonglong on 16/5/11.
 */
public class ImageLoaderEvents {
    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.cardview_dark_background)
                .into(imageView);
    }

}
