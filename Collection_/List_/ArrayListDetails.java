package com.JavaStudy.HspMiddleJavaTest.Collection_.List_;

import java.util.ArrayList;

/**
 * @author mingyu
 * @version 1.0
 * ArrayList可以加入null，可以多个
 * ArrayList是由数组来实现数据存储的
 * ArrayList基本等同于Vector，除了ArrayList是线程不安全的（但是执行效率高），因此在多线程情况下不建议使用ArrayList
 */
public class ArrayListDetails {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
    }
}
