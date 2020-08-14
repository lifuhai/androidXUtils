package com.lfh.utils.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lfh.frame.ToastMgr;
import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.utils.R;
import com.lfh.utils.mode.TestJson;
import com.lfh.utils.presenter.TestMvpPresenter;

public class MvpTestActivity extends BaseMvpActivity<TestMvpPresenter> {

    private TextView textView;

    @Override
    public TestMvpPresenter createPresenter() {
        return new TestMvpPresenter(this);
    }

    @Override
    protected void initLocalData() {

        hold(R.id.linear);
        textView = findViewById(R.id.tv_mvpccc);
        initData();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_mvp_test;
    }


    @Override
    public void initData() {
        TestJson testJson = new TestJson();
        testJson.setId("0101");
        testJson.setName("11111");
        mPresenter.onClick(testJson.json());


    }

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);

        textView.setText(o.toString());
        ToastMgr.builder.display(o.toString());
    }


    @Override
    public void onFail(String t) {
        super.onFail(t);
        textView.setText("失败" + t.toString());

    }
}