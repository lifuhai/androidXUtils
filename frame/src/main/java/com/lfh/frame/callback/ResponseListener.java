package com.lfh.frame.callback;


public interface ResponseListener<T> {
    void onSuccess(T t);

    void onFail(String t);
}