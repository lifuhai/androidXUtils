package com.lfh.utils.Activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.utils.R;
import com.lfh.utils.contract.MvpTestContract;
import com.lfh.utils.presenter.MvpTestPresenter;


public class MvpTestActivity extends BaseMvpActivity<MvpTestPresenter> implements MvpTestContract.View {

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


        final ImageView iv_image = findViewById(R.id.iv_image);


        Animation animate1 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        int width = getResources().getDisplayMetrics().widthPixels;
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int notifiheight = frame.top;
        int height = getResources().getDisplayMetrics().heightPixels - notifiheight;
        final float fromx = iv_image.getPivotX();
        final float tox = width / 2 - fromx - iv_image.getX();

        int sheight = iv_image.getScrollY();
        final float fromy = iv_image.getPivotY();
        final float toy = sheight + height / 2 - fromy - iv_image.getY();
        Animation animate2 = new TranslateAnimation(0, tox, 0, toy);
        final AnimationSet set = new AnimationSet(true);
        set.setFillAfter(true);
        set.addAnimation(animate1);
        set.addAnimation(animate2);
        set.setDuration(500);

        set.setFillAfter(true);

        iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_image.startAnimation(set);
            }
        });

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MvpTestActivity.this, RecyerActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation animate3 = new ScaleAnimation(fromx, fromx, fromy, fromy);

                        AnimationSet set2 = new AnimationSet(true);
                        set2.addAnimation(animate3);
                        set2.setDuration(0);
                        iv_image.startAnimation(set2);
                    }
                }, 500);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
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