package com.JavaStudy.HspMiddleJavaTest.Collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyu
 * @version 1.0
 * 测试Collection接口提供的方法
 *  (1)Collection实现子类可以存放多个元素，每个元素可以是任意种类对象
 * （2）Collection接口没有直接实现的子类，是通过它的子接口Set和List来实现的
 */
public class CollectionMethods {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        //add 添加单个元素
        list.add("jack");
        list.add(10);   //发生了自动装箱，其实是list.add(new Integer(10))，因为10是基本数据类型int
        list.add(true); //也发生了自动装箱
        System.out.println("list= " + list);
        //remove 删除指定元素
        list.remove(0);//按index删除
        list.remove(true);//按元素删除
        //contains 查找元素是否存在
        System.out.println(list.contains(10));
        //size 返回元素个数
        System.out.println(list.size());
        //isEmpty 判断是否为空
        System.out.println(list.isEmpty());
        //clear 清空集合
        list.clear();
        System.out.println(list);
        //addAll 添加多个元素
        List list1 = new ArrayList();
        list1.add("红楼梦");
        list1.add("金瓶梅");
        list.addAll(list1); //形参也是一个集合
        //containsAll 查找多个元素是否存在
        //removeAll 删除多个元素

    }
}
