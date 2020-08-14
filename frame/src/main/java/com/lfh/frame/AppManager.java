/**
 * 
 */
package com.lfh.frame;

import android.app.Activity;

import java.util.Stack;

/**
 * Activity管理类,用于应用程序管理和退出
 * 
 */
public class AppManager {
	private static Stack<Activity> activityStack;
	private static AppManager instance;

	private AppManager() {
	}

	//10.240.0.97
	/**
	 * 单一实例
	 */
	public static AppManager getAppManager() {
		if (instance == null) {
			instance = new AppManager();
		}
		return instance;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity() {
		if (activityStack != null && !activityStack.isEmpty()) {
			Activity activity = activityStack.lastElement();
			return activity;
		}
		return null;
	}

	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public static void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 结束指定的Activity
	 */
	public static void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity4
	 */
	public  static void finishActivity(Class<?> cls) {
		Stack<Activity> deleteActivityStack = new Stack<Activity>();
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				// finishActivity(activity);
				deleteActivityStack.add(activity);
			}
		}

		activityStack.removeAll(deleteActivityStack);
		for (Activity activity : deleteActivityStack) {
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束所有Activity
	 */
	public static void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 退出应用程序
	 */
	public static void AppExit() {
		try {
			finishAllActivity();
			android.os.Process.killProcess(android.os.Process.myPid());
			System.exit(0);
		} catch (Exception e) {

		}
	}
}
