package com.lfh.frame.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.lfh.frame.R;
import com.lfh.frame.preview.VaryViewHelper;


/**
 *   basefragment    抽象类
 */
public abstract class BaseFragment extends Fragment {

    public Context mContext;
    public VaryViewHelper mVaryViewHelper;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(this.getLayoutId(), container, false);
        mContext = getContext();
        initView(view);
        return view;
    }


    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    protected abstract void initData();


    public void hold( int id) {
        mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(view.findViewById(id))//放数据的父布局，逻辑处理在该Activity中处理
                .setLoadingView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_loadingview, null))//加载页，无实际逻辑处理
                .setEmptyView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_emptyview, null))//空页面，无实际逻辑处理
                .setErrorView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_errorview, null))//错误页面
                .build();
        mVaryViewHelper.mErrorView.findViewById(R.id.vv_error_refresh)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initData();
                    }
                });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
