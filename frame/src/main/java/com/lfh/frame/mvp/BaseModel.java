package com.lfh.frame.mvp;


import io.reactivex.Observable;

public interface BaseModel {
    void cancelTask();

    <T> void loadData(Observable<T> observable, final NetCallBack<T> callBack);

}
