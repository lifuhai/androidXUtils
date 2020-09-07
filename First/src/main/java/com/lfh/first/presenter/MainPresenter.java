package com.lfh.first.presenter;

import com.lfh.first.TestActivity;
import com.lfh.first.contract.MainContract;
import com.lfh.frame.base.BasePresenter;
import com.lfh.frame.callback.JsonCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

public class MainPresenter extends BasePresenter<TestActivity> implements MainContract.Presenter {

    @Override
    public void getNetData(String s) {

        view.getNetDataSuccess(s+"成功但会");

        OkGo.<String>post("xxxx").execute(new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
            }
        });
    }
}
