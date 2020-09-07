package com.lfh.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lfh.first.contract.MainContract;
import com.lfh.first.presenter.MainPresenter;
import com.lfh.frame.ToastMgr;
import com.lfh.frame.base.BaseMvpActivity;

@Route(path = "/first/test")
public class TestActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View{

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initLocalData() {
        mPresenter.getNetData("01");
    }

    @Override
    public void getNetDataSuccess(String success) {

        Log.d("TAG", "getNetDataSuccess: "+success);

        ToastMgr.builder.display(success);
    }
}