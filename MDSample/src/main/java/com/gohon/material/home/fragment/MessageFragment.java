package com.gohon.material.home.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gohon.material.R;
import com.gohon.material.databinding.FragmentMessageBinding;
import com.gohon.material.home.adapter.MessageAdapter;
import com.gohon.material.home.viewmodles.MessageModel;
import com.gohon.material.home.weight.RecyclerLoadMoreListener;
import com.gohon.material.home.weight.RecyclerScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyonglong on 16/4/12.
 */
public class MessageFragment extends Fragment implements RecyclerLoadMoreListener {
    private static List<MessageModel> messageModels = new ArrayList<>();


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
        swipeRefreshLayout.setColorSchemeColors(R.color.red, R.color.green, R.color.blue, R.color.yellow);
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
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//        recyclerView.addItemDecoration(new RecyclerItemDecoration(16));
        adapter = new MessageAdapter(getContext(),messageModels);
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
            messageModel.setImageUrl("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%CD%BC%C6%AC&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=3802262475,1690125444&os=3380733997,1893062920&simid=8369824,691026290&pn=1&rn=1&di=54829995011&ln=1000&fr=&fmq=1462791723481_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=&istype=0&ist=&jit=&bdtype=15&gsm=0&objurl=http%3A%2F%2Fimage2.sina.com.cn%2Fgm%2Fdowngames%2Fpicture_src%2Fbizhi%2Fshenzhouol-375_6.jpg&rpstart=0&rpnum=0");
            messageModels.add(messageModel);
        }
    }
}
