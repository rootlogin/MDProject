/*
 * Copyright (c) 2016.4.$today.day-$today.hour24:24:59
 */

package com.gohon.material.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gohon.material.R;

/**
 * Created by liuyonglong on 16/4/12.
 */
public class TabFragment2 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab,container,false);
    }
}
