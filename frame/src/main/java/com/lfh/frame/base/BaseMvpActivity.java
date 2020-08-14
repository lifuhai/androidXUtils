package com.lfh.frame.base;

import android.os.Bundle;

import androidx.annotation.Nullable;


public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity  implements ResponseListener {
    public P mPresenter;

    public abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mPresenter = createPresenter();
        initLocalData();
    }



    @Override
    protected abstract int getContentViewId();
    protected abstract void initLocalData();


    @Override
    protected void initView() {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
            mPresenter = null;
            System.gc();
        }

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFail(String t) {

    }
}
