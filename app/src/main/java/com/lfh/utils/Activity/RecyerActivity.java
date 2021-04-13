package com.lfh.utils.Activity;

import androidx.recyclerview.widget.RecyclerView;

import com.lfh.frame.base.BaseActivity;
import com.lfh.utils.R;

import java.util.ArrayList;
import java.util.List;

public class RecyerActivity extends BaseActivity {


    private RecyclerView recyclerView;

    @Override
    public void initView() {
        recyclerView = findViewById(R.id.recycer);
        List<String>list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试"+i);
        }
        /**
         *   list 分割线
         */

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        LinearItemDecoration linearItemDecoration = new LinearItemDecoration();
//        linearItemDecoration.setColor(Color.RED);
//        linearItemDecoration.setSpanSpace(ImageUtils.px2dp(10,this));
//        recyclerView.addItemDecoration(linearItemDecoration);


        /**
         *   gird 分割线
         */


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        recyclerView=null;
    }


    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_recyer;
    }
}
