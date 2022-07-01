package com.JavaStudy.HspMiddleJavaTest.Generic;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyu
 * @version 1.0
 * 1、泛型不具备继承性
 *      List<Object> list = new ArrayList<String>();    //不对，即使String是Object的子类，泛型没有继承
 * 2、泛型的通配符：多用于使用了泛型参数的方法的形参中，用于约束泛型的类型范围
 * 3、<?> : 表示泛型支持任意类型
 * 4、<? extends A> : 表示支持A类以及A的子类，即规定了泛型的上限
 * 5、<? super A> : 支持A类以及A类的父类，不限于直接父类，规定了泛型的下限
 */
public class GenericExtends {
    public static void main(String[] args) {
        //允许，向上转型
        Object o = new String("s");
        //不允许，泛型没有继承
//        List<Object> l = new ArrayList<String>();

        List<Object> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<AA> l3 = new ArrayList<>();
        List<BB> l4 = new ArrayList<>();
        List<CC> l5 = new ArrayList<>();

        //print1(List<?> l) 表示List的泛型可以接受任意类型
        print1(l1);
        print1(l2);
        print1(l3);
        print1(l4);
        print1(l5);

        //print2(List<? extends AA> l) 表示List的泛型可以接受AA以及AA的子类，上限
        //print2(l1); //Object不是AA子类，不能接受
        //print2(l2); //String不是AA子类，不能接受
        print2(l3);
        print2(l4);
        print2(l5);

        //print3(List<? super AA> l) 表示List泛型可以接受AA以及AA的父类，表示了下限
        print3(l1);
        //print3(l2); //String不是AA的父类
        print3(l3);
        //print3(l4);//BB是AA的子类不是父类
        //print3(l5);//CC也是AA的子类
    }

    //说明: List<?> 表示 任意的泛型类型都可以接受
    public static void print1(List<?> l){
        for (Object o :l) {
            System.out.println(o);
        }
    }

    //? extends AA 表示 上限，可以接受 AA 或者 AA 子类
    public static void print2(List<? extends AA> l){
        for (Object o :l) {
            System.out.println(o);
        }
    }

    // ? super 子类类名 AA:支持 AA 类以及 AA 类的父类，不限于直接父类，规定了泛型的下限
    public static void print3(List<? super AA> l){
        for (Object o :l) {
            System.out.println(o);
        }
    }
}

class AA{}
class BB extends AA{}
class CC extends BB{}
