package com.mvp.contract;

/**
 * 抽象一些公用的UI相关操作
 * Created by liuyonglong on 2016/11/28.
 */

public interface BaseViewInterface {
    void showLoading();

    void dismissLoading();

    void showAlertDialog(String message);

    void dismissAlterDialog();

    void showErrorMessage(String message);

    void showEmptyView();

    void showErrorView();
}
