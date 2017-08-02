package com.mvp.contract;

/**
 * Created by liuyonglong on 2016/11/28.
 */

public class CustomPresenter extends BasePresenter {

    private final CustomContract.CustomViewInterface viewInterface;

    public CustomPresenter(CustomContract.CustomViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void doRequest() {
    }

    public void doHandle() {
        viewInterface.setName("Name");
    }
}
