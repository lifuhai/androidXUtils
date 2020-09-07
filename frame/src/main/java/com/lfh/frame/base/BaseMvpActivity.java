package com.lfh.frame.base;

import android.os.Bundle;

import androidx.annotation.Nullable;


public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity  implements BaseView {
    public P mPresenter;

    public abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mPresenter = createPresenter();
        mPresenter.attachView(this);
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
            mPresenter.detachView();
            mPresenter = null;
            System.gc();
        }

    }


    @Override
    public void showDataView() {
        mVaryViewHelper.showDataView();
    }


    @Override
    public void showEmptyView(String empty) {
        mVaryViewHelper.showEmptyView(empty.toString());
    }

    @Override
    public void showErrorView(int error) {
        mVaryViewHelper.showErrorView(error);
    }

    @Override
    public void showErrorView() {
        mVaryViewHelper.showErrorView();
    }

    @Override
    public void showLoadingView() {
        mVaryViewHelper.showLoadingView();
    }
}
