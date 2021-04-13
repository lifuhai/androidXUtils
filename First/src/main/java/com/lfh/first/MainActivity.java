package com.lfh.first;

import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lfh.first.presenter.MainPresenter;
import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.frame.base.BaseView;

@Route(path = "/first/main")
public class MainActivity extends BaseMvpActivity<MainPresenter>  implements BaseView {


    private TextView textView;


    @Override
    protected void initData() {

    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main_first;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initLocalData() {
        textView = findViewById(R.id.tv_text);
        findViewById(R.id.bn_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/first/appbar").navigation();

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/first/test").navigation();
            }
        });


    }

}