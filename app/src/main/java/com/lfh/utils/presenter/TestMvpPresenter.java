package com.lfh.utils.presenter;

import com.lfh.frame.ToastMgr;
import com.lfh.frame.base.BasePresenter;
import com.lfh.frame.callback.JsonCallback;
import com.lfh.utils.Activity.MvpTestActivity;
import com.lfh.utils.mode.Test;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

public class TestMvpPresenter extends BasePresenter<MvpTestActivity> {

    public  void  onClick(String json){
//        ToastMgr.builder.display("1111111111111111111");
        view.showLoadingView();
        OkGo.<Test>post("xxxxxx")
                .tag(this)
                .upJson( json)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new JsonCallback<Test>() {
                    @Override
                    public void onSuccess(Response<Test> response) {
                        view.showDataView();
                    }

                    @Override
                    public void onCacheSuccess(Response<Test> response) {
                        super.onCacheSuccess(response);
                    }

                    @Override
                    public void onError(Response<Test> response) {
                        super.onError(response);

                        view.showErrorView();
                    }
                });
    }
}
