package com.gohon.material.home.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gohon.material.R;
import com.gohon.material.databinding.FragmentHomeBinding;
import com.gohon.material.home.adapter.HomeAdapter;
import com.gohon.material.home.viewmodles.HomeModel;
import com.gohon.material.home.weight.RecyclerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyonglong on 16/4/12.
 */
public class HomeFragment extends Fragment{
    private static List<HomeModel> homeModles = new ArrayList<>();


    static {
        HomeModel homeModle = new HomeModel();
        homeModle.setImageUrl("");
        homeModle.setTitle("测试测试");
        homeModle.setTitle("Content");
        for (int i = 0;i<10;i++){
            homeModles.add(homeModle);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false);
        View rootView = fragmentHomeBinding.getRoot();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.framgent_home_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new RecyclerItemDecoration(16));
        HomeAdapter adapter = new HomeAdapter(homeModles);
        recyclerView.setAdapter(adapter);




        return fragmentHomeBinding.getRoot();
    }
}
