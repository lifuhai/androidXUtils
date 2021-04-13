package com.lfh.frame.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author zys
 */
public class ToolUtil {
    /*
     *两次点击间隔不能少于1000ms
     */
    private static final int MIN_DELAY_TIME = 500;
    private static long lastClickTime = 0;
    private static int lastViewId = -1;
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().disableHtmlEscaping().create();
        }
        return gson;
    }

    /**
     * 是否快速点击
     *
     * @return
     */
    public static boolean isFastClick(int viewId) {
        boolean flag = false;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) < MIN_DELAY_TIME && lastViewId == viewId) {
            flag = true;
        }
        lastViewId = viewId;
        lastClickTime = currentClickTime;
        return flag;
    }


    public static String mapToJson(Map<String, String> map) {
        Set<String> keys = map.keySet();
        String key;
        String value;
        StringBuilder jsonBuffer = new StringBuilder();
        jsonBuffer.append("{");
        for (Iterator<String> it = keys.iterator(); it.hasNext(); ) {
            key = it.next();
            value = map.get(key);
            jsonBuffer.append("\"");
            jsonBuffer.append(key).append("\":\"").append(value).append("\"");
            if (it.hasNext()) {
                jsonBuffer.append(",");
            }
        }
        jsonBuffer.append("}");
        return jsonBuffer.toString();
    }

    public static Map<String, String> jsonToMap(String json) {
        Map<String, String> map = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            Iterator<String> it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next();
                map.put(key, jsonObject.getString(key));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }



    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getWindowWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static int getWindowHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }



    /**
     * 验证电话号正确
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String regexp = "^(((\\+\\d{2}-)?0\\d{2,3}-\\d{7,8})|((\\+\\d{2}-)?(\\d{2,3}-)?([1][3,4,5,6,7,8,9][0-9]\\d{8})))$";
        p = compile(regexp);
        m = p.matcher(phone);
        b = m.matches();
        return b;
    }

    /**
     * 隐藏软键盘
     *
     * @param context
     * @param view
     */
    public static void hideSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 按照 template 格式 格式化 日期 date
     *
     * @param date
     * @param template
     * @return
     */
    public static String formatDateByTemplate(Date date, String template) {
        String res;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat(template);
        res = sdf.format(date);
        return res;
    }

    /**
     * 调起拨号盘，无需权限，不需要兼容各种系统
     *
     * @param context
     * @param phone
     */
    @SuppressLint("CheckResult")
    public static void toCall(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phone);
        intent.setData(data);
        context.startActivity(intent);
    }

    /**
     * 打开设置界面
     *
     * @param context
     */
    public static void startAppSetting(Context context) {
        Uri packageURI = Uri.parse("package:" + context.getPackageName());
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
        context.startActivity(intent);
    }

    /**
     * get file md5
     *
     * @param file
     * @return
     */
    public static String getFileMD5(File file) throws NoSuchAlgorithmException, IOException {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest;
        FileInputStream in;
        byte buffer[] = new byte[1024];
        int len;
        digest = MessageDigest.getInstance("MD5");
        in = new FileInputStream(file);
        while ((len = in.read(buffer, 0, 1024)) != -1) {
            digest.update(buffer, 0, len);
        }
        in.close();
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }



}
