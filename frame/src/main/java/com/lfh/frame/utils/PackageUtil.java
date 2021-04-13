/**
 *
 */
package com.lfh.frame.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * 获取版本信息
 */
public class PackageUtil {
	/**
	 * get app version code
	 *
	 * @param context
	 * @return
	 */
	public static int getAppVersionCode(Context context) {
		if (context != null) {
			PackageManager pm = context.getPackageManager();
			if (pm != null) {
				PackageInfo pi;
				try {
					pi = pm.getPackageInfo(context.getPackageName(), 0);
					if (pi != null) {
						return pi.versionCode;
					}
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}

	/**
	 * get app version Name
	 *
	 * @param context
	 * @return
	 */
	public static String getAppVersionName(Context context) {
		if (context != null) {
			PackageManager pm = context.getPackageManager();
			if (pm != null) {
				PackageInfo pi;
				try {
					pi = pm.getPackageInfo(context.getPackageName(), 0);
					if (pi != null) {
						return pi.versionName;
					}
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}


	/**
	 * get app Package Name
	 *
	 * @param context
	 * @return
	 */
	public static String getAppPackageName(Context context) {
		if (context != null) {
			String name = context.getPackageName();

			return  name;
		}
		return "";
	}



}
