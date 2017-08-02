package com.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.mvp.contract.CustomContract;
import com.mvp.contract.CustomPresenter;
import com.registered.gohon.R;

/**
 * Created by liuyonglong on 2016/11/28.
 */

public class CustomActivity extends BaseActivity implements CustomContract.CustomViewInterface, View.OnClickListener {
    private CustomPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenter = new CustomPresenter(this);
        findViewById(R.id.doHandle).setOnClickListener(this);
        findViewById(R.id.showLoaindg).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.doHandle:
                presenter.doRequest();
                break;
            case R.id.showLoaindg:
                presenter.doHandle();
                break;
        }
    }

    @Override
    public void setName(String name) {

    }
}
