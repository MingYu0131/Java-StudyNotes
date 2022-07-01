package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

/**
 * @author mingyu
 * @version 1.0
 * 简要介绍LinkedHashSet
 * 1、LinkedHashSet是HashSet的子类
 * 2、LinkedHashSet底层是一个LinkedHashMap，底层维护了一个数组+双向链表（注意HashMap是数组+单向链表的线性链表）
 * 3、LinkedHashSet根据元素的hashCode值来决定元素插入的数组index，同时使用双向链表维护元素的次序，使得取出和添加的顺序是一致的，这是它最大的特点
 * 4、LinkedHashSet不允许添加重复元素
 */
public class LinkedHashSet_ {
    public static void main(String[] args) {

    }
}
