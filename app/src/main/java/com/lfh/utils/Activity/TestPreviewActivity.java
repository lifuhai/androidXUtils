package com.lfh.utils.Activity;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.lfh.frame.base.BaseActivity;
import com.lfh.utils.R;
import com.lfh.utils.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestPreviewActivity extends BaseActivity {

    private static final String TAG = "TestPreviewActivity";
    private ListView listView;
    private TestAdapter adapter;


    @Override
    public void initView() {
        hold(R.id.linear);//绑定view
        listView = findViewById(R.id.lv_list);
        mVaryViewHelper.showLoadingView();//预加载
        List<String>list = new ArrayList<>();
        int c = 3/0;
        Log.d(TAG, "initView: "+c);
        for (int i = 0; i < 30; i++) {
            list.add("呵呵"+i);
        }
        adapter = new TestAdapter(list,this,R.layout.item_list);
        listView.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    CommonUtils.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            mVaryViewHelper.showErrorView(R.drawable.bg_btn);
//                            mVaryViewHelper.showEmptyView("11111");
//                            mVaryViewHelper.showEmptyView("123",getResources().getDrawable(R.mipmap.ic_launcher));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }



    @Override
    public void initData() {

            mVaryViewHelper.showDataView();

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_preview;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listView = null;
    }
}
