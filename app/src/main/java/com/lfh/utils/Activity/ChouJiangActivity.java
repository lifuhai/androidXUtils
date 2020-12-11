package com.lfh.utils.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lfh.frame.base.BaseActivity;
import com.lfh.utils.ChouJiangView;
import com.lfh.utils.R;
import com.zackratos.ultimatebarx.library.UltimateBarX;
import com.zackratos.ultimatebarx.library.bean.BarConfig;

public class ChouJiangActivity extends BaseActivity {

    private ChouJiangView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        BarConfig barConfig = new BarConfig();
//        barConfig.fitWindow(true).color(Color.RED).light(false);
//        UltimateBarX.with(this).config(barConfig).applyStatusBar();

        UltimateBarX.with(this)
                .transparent()
                .applyStatusBar();

        v1 = findViewById(R.id.choujiang);
        findViewById(R.id.tv_text111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.startAnim();
                v1.mShouldStartNextTurn=false;

            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_chou_jiang;
    }
}