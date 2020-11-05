package com.lfh.utils.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lfh.utils.ChouJiangView;
import com.lfh.utils.R;

public class ChouJiangActivity extends AppCompatActivity {

    private ChouJiangView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chou_jiang);
        v1 = findViewById(R.id.choujiang);
        findViewById(R.id.tv_text111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.startAnim();
                v1.mShouldStartNextTurn=false;

            }
        });
    }
}