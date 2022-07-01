package com.JavaStudy.HspMiddleJavaTest.Collection_;

/**
 * @author mingyu
 * @version 1.0
 * 开发中应该如何选择集合实现类
 * 1、先判断存储的数据类型（一组对象（单列）或是一组键值对（双列））
 * 2、一组对象（单列）：实现了Collection接口
 *      允许重复：List
 *          增删多：LinkedList【底层维护了一个双向链表，修改数据效率高，查询效率低】
 *          改查多：ArrayList【底层维护了Object类型的可变数组，增删需要修改容量然后移动，效率低】
 *      不允许重复：Set
 *          无序：HashSet【底层是HashMap，维护了一个哈希表，即（数组+链表+红黑树）】
 *          排序：TreeSet【底层是红黑树，实现了Comparator接口，可以根据需要对数据排序】
 *          插入顺序和取出顺序要求一致：LinkedHashSet【底层是LinkedHashMap，维护数组+双向链表】
 * 3、一组键值对（双列）：Map（Map都是不允许Key重复只允许Value重复）
 *      键无序：HashMap【底层是哈希表，jak7：数组+链表 jdk8：数组+链表+红黑树】
 *      键排序：TreeMap【底层是红黑树】
 *      键插入和取出顺序一致：LinkedHashMap【底层维护数组+双向链表】
 *      读取文件：Properties【底层继承自Hashtable】
 * 4、线程安全的两个常用类：Vector（对应ArrayList）、Hashtable（对应HashMap）
 */
public class HowToChooseCollection {
}
