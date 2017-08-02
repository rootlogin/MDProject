package com.mvp.contract;

/**
 * Created by liuyonglong on 2016/11/28.
 */

public abstract class BasePresenter implements BasePresenterInterface {
    public BasePresenterInterface getSuperInterface(){
        return this;
    }

}
