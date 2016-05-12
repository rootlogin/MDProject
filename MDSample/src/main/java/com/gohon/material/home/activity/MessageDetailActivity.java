package com.gohon.material.home.activity;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.load.engine.Resource;
import com.gohon.material.R;
import com.gohon.material.databinding.ActivityMessageDetailBinding;
import com.gohon.material.home.events.DetailPaletteEvents;
import com.gohon.material.home.viewmodles.MessageModel;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnMenuTabClickListener;

/**
 * Created by liuyonglong on 16/5/11.
 */
public class MessageDetailActivity extends AppCompatActivity {
    private BottomBar  mBottomBar;
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




        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.coordinatorLayout),
                findViewById(R.id.nestedScorellView), savedInstanceState);
        mBottomBar.useDarkTheme();
        mBottomBar.setItemsFromMenu(R.menu.menu_bottombar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId){
                    case R.id.bottomBarRecents:
                        break;
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                switch (menuItemId){
                    case R.id.bottomBarRecents:
                        break;
                }
            }
        });

//        mBottomBar.setItems(
//                new BottomBarTab(R.drawable.ic_recents, "Recents"),
//                new BottomBarTab(R.drawable.ic_favorites, "Favorites"),
//                new BottomBarTab(R.drawable.ic_nearby, "Nearby")
//        );

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }
}
