package com.lfh.first.contract;

import com.lfh.frame.base.BaseView;
import com.lfh.frame.mvp.BaseModel;
import com.lfh.frame.mvp.BasePresenter;

/**
 * author : lfh
 * date   : 2021/4/1211:44
 * desc   :
 * version:
 */
public interface MainContract {
    interface Model  extends BaseModel {
    }

    interface View  extends BaseView {
    }

    interface Presenter  extends BasePresenter<View,Model> {
    }
}
