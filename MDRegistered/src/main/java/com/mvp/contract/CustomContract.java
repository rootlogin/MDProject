package com.mvp.contract;

/**
 * Mvp presenter 接口抽象
 * Created by liuyonglong on 2016/11/28.
 */

public interface CustomContract {
    /**
     * 通知UI
     */
     interface CustomViewInterface extends BaseViewInterface{
         void setName(String name);
     }

    /**
     * 业务处理
     */
    interface CustomPresenterInterface extends BasePresenterInterface{

    }
}
