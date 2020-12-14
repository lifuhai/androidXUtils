package com.lfh.utils.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lfh.frame.PackageUtil;
import com.lfh.frame.TimeUtils;
import com.lfh.frame.ToastMgr;
import com.lfh.frame.ZhengZe_ID_And_Phone;
import com.lfh.frame.base.BaseActivity;
import com.lfh.utils.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toast:
                ToastMgr.builder.display("111111111111111111");
                break;
            case R.id.phone:
                ToastMgr.builder.display(ZhengZe_ID_And_Phone.isMobile("15388888888") + "cccccccccccccc");
                break;
            case R.id.id_card:
                String msg = ZhengZe_ID_And_Phone.validate_effective("11292519900905XXXX");

                if (msg.equals("1129251990090XXXX")) {
                    ToastMgr.builder.display(msg + "cccccccccccccccc");
                } else {
                    ToastMgr.builder.display(msg);
                }

                break;

            case R.id.preview:

                startActivity(new Intent(this, TestPreviewActivity.class));
                break;
            case R.id.First:

                ARouter.getInstance().build("/first/main")
                        .navigation();
                break;
            case R.id.getPacke:
                Log.d("ccccccccccccc", "onClick: " + PackageUtil.getAppPackageName(this));
                ToastMgr.builder.display(TimeUtils.getNowTime() + "c cccc" + TimeUtils.stampToDate(System.currentTimeMillis() + ""));
                break;
            case R.id.recyer:

                startActivity(new Intent(this,RecyerActivity.class));
                break;

            case R.id.mvp:

                startActivity(new Intent(this, MvpTestActivity.class));
                break;
            case R.id.luckNumber:

                startActivity(new Intent(this, LuckActivity.class));
                break;
        }
    }


    @Override
    protected void initView() {
        findViewById(R.id.toast).setOnClickListener(this);
        findViewById(R.id.id_card).setOnClickListener(this);
        findViewById(R.id.phone).setOnClickListener(this);
        findViewById(R.id.preview).setOnClickListener(this);
        findViewById(R.id.getPacke).setOnClickListener(this);
        findViewById(R.id.recyer).setOnClickListener(this);
        findViewById(R.id.mvp).setOnClickListener(this);
        findViewById(R.id.First).setOnClickListener(this);
        findViewById(R.id.luckNumber).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
