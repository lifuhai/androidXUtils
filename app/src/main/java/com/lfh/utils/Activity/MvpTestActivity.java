package com.lfh.utils.Activity;

import android.widget.TextView;

import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.utils.R;
import com.lfh.utils.contract.MvpTestContract;
import com.lfh.utils.presenter.MvpTestPresenter;


public class MvpTestActivity extends BaseMvpActivity<MvpTestPresenter>  implements MvpTestContract.View{

    private TextView textView;

    @Override
    public MvpTestPresenter createPresenter() {
        return new MvpTestPresenter();
    }

    @Override
    protected void initLocalData() {

        hold(R.id.linear);
        textView = findViewById(R.id.tv_mvpccc);
        initData();
        mVaryViewHelper.showErrorView();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_mvp_test;
    }


    @Override
    public void initData() {

        mVaryViewHelper.showDataView();

    }



}