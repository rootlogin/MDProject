package com.gohon.material.home.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.gohon.material.BR;
import com.gohon.material.R;
import com.gohon.material.databinding.AdapterHomeBinding;
import com.gohon.material.home.viewholder.HomeViewHolder;
import com.gohon.material.home.viewmodles.HomeModel;

import java.util.List;

/**
 * Created by liuyonglong on 16/4/13.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private List<HomeModel> homeModles;

    public HomeAdapter(List<HomeModel> homeModles) {
        this.homeModles = homeModles;
    }


    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterHomeBinding adapterMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_home, parent, false);
        HomeViewHolder userViewHolder = new HomeViewHolder(adapterMainBinding.getRoot());
        userViewHolder.setAdapterHomeBinding(adapterMainBinding);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        HomeModel homeModle = homeModles.get(position);
        holder.getAdapterHomeBinding().setVariable(BR.homeData, homeModle);
        holder.getAdapterHomeBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return homeModles.size();
    }

}
