package com.gohon.material.home.activity;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gohon.material.R;
import com.gohon.material.databinding.ActivityMessageDetailBinding;
import com.gohon.material.home.events.DetailPaletteEvents;
import com.gohon.material.home.viewmodles.MessageModel;

/**
 * Created by liuyonglong on 16/5/11.
 */
public class MessageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MessageModel messageModel = (MessageModel) getIntent().getExtras().getSerializable("messageModel");
        int colors = getIntent().getExtras().getInt("messageColors");
        DetailPaletteEvents detailPaletteEvents = new DetailPaletteEvents(colors);
        ActivityMessageDetailBinding activityMessageDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_message_detail);
        activityMessageDetailBinding.setMessageData(messageModel);
        activityMessageDetailBinding.setPaleteeEvents(detailPaletteEvents);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        setTheme();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
