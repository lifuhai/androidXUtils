package com.lfh.frame.mvp;

import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * @author lfh
 * @date 20121/03/26
 * @dec    网络请求baseMode  进一步封装
 */
public class BaseModelImpl implements BaseModel {


    private Disposable disposable;

    @Override
    public <T> void loadData(Observable<T> observable, final NetCallBack<T> callBack) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(T t) {
                        if (callBack != null) {
                            callBack.onSuccess(t);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null) {
                            callBack.onFailure(getException(e));
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (callBack != null) {
                            callBack.onCompleted();
                        }
                    }
                });
    }





    public static String getException(Throwable e) {
        String msg;
        if (e instanceof SocketTimeoutException) {
            msg = "网络不稳定，链接超时";
        } else if (e instanceof ConnectException) {
            msg = "网络不稳定,请稍后再试";
        } else if (e instanceof HttpException) {
            msg = "错误码" + ((HttpException) e).code() + " 请求失败";
        } else if (e instanceof UnknownHostException) {
            msg = "请保持网络通畅";
        } else if (e instanceof IllegalStateException) {
            msg = e.getMessage();
        } else if (e instanceof JsonSyntaxException) {
            msg = "数据解析出错";
        } else {
            msg = "接口请求失败";
        }
        e.printStackTrace();
        return msg;
    }

    @Override
    public void cancelTask() {
        if (disposable == null) return;
        disposable.dispose();
    }
}
