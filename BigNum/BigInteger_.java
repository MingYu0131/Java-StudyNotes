package com.JavaStudy.HspMiddleJavaTest.BigNum;

import com.sun.xml.internal.ws.spi.db.BindingInfo;

import java.math.BigInteger;

/**
 * @author mingyu
 * @version 1.0
 * 使用BigInteger类型，来处理那些极大的整数（超出long的表示范围）
 */
public class BigInteger_ {
    public static void main(String[] args) {
        //底层原理其实是将字符串转成数，使用int类型来表示数据的位数
        BigInteger bigInteger = new BigInteger("1245686746548954156");
        //使用BigInteger的数据类型，不能直接加减乘除，需要使用特定方法
        BigInteger bigInteger1 = new BigInteger("123");

        bigInteger = bigInteger.add(bigInteger1); //b = b + b1;
        bigInteger = bigInteger.multiply(bigInteger1); //b = b*b1
        bigInteger = bigInteger.subtract(bigInteger1);// b= b - b1
        bigInteger = bigInteger.divide(bigInteger1);//b = b/b1
    }
}
