package com.lfh.utils.Activity;

import android.widget.TextView;

import com.lfh.frame.ToastMgr;
import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.utils.R;
import com.lfh.utils.contract.IMvpTest;
import com.lfh.utils.mode.request.TestJson;
import com.lfh.utils.presenter.TestMvpPresenter;

public class MvpTestActivity extends BaseMvpActivity<TestMvpPresenter>  implements IMvpTest.View{

    private TextView textView;

    @Override
    public TestMvpPresenter createPresenter() {
        return new TestMvpPresenter();
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
        //开始执行网络请求
        mPresenter.onClick(testJson.json());


    }


    @Override
    public void successGetDetail(Object data) {

        //网络成功回调
    }

    @Override
    public void failReason(String fail) {
        //网络失败回调

        ToastMgr.builder.display(fail);
    }
}