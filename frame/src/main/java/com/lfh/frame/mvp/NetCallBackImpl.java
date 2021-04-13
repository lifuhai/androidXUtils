package com.lfh.frame.mvp;

import com.lfh.frame.base.BaseView;


/**
 * Created by majian on 2019/6/28.
 */

public abstract class NetCallBackImpl<T> implements NetCallBack<T> {

    private BaseView mView;

    public NetCallBackImpl(BaseView mView) {
        this.mView = mView;
    }

    private NetCallBackImpl() {
    }

    @Override
    public void onStart() {
    }



    @Override
    public void onCompleted() {
        if (mView == null) return;
        mView.showDataView();
    }




}
