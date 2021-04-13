package com.lfh.frame.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Administrator on 2016/6/16.
 */
public class ImageUtils {


    private static final String TAG = "ImageUtils";


      public  static  int windowWidth;
      public  static  int windowHeight;
        /*
        *  屏幕宽高
        */
    public static  void initWindow(Context context) {

        DisplayMetrics mDisplayMetrics =context.getResources().getDisplayMetrics();
        windowWidth = mDisplayMetrics.widthPixels;
        windowHeight = mDisplayMetrics.heightPixels;


    }



    /**
     * 计算一个view的高度
     * @param view view
     */
    public static void ViewHeight(View view,double h) {
        ViewGroup.LayoutParams lp=view.getLayoutParams();
        double height= (windowHeight)*(h/1920);
        lp.height= (int) height;
        view.setLayoutParams(lp);
    }
    public static void ViewWidth(View view,double w) {
        ViewGroup.LayoutParams lp=view.getLayoutParams();
        double width= ((windowWidth)*(w/1080));
        lp.width= (int) width;
        view.setLayoutParams(lp);
    }


    /**
     * px转换成dp
     */
    public static int px2dp(float pxValue, Context context){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }


}
