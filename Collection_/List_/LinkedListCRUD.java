package com.JavaStudy.HspMiddleJavaTest.Collection_.List_;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author mingyu
 * @version 1.0
 * LinkedList是List接口底下的类，主要实现以双向链表和双向队列存储的集合
 * （1）可以添加任意元素（可以重复），包括null
 * （2）线程不安全，没有使用同步
 * （3）维护了属性first，last指向首节点和尾节点，size表示存储的元素个数，modCount表示修改次数
 * （4）每个节点（node对象，本质是内部类），里面又维护了prev、next、item三个属性
 * 演示增删改查
 */
@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {
        //通过debug追源码来了解add（）的过程与创建node的过程
        LinkedList linkedList = new LinkedList();
        //增加
        linkedList.add("mybb");
        linkedList.add("bb");
        linkedList.add("123");
        System.out.println("LinkedList:"+ linkedList);

        //删除
//        linkedList.remove();//默认是删除首节点
//        linkedList.remove("bb");//删除特定item节点
//        linkedList.remove(0);//根据index删除

        //修改某个节点
        linkedList.set(0, "hmy");
        System.out.println("LinkedList:"+ linkedList);
        //得到某个节点
        System.out.println(linkedList.get(2));

        //因为LinedList是实现了List的类，所以也有迭代器
        for (Object o :linkedList) {
            System.out.println(o);
        }
        System.out.println("===LinkeList 遍历迭代器====");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("next=" + next);
        }


    }
}
