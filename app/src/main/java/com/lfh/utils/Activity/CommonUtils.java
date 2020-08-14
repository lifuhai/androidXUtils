package com.lfh.utils.Activity;

import com.lfh.utils.App;

public class CommonUtils {
    public static void runOnUIThread(Runnable r){
        App.mHandler.post(r);
    }
}
