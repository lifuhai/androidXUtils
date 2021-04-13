package com.lfh.utils.contract;

import com.lfh.frame.base.BaseView;
import com.lfh.frame.mvp.BaseModel;
import com.lfh.frame.mvp.BasePresenter;

/**
 * author : lfh
 * date   : 2021/4/1211:51
 * desc   :
 * version:
 */
public interface MvpTestContract {
    interface Model  extends BaseModel {
    }

    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View,Model> {
    }
}
