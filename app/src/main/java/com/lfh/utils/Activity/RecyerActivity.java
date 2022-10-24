package com.lfh.utils.Activity;

import androidx.recyclerview.widget.RecyclerView;

import com.lfh.frame.base.BaseActivity;
import com.lfh.utils.R;

import java.util.ArrayList;
import java.util.List;

public class RecyerActivity extends BaseActivity {

   private int mCurrentPosition = 0;
    int mSuspensionHeight;
    @Override
    public void initView() {

        List<String>list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试"+i);
        }
        /**
         *   list 分割线
         */

//       TestRvAdapter testRvAdapter = new TestRvAdapter();
//         @SuppressLint("WrongConstant") final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayout.VERTICAL, false);

//         recyclerView.setAdapter(testRvAdapter);
//         testRvAdapter.addData(list);
//         recyclerView.setLayoutManager(layoutManager);
//         recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//             @Override
//             public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                 super.onScrolled(recyclerView, dx, dy);
//                 mSuspensionHeight = tv_lv.getHeight();
//                 View view = layoutManager.findViewByPosition(mCurrentPosition + 1);
//                 if (view != null) {
//                     if (view.getTop() <= mSuspensionHeight) {
//                         tv_lv.setY(-(mSuspensionHeight - view.getTop()));
//                     } else {
//                         tv_lv.setY(0);
//                     }
//                 }
//                 mCurrentPosition = layoutManager.findFirstVisibleItemPosition();
//                 tv_lv.setText(list.get(mCurrentPosition).toString());

//             }
//         });


    }


    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_recyer;
    }
}
