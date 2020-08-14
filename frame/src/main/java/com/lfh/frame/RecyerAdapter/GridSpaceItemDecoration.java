package com.lfh.frame.RecyerAdapter;


import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 每行个数
     */
    private int mSpanCount;
    /**
     * 间距
     */
    private int mSpacing;
    /**
     * 距屏幕周围是否也有间距
     */
    private boolean mIncludeEdge;


    public GridSpaceItemDecoration(int spanCount, int spacing) {
        this(spanCount, spacing, true);
    }

    /**
     * @param spanCount   item 每行个数
     * @param spacing     item 间距
     * @param includeEdge item 距屏幕周围是否也有间距
     */
    public GridSpaceItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.mSpanCount = spanCount;
        this.mSpacing = spacing;
        this.mIncludeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int lastPosition = state.getItemCount() - 1;
        int position = parent.getChildAdapterPosition(view);
        if (  position <= lastPosition ) {

            // 减掉不设置间距的position
            position = position ;
            int column = position % mSpanCount;

            // 瀑布流获取列方式不一样
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                column = ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
            }

            if (mIncludeEdge) {

                outRect.left = mSpacing - column * mSpacing / mSpanCount;
                outRect.right = (column + 1) * mSpacing / mSpanCount;

                if (position < mSpanCount) {
                    outRect.top = mSpacing;
                }
                outRect.bottom = mSpacing;

            } else {

                outRect.left = column * mSpacing / mSpanCount;
                outRect.right = mSpacing - (column + 1) * mSpacing / mSpanCount;
                if (position >= mSpanCount) {
                    outRect.top = mSpacing;
                }
            }
        }
    }



}