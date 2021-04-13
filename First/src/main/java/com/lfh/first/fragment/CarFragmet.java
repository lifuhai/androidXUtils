package com.lfh.first.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lfh.first.R;
import com.lfh.first.presenter.MainPresenter;
import com.lfh.frame.base.BaseFragment;
import com.lfh.frame.base.BaseMvpFragment;
import com.lfh.frame.base.BaseView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * author : lfh
 * date   : 2021/4/1215:33
 * desc   :
 * version: 1.2.1
 */
public class CarFragmet extends BaseMvpFragment<MainPresenter>implements  BaseView {



    @Override
    protected void initView(View view) {
        hold(R.id.linear);
        mVaryViewHelper.showLoadingView();

//        initData();


        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mVaryViewHelper.showErrorView();

                    }
                });
        view.findViewById(R.id.tv_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVaryViewHelper.showEmptyView("哈哈哈哈");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_car;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        mVaryViewHelper.showDataView();
    }
}
