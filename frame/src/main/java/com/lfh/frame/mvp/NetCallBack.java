package com.lfh.frame.mvp;

/**
 *
 * Created by lfh
 */

public interface NetCallBack<T> {
    void onStart();
    void onSuccess(T t);
    void onFailure(String reason);
    void onCompleted();
}
