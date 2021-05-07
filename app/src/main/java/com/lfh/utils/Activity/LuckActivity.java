package com.lfh.utils.Activity;

import android.os.Bundle;
import android.view.View;

import com.lfh.frame.base.BaseActivity;
import com.lfh.frame.utils.LogUtils;
import com.lfh.utils.LuckView;
import com.lfh.utils.R;
import com.zackratos.ultimatebarx.library.UltimateBarX;
/**
 *
 * @author lfh
 * @date 2021/5/7
 * Description : LuckActivity
 *
 */
public class LuckActivity extends BaseActivity {

    private LuckView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        BarConfig barConfig = new BarConfig();
//        barConfig.fitWindow(true).color(Color.RED).light(false);
//        UltimateBarX.with(this).config(barConfig).applyStatusBar();

        LogUtils.debug("cccccccc");
        UltimateBarX.with(this)
                .transparent()
                .applyStatusBar();

        v1 = findViewById(R.id.choujiang);
        findViewById(R.id.tv_text111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.startAnim();
                v1.mNext=false;

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