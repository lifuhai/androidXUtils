package com.lfh.frame.base;

public interface BasePresenterImpl<V extends BaseView> {


    void attachView(V view);

    void detachView();

}
