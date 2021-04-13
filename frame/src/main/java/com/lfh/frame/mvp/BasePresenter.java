package com.lfh.frame.mvp;

import com.lfh.frame.base.BaseView;

public interface BasePresenter<V extends BaseView, M extends BaseModel> {
    M createModel();

    void attachView(V view);

    void detachView();

    boolean isViewAttached();
}
