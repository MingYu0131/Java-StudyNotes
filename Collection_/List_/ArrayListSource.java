package com.JavaStudy.HspMiddleJavaTest.Collection_.List_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyu
 * @version 1.0
 * 追源码了解ArrayList的扩容机制
 * （1）ArrayList中维护了一个Object类型的数组elementData
 * transient Object[] elementData;  //transient表示瞬间、短暂的。表示该属性不会被序列化
 * （2）当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0，第一次add，扩容为10，
 * 如果再次扩容，则扩容为elementData的1.5倍
 * （3）如果直接使用指定大小的构造器，则初始elementData为指定大小，如果之后需要扩容，直接扩容为1.5倍
 */
@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {
        //无参构造器，默认为一个空的Objec数组 Object[] = {}
        List list = new ArrayList();
        //有参构造器，初始化为指定的容量
        List list1 = new ArrayList(15);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 10; i < 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);

    }
}
