package com.JavaStudy.HspMiddleJavaTest.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyu
 * @version 1.0
 */
public class GenericDetails {
    public static void main(String[] args) {
        //1、给泛型指定数据类型时，只能指定引用数据类型
        ArrayList<Integer> integers = new ArrayList<Integer>();
//        ArrayList<int> ints = new ArrayList<int>(); //使用基本数据类型会报错

        //2、给泛型指定类型时，可以传入类对象或者其子类对象
        pig<A> aPig = new pig<A>(new A());
        pig<A> bPig = new pig<A>(new B());  //不会报错，其实发生了一次向上转型

        //3、泛型使用形式有两种
        //第一种，普通方法
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>(); //使用父类接口接收也可以
        //第二种：简写方法，推荐使用这种
        ArrayList<Integer> list3 = new ArrayList<>();   //这里编译器会自动推断泛型的类型，构造器也会传入定义的泛型
        List<Integer> list4 = new ArrayList<>();

        //4、泛型也有默认值，默认是Object
        ArrayList arrayList = new ArrayList();  //等价于如下
        ArrayList<Object> arrayList2 = new ArrayList<Object>();

        //5、使用泛型的数组，不能初始化，因为系统无法
    }
}
class A{}
class B extends A{}
class pig<E>{
    E e;

    public pig(E e) {
        this.e = e;
    }

    //5、使用泛型的数组，不能初始化，因为系统无法在编译时确定E的类型并分配空间
//    E[] es = new E[10];

    //静态方法和变量中不能使用泛型，因为静态方法在类加载时就可能调用了，但是此时对象可能还没初始化，泛型还没确定
//    public static void test<E>{};
//    private static E testE;   //静态变量也不行
}
