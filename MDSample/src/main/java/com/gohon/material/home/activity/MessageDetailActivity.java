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
import com.gohon.material.R;
import com.gohon.material.databinding.ActivityMessageDetailBinding;
import com.gohon.material.home.events.DetailPaletteEvents;
import com.gohon.material.home.viewmodles.MessageModel;
import com.gohon.material.mduisdk.weight.bottomBar.BottomBar;
import com.gohon.material.mduisdk.weight.bottomBar.OnMenuTabClickListener;
//import com.roughike.bottombar.BottomBar;
//import com.roughike.bottombar.BottomBarBadge;
//import com.roughike.bottombar.BottomBarTab;
//import com.roughike.bottombar.OnMenuTabClickListener;

/**
 * Created by liuyonglong on 16/5/11.
 */
public class MessageDetailActivity extends AppCompatActivity {
    private BottomBar mBottomBar;
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
//        mBottomBar.useDarkTheme();
//        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.menu_bottombar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId){
//                    case R.id.bottomBarRecents:
//                        break;
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                switch (menuItemId){
//                    case R.id.bottomBarRecents:
//                        break;
                }
            }
        });
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#7B1FA2");
//        mBottomBar.mapColorForTab(3, "#FF5252");
//        mBottomBar.mapColorForTab(4, "#FF9800");

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
