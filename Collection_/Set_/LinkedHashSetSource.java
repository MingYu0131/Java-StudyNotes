package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.LinkedHashSet;

/**
 * @author mingyu
 * @version 1.0
 * 查看LinkedHashSet的add源码
 * 1、在LinkedHashSet中维护了一个hash表和双向链表（属性有head和tail）
 * 2、每一个节点有before和after属性，形成双向链表
 * 3、在add元素时，先求hash值，再求索引，再确定在table中的位置，查看是否有重复（底层和HashSet一样）
 * 4、LinkedHashSet底层是LinkedHashMap，使用的方法还是HashMap中实现的put、putVal方法
 * 5、LinkedHashSet底层的table是HashMap$Node 是Node类型的内部类数组，而table的元素是LinkedHashMap$Entry静态内部类类型，
 *   可以得知Entry是LinkedHashMap实现的Node内部类的子类
 */
public class LinkedHashSetSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new String("mybb"));
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add(new Cost("yy"));
        linkedHashSet.add(123);
        System.out.println(linkedHashSet);
    }
}
class Cost{
    String name;

    public Cost(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "name='" + name + '\'' +
                '}';
    }

}
