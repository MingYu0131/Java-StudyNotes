package com.JavaStudy.HspMiddleJavaTest.Collection_.List_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyu
 * @version 1.0
 * 添加10个以上的元素，在2号位插入一个元素“mybb”，获得第五个元素，删除第六个元素，修改第七个元素，最后使用迭代器遍历
 * 要求：使用List的实现类ArrayList完成
 */
public class ListExercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("new1");
        list.add("new2");
        list.add("new3");
        list.add("new4");
        list.add("new5");
        list.add("new6");
        list.add("new7");
        list.add("new8");
        list.add("new9");
        list.add("new10");
        list.add(2, "mybb");
        System.out.println(list.get(4));
        list.remove(5);
        list.set(6, "use set");
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
