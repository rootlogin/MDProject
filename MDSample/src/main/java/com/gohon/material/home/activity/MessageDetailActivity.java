package com.gohon.material.home.activity;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gohon.material.R;
import com.gohon.material.databinding.ActivityMessageDetailBinding;
import com.gohon.material.home.viewmodles.MessageModel;

/**
 * Created by liuyonglong on 16/5/11.
 */
public class MessageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_message_detail);
       MessageModel messageModel = (MessageModel) getIntent().getExtras().getSerializable("messageModel");
       ActivityMessageDetailBinding activityMessageDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_message_detail);
        activityMessageDetailBinding.setMessageData(messageModel);
    }

    private void test(){
        AppCompatImageView imageView = (AppCompatImageView) findViewById(R.id.image);
        String url = getIntent().getStringExtra("url");
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.cardview_dark_background)
                .into(imageView);

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP)
            imageView.setTransitionName(getString(R.string.message_share_image));}
}
