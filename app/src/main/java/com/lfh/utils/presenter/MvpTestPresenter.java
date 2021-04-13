package com.lfh.utils.presenter;

import com.lfh.frame.mvp.BasePresenterImp;
import com.lfh.utils.contract.MvpTestContract;
import com.lfh.utils.model.MvpTestModel;

/**
 * author : lfh
 * date   : 2021/4/1211:51
 * desc   :
 * version:
 */
public class MvpTestPresenter  extends BasePresenterImp<MvpTestContract.View,MvpTestContract.Model> implements MvpTestContract.Presenter {
    @Override
    public MvpTestContract.Model createModel() {
        return  new MvpTestModel();
    }
}
