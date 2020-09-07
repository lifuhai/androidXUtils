package com.lfh.frame.base;

import android.content.Context;

public interface BaseView {
    void  showLoadingView();
    void  showDataView();
    void  showEmptyView(String empty);
    void  showErrorView(int  error);
    void  showErrorView();
}
