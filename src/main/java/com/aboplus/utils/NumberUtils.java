package com.aboplus.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

/**
 * @author : Abo
 * @date : 2022/1/4 13:26
 */
public class NumberUtils {

    /**
     * 默认小数位数
     */
    private static final int DEFAULT_SCALE = 2;

    /**
     * 获取百分比
     *
     * @param molecular   分子
     * @param denominator 分母
     */
    public static String getPercent(long molecular, long denominator) {
        String percent = "0%";
        if (molecular == 0 || denominator == 0) {
            return percent;
        }
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(DEFAULT_SCALE);
        percent = numberFormat.format((float) molecular / (float) denominator * 100) + "%";
        return percent;
    }

    /**
     * 获取百分比
     *
     * @param molecular   分子
     * @param denominator 分母
     */
    public static String getPercent(BigDecimal molecular, BigDecimal denominator) {
        String percent = "0%";
        if (molecular.compareTo(BigDecimal.valueOf(0)) == 0 || denominator.compareTo(BigDecimal.valueOf(0)) == 0) {
            return percent;
        }
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(DEFAULT_SCALE);
        percent = numberFormat.format(molecular.divide(denominator, 2, RoundingMode.HALF_UP)) + "%";
        return percent;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 分转化为元，三位一逗，保留两位小数
     *
     * @param amount 要转换的金额数值
     * @return 转换好的样式
     */
    public static String fen2yuan(Long amount) {
        DecimalFormat format = new DecimalFormat("#,###.00");
        BigDecimal res = BigDecimal.valueOf(amount).divide(BigDecimal.valueOf(100.0), 2, RoundingMode.HALF_UP);
        return format.format(res);
    }

    /**
     * 分转化为元，三位一逗，保留两位小数
     *
     * @param amount 要转换的金额数值
     * @return 转换好的样式
     */
    public static String fen2yuan(BigDecimal amount) {
        DecimalFormat format = new DecimalFormat("#,###.00");
        BigDecimal res = amount.divide(BigDecimal.valueOf(100.0), 2, RoundingMode.HALF_UP);
        return format.format(res);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Double类型相加
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数和
     */
    public static Double doubleAdd(Double v1, Double v2) {
        return BigDecimal.valueOf(v1).add(BigDecimal.valueOf(v2)).doubleValue();
    }

    /**
     * Double类型相减
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数差
     */
    public static Double doubleSub(Double v1, Double v2) {
        return BigDecimal.valueOf(v1).subtract(BigDecimal.valueOf(v2)).doubleValue();
    }

    /**
     * Double类型相乘
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static Double doubleMul(Double v1, Double v2) {
        return BigDecimal.valueOf(v1).multiply(BigDecimal.valueOf(v2)).doubleValue();
    }

    /**
     * Double类型相除
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精度
     * @return 两个参数的商
     */
    public static Double doubleDiv(Double v1, Double v2, Integer scale) {
        if (v1 == null || v2 == null) {
            return null;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("精度不能小于零");
        }
        if (Objects.equals(BigDecimal.valueOf(v2).compareTo(BigDecimal.ZERO), 0)) {
            throw new IllegalArgumentException("除数不能为零");
        }
        if (Objects.equals(BigDecimal.valueOf(v1).compareTo(BigDecimal.ZERO), 0)) {
            return BigDecimal.ZERO.doubleValue();
        }
        return BigDecimal.valueOf(v1).divide(BigDecimal.valueOf(v2), scale, RoundingMode.HALF_UP).doubleValue();
    }

}
