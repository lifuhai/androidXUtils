package com.lfh.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lfh.frame.base.BaseActivity;

@Route(path = "/first/main")
public class MainActivity extends BaseActivity {



    @Override
    protected void initView() {

        findViewById(R.id.tv_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/first/test").navigation();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main_first;
    }
}