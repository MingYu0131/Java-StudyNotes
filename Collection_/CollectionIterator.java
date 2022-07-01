package com.JavaStudy.HspMiddleJavaTest.Collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author mingyu
 * @version 1.0
 * Iterator对象称为迭代器，是集合最底层实现的接口，所有的集合子类都有一个iterator（）方法，用于遍历集合中的元素
 * Iterator仅仅用于遍历集合，本身不存放对象
 * 测试增强for循环（底层也是iterator（）方法）
 */
public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("红楼梦", 15));
        col.add(new Book("金瓶梅", 50));
        col.add(new Book("Java学习手册", 25));

        //1、先的到col对应的Iterator迭代器
        Iterator it = col.iterator();
        //2. 使用 while 循环遍历
        while (it.hasNext()){   //hasNext方法，如果next指针还不为空，就返回true
            //返回下一个元素，类型是 Object
            Object o = it.next();
            System.out.println("元素为："+ o);
        }
        //老师教大家一个快捷键，快速生成 while => itit
        // 显示所有的快捷键的的快捷键 ctrl + j
        //3. 当退出 while 循环后 , 这时 iterator 迭代器，指向最后的元素
        //it.next();//NoSuchElementException
        // 4. 如果希望再次遍历，需要重置我们的迭代器
        it = col.iterator();
        System.out.println("第二次遍历");
        while (it.hasNext()) {
            Object o =  it.next();
            System.out.println("元素为："+ o);
        }
        
        //使用增强for循环遍历（底层也是调用的iterator（），可以通过debug查看）
        System.out.println("使用增强for循环遍历");
        for(Object o : col){
            System.out.println("元素为"+ o);
        }

        System.out.println("使用增强for遍历数组");
        int[] arrs = {1,2,3,4};
        for (int i : arrs) {
            System.out.println("数组元素为："+ i);
        }


    }
}
class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}