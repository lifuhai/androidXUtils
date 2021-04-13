package com.lfh.first.presenter;

import com.lfh.first.contract.MainContract;
import com.lfh.first.model.MainModel;
import com.lfh.frame.mvp.BasePresenterImp;

/**
 * author : lfh
 * date   : 2021/4/1211:44
 * desc   :
 * version:
 */
public class MainPresenter  extends BasePresenterImp<MainContract.View,MainContract.Model> implements MainContract.Presenter {
    @Override
    public MainContract.Model createModel() {
        return new MainModel();

    }
}
