package com.lfh.first;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.lfh.first.presenter.SecondPresenter;
import com.lfh.frame.FileUtils;
import com.lfh.frame.ToastMgr;
import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.frame.callback.ResponseListener;

@Route(path = "/second/test")
public class SecondActivity extends BaseMvpActivity<SecondPresenter>  {


    private TextView textView;

    @Override
    protected void initData() {

    }

    @Override
    public SecondPresenter createPresenter() {
        return new SecondPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_second;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initLocalData() {
        final SignaturePad mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);

        textView = findViewById(R.id.tv_click);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onCick();




           boolean b    = FileUtils.saveImageToGallery(mContext,mSignaturePad.getSignatureBitmap());
                ToastMgr.builder.display("cccccccc"+b);

                mSignaturePad.clear();

            }
        });

        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {


            @Override
            public void onStartSigning() {
                //Event triggered when the pad is touched
                Log.d("TAG", "onSignedccccc: "+mSignaturePad.getTransitionName());

            }


            @Override
            public void onSigned() {
                //Event triggered when the pad is signed



            }

            @Override
            public void onClear() {
                //Event triggered when the pad is cleared
            }
        });
    }


}