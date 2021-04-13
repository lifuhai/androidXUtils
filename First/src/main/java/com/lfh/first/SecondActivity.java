package com.lfh.first;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.lfh.first.presenter.MainPresenter;
import com.lfh.frame.base.BaseMvpActivity;
import com.lfh.frame.utils.FileUtils;
import com.lfh.frame.utils.ToastMgr;

@Route(path = "/second/test")
public class SecondActivity extends BaseMvpActivity<MainPresenter>  {


    private TextView textView;

    @Override
    protected void initData() {

    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
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