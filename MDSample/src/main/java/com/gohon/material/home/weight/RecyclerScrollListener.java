package com.gohon.material.home.weight;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by liuyonglong on 16/5/9.
 */
public class RecyclerScrollListener extends RecyclerView.OnScrollListener{

    private LinearLayoutManager linearLayoutManager;
    private RecyclerLoadMoreListener recyclerLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;


    public RecyclerScrollListener(LinearLayoutManager linearLayoutManager,RecyclerLoadMoreListener recyclerLoadMoreListener){
        this.linearLayoutManager = linearLayoutManager;
        this.recyclerLoadMoreListener = recyclerLoadMoreListener;
    }




    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        totalItemCount = linearLayoutManager.getItemCount();
        lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

        if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {

            if (recyclerLoadMoreListener != null) {
                recyclerLoadMoreListener.OnLoadMoreListener();
            }
            isLoading = true;
        }
    }

    public void setOnLoadMoreListener(RecyclerLoadMoreListener recyclerLoadMoreListener) {
        this.recyclerLoadMoreListener = recyclerLoadMoreListener;
    }

    public void setLoaded() {
        isLoading = false;
    }
}
