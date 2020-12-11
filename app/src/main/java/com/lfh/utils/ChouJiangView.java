package com.lfh.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.lfh.frame.ImageUtils;
import com.lfh.frame.ToastMgr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by lfh
 * on 2020/11/5
 */

public class ChouJiangView extends LinearLayout {


    private String[] mDetailContant = {"币", "券", "狗粮", "券", "iphone12", "卡", "京东卡", "免费券", "iphone12"};


    private LinearLayout l9;
    private LinearLayout l8;
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private LinearLayout l5;
    private LinearLayout l6;
    private LinearLayout l7;
    private Paint mPaint;
    private int mRepeatCount = 2; // 转的圈数
    private int mLuckNum = 2; // 默认最终中奖位置

    public ChouJiangView(Context context) {
        super(context);
        initView(context);

    }

    public ChouJiangView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    private List<LinearLayout> mView; // 存储view的集合

    public boolean mNext = true; // 标记是否应该开启下一轮抽奖
    private int mStartLuckPosition = 0; // 开始抽奖的位置

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.choujiang, this);
        LinearLayout linear_contant = view.findViewById(R.id.linear_contant);
        LinearLayout.LayoutParams layoutParams = (LayoutParams) linear_contant.getLayoutParams();
        layoutParams.width = ImageUtils.windowWidth;
        layoutParams.height = ImageUtils.windowWidth;
        linear_contant.setLayoutParams(layoutParams);

        l1 = view.findViewById(R.id.l1);
        l2 = view.findViewById(R.id.l2);
        l3 = view.findViewById(R.id.l3);
        l4 = view.findViewById(R.id.l4);
        l5 = view.findViewById(R.id.l5);
        l6 = view.findViewById(R.id.l6);
        l7 = view.findViewById(R.id.l7);
        l8 = view.findViewById(R.id.l8);
        l9 = view.findViewById(R.id.l9);


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG); // 抗锯齿
        mPaint.setStyle(Paint.Style.FILL);
        // mPaint.setStyle(Paint.Style.STROKE); // 设置样式为描边
//        mPaint.setStrokeWidth(mStrokeWidth); // 设置描边的宽度

        mView = new ArrayList<>();
        addViews();
    }


    public void setColor(int p) {
        Log.d("TAG", "onDraw: " + mView.size());
        for (int x = 0; x < mView.size(); x++) {
            LinearLayout view = mView.get(x);
            if (p == x) {
                view.setBackgroundColor(Color.BLUE);
            } else {
                view.setBackgroundColor(Color.WHITE); // 标记当前转盘经过的位置
            }
        }
//       addViews();

    }


    private void addViews() {
        mView.add(l1);
        mView.add(l2);
        mView.add(l3);
        mView.add(l6);
        mView.add(l9);
        mView.add(l8);
        mView.add(l7);
        mView.add(l4);
        mView.add(l5);

    }

    public void setLuckNum(int luckNum) {
        mLuckNum = luckNum;
    }

    public void startAnim() {
        if (!mNext) {
            return;
        }
        Random random = new Random();
        setLuckNum(random.nextInt(8)); // 生成 [0,8) 的随机整数

        ValueAnimator animator = ValueAnimator.ofInt(mStartLuckPosition, mRepeatCount * 9 + mLuckNum)
                .setDuration(3000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final int position = (int) animation.getAnimatedValue();
                Log.d("TAG", "onAnimationUpdate: " + position);
                setColor(position % 9);
                mNext = false;
            }
        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
                mNext = true;
                mStartLuckPosition = mLuckNum;
                ToastMgr.builder.display("g恭喜你中奖了" + mDetailContant[mLuckNum]);
            }
        });


        animator.start();
    }



}
