package com.lfh.frame.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lfh.frame.R;


/**
 * 吐司统一工具类
 *
 */
public enum ToastMgr {
    builder, ToastMgr;
    private Toast toast;
    private TextView tv;

    /**
     * 初始化Toast
     *
     * @param context
     */
    public void init(Context context) {
        toast = new Toast(context);
        View view = LayoutInflater.from(context).inflate(R.layout.toast,
                null);
        tv = (TextView) view.findViewById(R.id.toast_text);
        toast.setView(view);
    }

    /**
     * 显示Toast
     *
     * @param content
     *            Toast持续时间
     */
    public  void display(CharSequence content) {
        if (content == null) {
            return;
        }
        if (content.length() != 0) {
            tv.setText(content.toString());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}