package com.mvp;

import android.support.v7.app.AppCompatActivity;
import com.mvp.contract.BaseViewInterface;

/**
 * Created by liuyonglong on 2016/11/28.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseViewInterface {

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showAlertDialog(String message) {

    }

    @Override
    public void dismissAlterDialog() {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView() {

    }
}
