package com.lfh.frame.base;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.lfh.frame.mvp.BasePresenterImp;


/**
 * @author lfh
 * 加入绑定生命周期，防止MVP泄露
 * @data 2020/03/25
 */
public abstract class BaseMvpFragment<T extends BasePresenterImp> extends BaseFragment implements BaseView {

    protected T mPresenter;

    public abstract T createPresenter();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    protected void initData() {

    }

    @Override
    public Context getMContext() {
        return mContext;
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
