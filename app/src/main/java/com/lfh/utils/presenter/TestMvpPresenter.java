package com.lfh.utils.presenter;

import com.lfh.frame.ToastMgr;
import com.lfh.frame.base.BasePresenter;
import com.lfh.frame.callback.JsonCallback;
import com.lfh.utils.Activity.MvpTestActivity;
import com.lfh.utils.mode.Test;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

public class TestMvpPresenter extends BasePresenter<MvpTestActivity> {
    public TestMvpPresenter(MvpTestActivity view) {
        super(view);
    }

    public  void  onClick(String json){
        ToastMgr.builder.display("1111111111111111111");

        view.mVaryViewHelper.showLoadingView();
        OkGo.<Test>post("xxxxxx")
                .tag(this)
                .upJson( json)
                .execute(new JsonCallback<Test>() {
                    @Override
                    public void onSuccess(Response<Test> response) {
                        view.mVaryViewHelper.showDataView();
                        view.onSuccess(response.body().toString());

                    }

                    @Override
                    public void onError(Response<Test> response) {
                    view.mVaryViewHelper.showErrorView();

                    }
                });
    }
}
