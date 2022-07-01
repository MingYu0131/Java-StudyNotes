package com.JavaStudy.HspMiddleJavaTest.Generic;

import java.util.ArrayList;

/**
 * @author mingyu
 * @version 1.0
 * 方法也可以有泛型
 * 1、方法泛型可以出现在普通方法中，也可以出现在使用了泛型的方法中
 * 2、当泛型方法被调用时，类型一定会被确定（由给定的参数指定）
 * 3、注意区分方法使用了类定义的泛型和泛型方法
 */
public class MethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("mybb", 100);   //注意这里100会发生自动装箱int->Integer，因为泛型类型只能是引用类型

        Fish<ArrayList, String> stringArrayListFish = new Fish<>();
        //分别使用了类的泛型和方法泛型的方法
        stringArrayListFish.hello(new ArrayList(), 11.2f);  //自动装箱
    }
}

//泛型方法，可以定义在普通类中，也可以定义在泛型类中
class Car{//普通类
    public void run(){  //普通方法
        return;
    }

    public <E,T> void fly(E e, T t){  //泛型方法，只提供给fly使用
        System.out.println(e.getClass());
        System.out.println(t.getClass());
    }
}

class Fish<R,T>{    //泛型类

    public <U,M> void eat(){    //泛型方法

    }

    //1、下面的hi方法不是泛型方法，只是使用了类的泛型
    public void hi(T t){

    }

    //泛型方法也可以使用类泛型
    public <K> void hello(R r, K k){
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }

}