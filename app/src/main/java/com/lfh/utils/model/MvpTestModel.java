package com.lfh.utils.model;


import com.lfh.frame.mvp.BaseModelImpl;
import com.lfh.utils.contract.MvpTestContract;
import com.lfh.utils.retrofit.RequestRetrofit;

/**
 * author : lfh
 * date   : 2021/4/1211:51
 * desc   :
 * version:
 */
public class MvpTestModel extends BaseModelImpl implements MvpTestContract.Model {
    @Override
    public void getTest(String s) {
        loadData(RequestRetrofit.getInstance().updateUMDeviceToken(null),null);
    }
}
