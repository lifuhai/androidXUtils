package com.lfh.frame.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.lfh.frame.mvp.BasePresenterImp;


public abstract class BaseMvpActivity<P extends BasePresenterImp> extends BaseActivity implements BaseView {
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
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
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


    @Override
    public Context getMContext() {
        return mContext;
    }

}
