package com.aboplus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

/**
 * 提供字符串、集合、Map、对象的非空判断
 *
 * @author : Abo
 * @date : 2022/1/1 18:44
 */
public class CheckUtils {
    /**
     * 判断字符串日期是否是符合指定格式的时间
     *
     * @param date   时间字符串
     * @param format 时间格式
     * @return 是否符合
     */
    public static boolean isDate(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断字符串有效性
     *
     * @param str 需要判断的字符串
     * @return 是否有效
     */
    public static boolean isNotBlack(String str) {
        return !(str == null || "".equals(str.trim()));
    }

    /**
     * 判断一组字符串是否有效
     *
     * @param strs 需要判断的字符串
     * @return 是否有效
     */
    public static boolean isNotBlack(String[] strs) {
        for (String s : strs) {
            if (!isNotBlack(s)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断对象是否有效
     *
     * @param obj 需要判断的对象
     * @return 是否有效
     */
    public static boolean isNotBlack(Object obj) {
        return !(null == obj);
    }

    /**
     * 判断一组对象是否有效
     *
     * @param objs 需要判断的对象
     * @return 是否有效
     */
    public static boolean isNotBlack(Object[] objs) {
        return objs != null && objs.length != 0;
    }

    /**
     * 判断集合是否有效
     *
     * @param col 需要判断的集合
     * @return 是否有效
     */
    public static boolean isNotBlack(Collection col) {
        return !(col == null || col.isEmpty());
    }

    /**
     * 判断一组集合是否有效
     *
     * @param cols 需要判断的集合
     * @return 是否有效
     */
    public static boolean isNotBlack(Collection... cols) {
        for (Collection c : cols) {
            if (!isNotBlack(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断map是否有效
     *
     * @param map 需要判断map
     * @return 是否有效
     */
    public static boolean isNotBlack(Map map) {
        return !(map == null || map.isEmpty());
    }

    /**
     * 判断一组map是否有效
     *
     * @param maps 需要判断map
     * @return 是否全部有效
     */
    public static boolean isNotBlack(Map... maps) {
        for (Map m : maps) {
            if (!isNotBlack(m)) {
                return false;
            }
        }
        return true;
    }
}
