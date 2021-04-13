package com.lfh.first;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.Titles;
import com.lfh.first.fragment.CarFragmet;
import com.lfh.first.fragment.HeadFragmet;
import com.lfh.first.fragment.MyFragmet;
import com.lfh.first.fragment.ThreeFragmet;
import com.lfh.first.fragment.TwoFragmet;
import com.zackratos.ultimatebarx.library.UltimateBarX;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/first/test")
public class TestActivity extends AppCompatActivity {
    @Titles
    private static final String[] mTitleslive = {"首页", "分类", "中间", "购物车", "我的"};
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFragmentManager;
    @NorIcons
    private static final int[] mNormalIcons = {R.drawable.icon_home_h, R.drawable.icon_classification_h, R.drawable.icon_select_dui_hui, R.drawable.icon_car_h, R.drawable.icon_my_h};

    //    @SeleIcons
    private static final int[] mSeleIcons = {R.drawable.icon_home_c, R.drawable.icon_classification_c, R.drawable.icon_select_orange, R.drawable.icon_car_c, R.drawable.icon_my_c};
    private int mCurrentItem = -1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initLocalData();
    }


    protected int getContentViewId() {
        return R.layout.activity_test;
    }

    /**
     *
     * @param index
     * 设置每个碎片不同的状态栏 色值
     */
    private void setStatusBar(int index) {
        switch (index) {
            case 0:
                UltimateBarX.with(this)
                        .transparent()
                        .light(false)
                        .applyStatusBar();
                break;
            case 1:
                UltimateBarX.with(this)
                        .fitWindow(true)
                        .color(Color.RED)
                        .light(true)
                        .applyStatusBar();
                break;
            case 2:
                UltimateBarX.with(this)
                        .fitWindow(false)
                        .color(Color.BLACK)
                        .light(false)
                        .applyStatusBar();
                break;
            case 3:
                UltimateBarX.with(this)
                        .transparent()
                        .light(true)
                        .color(Color.GREEN)
                        .applyStatusBar();
                break;
            case 4:
                UltimateBarX.with(this)
                        .light(true)
                        .color(Color.WHITE)
                        .applyStatusBar();
                break;
        }
    }

    protected void initLocalData() {
;
        mFragments.add(new HeadFragmet());//批发
        mFragments.add(new TwoFragmet());//批发
        mFragments.add(new ThreeFragmet());//批发
        mFragments.add(new CarFragmet());//批发
        mFragments.add(new MyFragmet());//批发


        mFragmentManager = getSupportFragmentManager();
        changeFragment(0);

        JPTabBar  tabBar = findViewById(R.id.tabbar);
        tabBar.setTabListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int index) {
                changeFragment(index);
                setStatusBar(index);
            }

            @Override
            public boolean onInterruptSelect(int index) {
                return false;
            }
        });

        UltimateBarX.with(this)
                .transparent()
                .applyStatusBar();
    }


    private void changeFragment(int i) {
        //这里不推荐使用replace()
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mFragments.get(i).isAdded()) {
            fragmentTransaction.hide(mFragments.get(mCurrentItem)).show(mFragments.get(i));
        } else {
            if (mCurrentItem == -1) {//初始状态新建
                fragmentTransaction.add(R.id.linear, mFragments.get(i));
            } else {//非初始状态切换
                fragmentTransaction.hide(mFragments.get(mCurrentItem)).add(R.id.linear, mFragments.get(i));
            }
        }
        fragmentTransaction.commit();
        mCurrentItem = i;
    }
}