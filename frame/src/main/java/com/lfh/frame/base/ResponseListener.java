package com.lfh.frame.base;


public interface ResponseListener<T> {
    void onSuccess(T t);

    void onFail(String t);
}