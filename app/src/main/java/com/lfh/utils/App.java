package com.lfh.utils;

import android.app.Application;
import android.os.Handler;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lfh.first.TestActivity;
import com.lfh.frame.utils.ImageUtils;
import com.lfh.frame.utils.ToastMgr;
import com.lfh.utils.Activity.MainActivity;
import com.zxy.recovery.callback.RecoveryCallback;
import com.zxy.recovery.core.Recovery;

public class App extends Application {
    public static Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        ToastMgr.builder.init(this);
        mHandler = new Handler();
        ImageUtils.initWindow(this);
        initARouter();



        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(true)
                .recoverStack(true)
                .mainPage(MainActivity.class)
                .recoverEnabled(true)
                .callback(new MyCrashCallback())
                .silent(!BuildConfig.DEBUG, Recovery.SilentMode.RESTART_AND_CLEAR   )
                .skip(TestActivity.class)
                .init(this);
        MyCrashHandler.register();
    }

    static final class MyCrashCallback implements RecoveryCallback {
        @Override
        public void stackTrace(String exceptionMessage) {
            Log.e("zxy", "exceptionMessage:" + exceptionMessage);
        }

        @Override
        public void cause(String cause) {
            Log.e("zxy", "cause:" + cause);
        }

        @Override
        public void exception(String exceptionType, String throwClassName, String throwMethodName, int throwLineNumber) {
            Log.e("zxy", "exceptionClassName:" + exceptionType);
            Log.e("zxy", "throwClassName:" + throwClassName);
            Log.e("zxy", "throwMethodName:" + throwMethodName);
            Log.e("zxy", "throwLineNumber:" + throwLineNumber);
        }

        @Override
        public void throwable(Throwable throwable) {

        }
    }



    private void initARouter() {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }



    /**
     * Created by zhengxiaoyong on 2017/1/16.
     */
    public static class MyCrashHandler implements Thread.UncaughtExceptionHandler {

        private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;

        public MyCrashHandler() {
            mUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            Log.e("zxy", "myCrashHandler...");
            mUncaughtExceptionHandler.uncaughtException(t, e);
        }


        public  static  void register() {
            Thread.setDefaultUncaughtExceptionHandler(new MyCrashHandler());
        }
    }
}
