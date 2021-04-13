package com.lfh.frame.preview;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lfh.frame.R;
import com.lfh.frame.utils.LogUtils;


public class VaryViewHelper {
    /**
     * 切换不同视图的帮助类
     */
    public OverlapViewHelper mViewHelper;
    /**
     * 错误页面
     */
    public View mErrorView;
    /**
     * 正在加载页面
     */
    public View mLoadingView;
    /**
     * 数据为空的页面
     */
    public View mEmptyView;
    /**
     * 正在加载页面的进度环
     */
    public ImageView imageView;


    private String text;
    private TextView empty_tv_text;
    private ImageView empty_tips_show;
    private View btn;

    public VaryViewHelper(View view) {
        this(new OverlapViewHelper(view));
    }

    public VaryViewHelper(OverlapViewHelper helper) {
        this.mViewHelper = helper;
    }


    public void setUpEmptyView(View view) {
        mEmptyView = view;
        mEmptyView.setClickable(true);

        empty_tv_text = (TextView) view.findViewById(R.id.empty_tv_text);
        empty_tips_show = (ImageView) view.findViewById(R.id.empty_tips_show);

    }

    public void setUpErrorView(View view, View.OnClickListener listener) {
        mErrorView = view;
        mErrorView.setClickable(true);

        btn = view.findViewById(R.id.vv_error_refresh);
        if (btn != null) {
            btn.setOnClickListener(listener);
        }
    }

    public void setUpLoadingView(View view) {
        mLoadingView = view;
        mLoadingView.setClickable(true);
        imageView = (ImageView) view.findViewById(R.id.image);
    }


    /**
     * 预加载为空页面  知替换文字
     *
     * @param text
     */
    public void showEmptyView(String text) {
        mViewHelper.showCaseLayout(mEmptyView);
        this.text = text;
        empty_tv_text.setText(text);
    }

    /**
     * @param text     要替换的空文字
     * @param drawable 要替换的空图片
     */
    public void showEmptyView(String text, Drawable drawable) {
        mViewHelper.showCaseLayout(mEmptyView);
        this.text = text;
        empty_tv_text.setText(text);
        empty_tips_show.setImageDrawable(drawable);
    }

    public void showErrorView() {
        mViewHelper.showCaseLayout(mErrorView);
    }

    public void showErrorView(int backgroundRes) {
        mViewHelper.showCaseLayout(mErrorView);
        btn.setBackgroundResource(backgroundRes);
    }

    public void showLoadingView() {
        mViewHelper.showCaseLayout(mLoadingView);
        startProgressLoading();
    }

    public void showDataView() {
        mViewHelper.restoreLayout();
    }


    private void startProgressLoading() {
        Glide.with(imageView.getContext()).asGif().load(R.drawable.loading)
                .into(imageView);
    }

    public void releaseVaryView() {
        mErrorView = null;
        mLoadingView = null;
        mEmptyView = null;
    }

    public static class Builder {
        private View mErrorView;
        private View mLoadingView;
        private View mEmptyView;
        private View mDataView;
        private View.OnClickListener mRefreshListener;

        public Builder setErrorView(View errorView) {
            mErrorView = errorView;
            return this;
        }

        public Builder setLoadingView(View loadingView) {
            mLoadingView = loadingView;
            return this;
        }

        public Builder setEmptyView(View emptyView) {
            mEmptyView = emptyView;
            return this;
        }

        public Builder setDataView(View dataView) {
            mDataView = dataView;
            return this;
        }

        public Builder setRefreshListener(View.OnClickListener refreshListener) {
            mRefreshListener = refreshListener;
            return this;
        }

        public VaryViewHelper build() {
            VaryViewHelper helper = new VaryViewHelper(mDataView);
            if (mEmptyView != null) {
                helper.setUpEmptyView(mEmptyView);
            }
            if (mErrorView != null) {
                helper.setUpErrorView(mErrorView, mRefreshListener);
            }
            if (mLoadingView != null) {
                helper.setUpLoadingView(mLoadingView);
            }
            return helper;
        }
    }


}
