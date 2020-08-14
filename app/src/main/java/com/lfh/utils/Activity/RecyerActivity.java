package com.lfh.utils.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lfh.frame.RecyerAdapter.BaseRecyerAdapter;
import com.lfh.frame.RecyerAdapter.GridSpaceItemDecoration;
import com.lfh.frame.ToastMgr;
import com.lfh.frame.base.BaseActivity;
import com.lfh.utils.R;
import com.lfh.utils.adapter.RecyerAdapter;

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
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        GridSpaceItemDecoration itemDecoration = new GridSpaceItemDecoration(3, 20, false);

        recyclerView.addItemDecoration(itemDecoration);


        RecyerAdapter adapter = new RecyerAdapter(this,list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRecyerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                ToastMgr.builder.display("ccccccccccccc"+position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                ToastMgr.builder.display("ccccccccccc长摁"+position);
                return true;
            }
        });

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
