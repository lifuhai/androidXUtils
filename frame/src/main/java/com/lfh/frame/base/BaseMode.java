package com.lfh.frame.base;

import com.lfh.frame.callback.AppResponse;
import com.lfh.frame.callback.BaseCodeCall;
import com.lfh.frame.callback.JsonCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import java.util.Map;

public interface BaseMode {


    void  getNetData(String url, HttpParams params,ResponseListener responseListener);
    void  postNetData(String url);
    void  putNetData(String url);
    void  delNetData(String url);

    class  BaseModeIml implements  BaseMode{

        @Override
        public void getNetData(String url, HttpParams params , final ResponseListener listener)  {
            OkGo.<Object>get(url).params(params).execute(new JsonCallback<Object>() {
                @Override
                public void onSuccess(Response<Object> response) {
                    super.onSuccess(response);
                    listener.onSuccess(response);


                }

                @Override
                public void onError(Response<Object> response) {
                    super.onError(response);
                    listener.onFail(response.toString());
                }

            });
        }

        @Override
        public void postNetData(String url) {

        }

        @Override
        public void putNetData(String url) {

        }

        @Override
        public void delNetData(String url) {

        }
    }
}
