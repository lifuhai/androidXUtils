package com.lfh.frame.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *   身份证号码识别
 *   和国内手机号码识别
 *
 */

public class ZhengZe_ID_And_Phone{
    private static final String[] a = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
    private static final String[] b = new String[]{"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
    private static final Date c = new Date(-2209017600000L);
    private static boolean d = false;

    public ZhengZe_ID_And_Phone() {

    }

    public static String validate_effective(String idcardNumber, boolean isreturn_AutoCard) {
        d = isreturn_AutoCard;
        return validate_effective(idcardNumber);
    }

    public static String validate_effective(String idcardNumber) {
        String var1 = idcardNumber.trim();
        System.out.println(var1.length() != 15);
        if (!(var1.length() == 15 | var1.length() == 18)) {
            return "身份证长度必须为15或者18位！";
        } else {
            if (var1.length() == 15) {
                var1 = a(var1);
            }

            for(int var2 = 0; var2 < 17; ++var2) {
                char var3 = var1.charAt(var2);
                if (var3 < '0' || var3 > '9') {
                    return "15位身份证都应该为数字，18位身份证都应该前17位应该都为数字！";
                }
            }

            try {
                Date var6 = b(var1);
                if (null == var6) {
                    return "身份证日期验证无效！";
                }

                if (!var6.before(new Date())) {
                    return "身份证日期验证无效！";
                }

                if (!var6.after(c)) {
                    return "身份证日期验证无效！";
                }

                String var8 = c(var1);
                String var4 = b().format(var6);
                if (!var8.equals(var4)) {
                    return "身份证日期验证无效！";
                }
            } catch (Exception var5) {
                return "身份证日期验证无效！";
            }

            Hashtable var7 = a();
            if (var7.get(var1.substring(0, 2)) == null) {
                return "身份证地区编码错误!";
            } else if (!a((CharSequence)var1).equals(String.valueOf(var1.charAt(17)))) {
                return "身份证最后一位校验码有误！";
            } else {
                return !d ? idcardNumber : var1;
            }
        }
    }

    private static String a(String var0) {
        StringBuilder var1 = new StringBuilder(18);
        var1.append(var0.substring(0, 6));
        var1.append("19");
        var1.append(var0.substring(6));
        var1.append(a((CharSequence)var1));
        return var1.toString();
    }

    private static String a(CharSequence var0) {
        int var1 = 0;

        for(int var2 = 0; var2 < 17; ++var2) {
            char var3 = var0.charAt(var2);
            var1 += (var3 - 48) * Integer.parseInt(b[var2]);
        }

        return a[var1 % 11];
    }

    private static Hashtable<String, String> a() {
        Hashtable var0 = new Hashtable();
        var0.put("11", "北京");
        var0.put("12", "天津");
        var0.put("13", "河北");
        var0.put("14", "山西");
        var0.put("15", "内蒙古");
        var0.put("21", "辽宁");
        var0.put("22", "吉林");
        var0.put("23", "黑龙江");
        var0.put("31", "上海");
        var0.put("32", "江苏");
        var0.put("33", "浙江");
        var0.put("34", "安徽");
        var0.put("35", "福建");
        var0.put("36", "江西");
        var0.put("37", "山东");
        var0.put("41", "河南");
        var0.put("42", "湖北");
        var0.put("43", "湖南");
        var0.put("44", "广东");
        var0.put("45", "广西");
        var0.put("46", "海南");
        var0.put("50", "重庆");
        var0.put("51", "四川");
        var0.put("52", "贵州");
        var0.put("53", "云南");
        var0.put("54", "西藏");
        var0.put("61", "陕西");
        var0.put("62", "甘肃");
        var0.put("63", "青海");
        var0.put("64", "宁夏");
        var0.put("65", "新疆");
        var0.put("71", "台湾");
        var0.put("81", "香港");
        var0.put("82", "澳门");
        var0.put("91", "国外");
        return var0;
    }

    private static Date b(String var0) {
        Date var1;
        try {
            var1 = b().parse(c(var0));
        } catch (Exception var3) {
            throw new RuntimeException("身份证的出生日期无效");
        }

        return new Date(var1.getTime());
    }

    private static SimpleDateFormat b() {
        return new SimpleDateFormat("yyyyMMdd");
    }

    private static String c(String var0) {
        return var0.substring(6, 14);
    }


    /**
     *   验证手机号
     */

    public static boolean isMobile(String mobile) {
        // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String regex = "^(1(3|4|5|6|7|8|9))\\d{9}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }



    /**
     * 身份证号中间用*代替
     */
    public static String hideId(String id) {
        if (id != null && id.length() > 0) {

            StringBuilder stringBuilder = new StringBuilder(id);
            stringBuilder.replace(1, id.length() - 1, "****************");
            return stringBuilder.toString();
        }
        return "";
    }

}
