package com.JavaStudy.HspMiddleJavaTest.BigNum;

import java.math.BigDecimal;

/**
 * @author mingyu
 * @version 1.0
 * 精度很大的小数，使用BigDecimal保存
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("124.4345445535646156545641564");
        BigDecimal bigDecimal1 = new BigDecimal("2");

        //注意BigDecimal的除法，容易出现异常：无限循环小数，这时候需要指定精度保留为分子的精度
        System.out.println(bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING));
    }
}
