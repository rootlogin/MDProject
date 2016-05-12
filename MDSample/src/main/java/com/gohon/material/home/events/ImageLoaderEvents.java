package com.gohon.material.home.events;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.gohon.material.R;

/**
 * Created by liuyonglong on 16/5/11.
 */
public class ImageLoaderEvents {
    private static int defaultColor = 0x000000;


    @BindingAdapter("bind:imageUrl")
    public static void loadImage(final ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.cardview_dark_background)
                .into(new SimpleTarget<Bitmap>() {

                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        imageView.setImageBitmap(resource);
                        Palette  palette =  Palette.from(resource).generate();
//                        int [] colors = {palette.getLightVibrantColor(defaultColor),palette.getLightMutedColor(defaultColor)};
                        imageView.setTag(palette.getLightVibrantColor(defaultColor));
                    }
                });
    }

}
