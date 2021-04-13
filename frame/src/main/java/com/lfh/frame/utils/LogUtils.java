package com.lfh.frame.utils;

import android.util.Log;

import com.lfh.frame.BuildConfig;


/**
 * 全局输出日志
 */

public class LogUtils {

    private static boolean LOG_SHOW= BuildConfig.DEBUG;
    public static void verbose(String tag, String msg) {
        if (LOG_SHOW) {
            Log.v(tag, msg);
        }
    }

    public static void verbose(String msg) {
        if (LOG_SHOW) {
            Log.v("verbose", msg);
        }
    }

    public static void debug(String tag, String msg) {
        if (LOG_SHOW) {
            Log.d(tag, msg);
        }
    }

    public static void debug(String msg) {
        if (LOG_SHOW) {
            Log.d("debug", msg);
        }
    }

    public static void info(String tag, String msg) {
        if (LOG_SHOW) {
            showLogCompletion(tag,msg,3);
        }
    }

    public static void info(String msg) {
        if (LOG_SHOW) {
            showLogCompletion(msg,3);
        }
    }


    public static void warn(String tag, String msg) {
        if (LOG_SHOW) {
            Log.w(tag, msg);
        }
    }

    public static void warn(String msg) {
        if (LOG_SHOW) {
            Log.w("warn", msg);
        }
    }


    public static void error(String tag, String msg) {
        if (LOG_SHOW) {
            showLogCompletion(tag,msg,5);
        }
    }

    public static void error(String msg) {
        if (LOG_SHOW) {
            showLogCompletion(msg,5);
        }
    }
    public static void showLogCompletion(String tag, String log, int type){
        if (log.length()>3000){
            String text=log.substring(0,3000);
            if (type==5){
                Log.e(tag, text);
            }else if (type==3){
                Log.i(tag, text);
            }
            if (log.length()- 3000 > 3000){
                String text2=log.substring(3000,log.length());
                showLogCompletion(tag,text2,type);
            }else {
                String text2=log.substring(3000,log.length());
                if (type==5){
                    Log.e(tag, text2);
                }else if (type==3){
                    Log.i(tag, text2);
                }
            }
        }else {
            if (type==5){
                Log.e(tag, log);
            }else if (type==3){
                Log.i(tag, log);
            }
        }

    }
    public static void showLogCompletion(String log, int type){
        if (log.length()>3600){
            String text=log.substring(0,3600);
            if (type==5){
                Log.e("error", text);
            }else if (type==3){
                Log.i("info", text);
            }
            if (log.length()- 3600 > 3600){
                String text2=log.substring(3600,log.length());
                showLogCompletion(text2,type);
            }else {
                String text2=log.substring(3600,log.length());
                if (type==5){
                    Log.e("error", text2);
                }else if (type==3){
                    Log.i("info", text2);
                }
            }
        }else {
            if (type==5){
                Log.e("error", log);
            }else if (type==3){
                Log.i("info", log);
            }
        }

    }

}
