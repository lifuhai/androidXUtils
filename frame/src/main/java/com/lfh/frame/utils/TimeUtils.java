package com.lfh.frame.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 可根据需要自行截取数据显示
     */
    public static String getTime(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return format.format(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }



    /**
     * 现在的时间距离开始时间是否大于dutation分钟
     */
    public static boolean getTimeCompareSize(String startTime, String nowTime,int durationTime) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//年-月-日 时-分分
        try {
            Date date1 = dateFormat.parse(startTime);//开始时间
            Date date2 = dateFormat.parse(nowTime);//现在时间
            if (date1.getTime() - date2.getTime() > durationTime) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 时间戳转换成字符窜
     *
     *
     * @return
     */
    public static String stampToDate(String s) {
        if(s.length()==10){
            s=s+"000";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //如果它本来就是long类型的,则不用写这一步
        long lt = new Long(s);
//        Date date = new Date(lt * 1000);
        Date date = new Date(lt );
        res = simpleDateFormat.format(date);
        return res;
    }




    /**
     * 日期转换成毫秒
     */
    public static long getSecondsFromDate(String startTime) {
        if (startTime == null || startTime.trim().equals(""))
            return 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = dateFormat.parse(startTime);//开始时间
            Date date2 = dateFormat.parse(getNowTime());
            return (long) ((date1.getTime() - date2.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String getNowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);

    }
}
