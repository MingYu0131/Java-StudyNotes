package com.JavaStudy.HspMiddleJavaTest.Collection_;

import java.util.*;

/**
 * @author mingyu
 * @version 1.0
 * Collections是一个操作Set、list和Map等集合的工具类
 * 提供了一系列的静态方法对集合元素进行排序、查询和修改等操作
 */
@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Tom");
        arrayList.add("Marry");
        arrayList.add("JoJo");
        arrayList.add("Rick");
        HashSet hashSet = new HashSet();
        //1、reverse(List) 反转List集合中元素的顺序(只能对List使用)
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        //2、shuffle(List) 对List集合中的元素进行随机排序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        //3、sort(List) 根据元素的自然顺序对指定List集合元素按升序排序
        Collections.sort(arrayList);
        System.out.println(arrayList);

        //4、sort(List, Comparator)根据指定的Comparator对List进行排序
        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println(arrayList);

        //5、swap(List, int, int) 将指定List集合中的i元素和j元素进行互换
        Collections.swap(arrayList, 0, 1);
        System.out.println(arrayList);

        //6、Object max(Collections):根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println(Collections.max(arrayList));

        //7、Object max(Collections, Comparator):根据比较器指定的顺序，返回给定集合中的最大元素
        System.out.println("集合中最长的元素"+Collections.max(arrayList, new Comparator() {
            //这里可以加入异常检测，传入的必须是字符串元素
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    //字符串长度升序
                    return ((String)o1).length() - ((String)o2).length();
                }
                else{
                    throw new RuntimeException("需要传入的是字符串");
                }
            }
        }));

        //8、Object min(Collection, Comparator) 和max一样，不赘述

        //9、int frequency(Collection, Object) 返回指定集合中指定元素出现次数
        System.out.println("Tom的出现次数："+Collections.frequency(arrayList, "Tom"));

        //10、void copy(List dest,List src) 将src中的内容复制到dest中,需要dest存有size大于等于src.size的元素
        //注意集合中length和size的区别，length基本代表cap（容量），size代表集合中实际存在的元素个数
        Collections.copy(new ArrayList(10), arrayList); //会抛出数组越界异常

        //11、boolean replaceAll(List list, Object odlVal, Object newVal) 使用新值替换List对象的所有旧值
    }
}
