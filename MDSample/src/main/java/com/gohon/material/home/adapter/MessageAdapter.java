package com.gohon.material.home.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gohon.material.BR;
import com.gohon.material.R;
import com.gohon.material.databinding.AdapterMessageBinding;
import com.gohon.material.home.viewholder.LoadingViewHolder;
import com.gohon.material.home.viewholder.MessageViewHolder;
import com.gohon.material.home.viewmodles.MessageModel;
import java.util.List;

/**
 * Created by liuyonglong on 16/5/9.
 */
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private List<MessageModel> messageModelList;

    public MessageAdapter(List<MessageModel> messageModelList){
        this.messageModelList = messageModelList;
    }


    @Override
    public int getItemViewType(int position) {
        return messageModelList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            AdapterMessageBinding adapterMessageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_message, parent, false);
            MessageViewHolder messageViewHolder = new MessageViewHolder(adapterMessageBinding.getRoot());
            messageViewHolder.setAdapterMessageBinding(adapterMessageBinding);
            return messageViewHolder;

        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MessageViewHolder) {
            MessageModel messageModel = messageModelList.get(position);
            ((MessageViewHolder) holder).getAdapterMessageBinding().setVariable(BR.messageData, messageModel);
            ((MessageViewHolder) holder).getAdapterMessageBinding().executePendingBindings();
        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return messageModelList == null ? 0 : messageModelList.size();
    }
}
