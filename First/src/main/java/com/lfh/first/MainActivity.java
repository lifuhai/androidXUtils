package com.lfh.first;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.lfh.first.presenter.Main01Presenter;
import com.lfh.first.presenter.MainPresenter;
import com.lfh.frame.base.BaseActivity;
import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.frame.base.ResponseListener;

import org.w3c.dom.Text;

@Route(path = "/first/main")
public class MainActivity extends BaseMvpActivity<Main01Presenter> {


    private TextView textView;


    @Override
    protected void initData() {

    }

    @Override
    public Main01Presenter createPresenter() {
        return new Main01Presenter();
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
//                ARouter.getInstance().build("/second/test").navigation();
            }
        });


    }

}