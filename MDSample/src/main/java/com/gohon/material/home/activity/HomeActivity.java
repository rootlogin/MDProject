/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:6:57
 */

package com.gohon.material.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.gohon.material.R;
import com.gohon.material.home.adapter.ViewPagerAdapter;
import com.gohon.material.home.fragment.AboutFragment;
import com.gohon.material.home.fragment.ConstraintFragment;
import com.gohon.material.home.fragment.HomeFragment;
import com.gohon.material.home.fragment.MessageFragment;
import com.gohon.material.mduisdk.weight.progressBar.sample.GoogProgressBarSample;

/**
 * Created by liuyonglong on 16/4/12.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.home_viewpager);
        configrationViewPage(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.home_tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void configrationViewPage(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment(), "Home");
        viewPagerAdapter.addFragment(new MessageFragment(), "Message");
        viewPagerAdapter.addFragment(new AboutFragment(), "About");
        viewPagerAdapter.addFragment(new GoogProgressBarSample(), "Progress");
//        viewPagerAdapter.addFragment(new ConstraintFragment(), "Constraint");
        viewPager.setAdapter(viewPagerAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_toolbar:
                this.finish();
                break;
        }
    }
}
