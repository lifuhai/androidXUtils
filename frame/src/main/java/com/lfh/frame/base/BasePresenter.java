package com.lfh.frame.base;

public class BasePresenter<V> {

    protected V view;


    public BasePresenter(V view) {
        this.view = view;
    }


    protected V getView (){
        if (view != null) {
            return view;
        }

        return null;
    }

    /**
     * 当界面已经Destroy时调用
     */
    public void detach() {
        view = null;
        System.gc();
    }

}
