package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.HashSet;

/**
 * @author mingyu
 * @version 1.0
 * Collection接口底下的子接口Set，代表一类无序集合
 * （1）无序（添加和取出的顺序不一致），没有索引（index）（但是可以使用迭代器遍历）
 * （2）不允许重复元素
 * （3）底下常用的两种集合HashSet和TreeSet
 */
public class SetMethods {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("mybb");
        hashSet.add("asd");
        hashSet.add("mybb");    //重复元素不显示
        System.out.println(hashSet);

        //虽然没有索引但是可以使用迭代器遍历
        for (Object o :hashSet) {
            System.out.println(o);
        }

    }
}
