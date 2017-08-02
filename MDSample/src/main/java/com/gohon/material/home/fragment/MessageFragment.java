package com.gohon.material.home.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gohon.material.R;
import com.gohon.material.databinding.AdapterMessageBinding;
import com.gohon.material.databinding.FragmentMessageBinding;
import com.gohon.material.home.activity.MessageDetailActivity;
import com.gohon.material.home.adapter.MessageAdapter;
import com.gohon.material.home.events.OnRecyclerItemClickListener;
import com.gohon.material.home.viewmodles.MessageModel;
import com.gohon.material.home.weight.RecyclerLoadMoreListener;
import com.gohon.material.home.weight.RecyclerScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liuyonglong on 16/4/12.
 */
public class MessageFragment extends Fragment implements RecyclerLoadMoreListener, OnRecyclerItemClickListener<AdapterMessageBinding> {
    private static List<MessageModel> messageModels = new ArrayList<>();
    private static String[] images = {
            "http://img3.imgtn.bdimg.com/it/u=3341132500,2418063783&fm=21&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=4109452979,1965980364&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=601112546,3540523200&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=2435348325,2231714470&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1195360544,2070832117&fm=21&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3809537034,946373921&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3260262073,2475898601&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2734491231,2030235915&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=2937776643,2665535896&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=4109440727,2516303024&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=3606033953,4244886874&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2525072264,1004952987&fm=21&gp=0.jpg"
    };


    static {
        loadData(0, 10);
    }

    private RecyclerScrollListener recyclerScrollListener;
    private MessageAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMessageBinding fragmentMessageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false);
        View rooView = fragmentMessageBinding.getRoot();
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) rooView.findViewById(R.id.framgent_message_swipeRefresh);
        setSwipeSchemeColors(swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        messageModels.clear();
                        loadData(0, 10);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        RecyclerView recyclerView = (RecyclerView) rooView.findViewById(R.id.framgent_message_recycler);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setMoveDuration(1000);
        defaultItemAnimator.setSupportsChangeAnimations(true);
        recyclerView.setItemAnimator(defaultItemAnimator);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//        recyclerView.addItemDecoration(new RecyclerItemDecoration(16));
        adapter = new MessageAdapter(getContext(), messageModels);
        adapter.setOnRecyclerItemClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerScrollListener = new RecyclerScrollListener(linearLayoutManager, this);
        recyclerView.addOnScrollListener(recyclerScrollListener);

        return rooView;
    }


    @Override
    public void OnLoadMoreListener() {
        messageModels.add(null);
        adapter.notifyItemInserted(messageModels.size() - 1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                messageModels.remove(messageModels.size() - 1);
                adapter.notifyItemRemoved(messageModels.size());
                int index = messageModels.size();
                int total = index + 10;
                loadData(index, total);
                adapter.notifyDataSetChanged();
                recyclerScrollListener.setLoaded();
            }
        }, 5000);
    }


    private static void loadData(int index, int total) {
        for (int i = index; i < total; i++) {
            MessageModel messageModel = new MessageModel();
            messageModel.setDescription("测试描述" + i);
            messageModel.setTitle("测试标题" + i);
            messageModel.setImage(images[new Random().nextInt(images.length - 1)]);
            messageModels.add(messageModel);
        }
    }

    /**
     * 设置swipeRefreshLayout样式
     *
     * @param swipeRefreshLayout
     */
    private void setSwipeSchemeColors(SwipeRefreshLayout swipeRefreshLayout) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Resources.Theme theme = getActivity().getTheme();
            int[] colors = {
                    getResources().getColor(R.color.red, theme),
                    getResources().getColor(R.color.green, theme),
                    getResources().getColor(R.color.blue, theme),
                    getResources().getColor(R.color.yellow, theme)
            };
            swipeRefreshLayout.setColorSchemeColors(colors);
        } else {
            int[] colors = {
                    getResources().getColor(R.color.red),
                    getResources().getColor(R.color.green),
                    getResources().getColor(R.color.blue),
                    getResources().getColor(R.color.yellow)
            };
            swipeRefreshLayout.setColorSchemeColors(colors);
        }
    }


    @Override
    public void OnItemClickListener(AdapterMessageBinding adapterMessageBinding) {

//        MessageModel messageModel = adapterMessageBinding.getMessageData();
////        messageModel.
//
//
//        Bitmap bitmap = ((BitmapDrawable)adapterMessageBinding.adapterMessageImage.getDrawable()).getBitmap();
//        messageModel.setBitmap(bitmap);

        Intent intent = new Intent(getActivity(), MessageDetailActivity.class);
        intent.putExtra("messageModel", adapterMessageBinding.getMessageData());
        intent.putExtra("messageColors", (int) adapterMessageBinding.adapterMessageImage.getTag());
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent);
        } else {
            Pair<View, String> titlePair = new Pair<View, String>(adapterMessageBinding.adapterMessageTitle, getString(R.string.message_share_title));
            Pair<View, String> imagePair = new Pair<View, String>(adapterMessageBinding.adapterMessageImage, getString(R.string.message_share_image));
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(getActivity(), titlePair, imagePair);
            startActivity(intent, options.toBundle());
        }
    }
}
