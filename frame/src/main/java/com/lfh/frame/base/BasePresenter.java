package com.lfh.frame.base;

public class BasePresenter<V extends BaseView> implements BasePresenterImpl<V>{

    public V view;


    @Override
    public void attachView(V view) {
        this.view= view;
    }

    @Override
    public void detachView() {
        view = null;
        System.gc();
    }
}
