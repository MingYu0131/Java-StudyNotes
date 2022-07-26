package com.JavaStudy.HspMiddleJavaTest.BasicJavaTest;

import org.junit.jupiter.api.Test;

/**
 * 测试代码块的用法，代码块分为静态代码块和非静态代码块
 * 1、代码块又称为初始化块，是类的一部分，类似于方法，但是没有方法名、返回值、参数，只在加载类或创建对象时隐式调用
 * 2、类什么时候会加载（重要！！）
 *  （1）创建对象实例时（new一个对象时）
 *  （2）创建子类对象实例时，父类也会被加载（先有父亲才有儿子）
 *  （3）调用该类的静态成员（静态属性，静态方法）时（静态成员在使用时必须先加载类类信息，因为其位于堆中的class对象中（较新的JDk是如此））
 * 3、静态代码块只会在类被加载时调用一次
 * 4、非静态代码块在创建对象时被隐式调用，每创建一个对象就调用一次，可以简单理解非静态代码块相当于构造器的一个补充
 * 5、一个非静态代码块的使用场景：重载的构造器里有冗余的代码，可以抽出来放在非静态代码块中
 * 6、非静态代码块总是在构造器之前执行
 */
public class TestCodeBlock01{
    public static void main(String[] args) {
        //非静态代码块在对象被创建一次时就调用一次
        new BB();
        System.out.println("======分割========");
        new AA();   //因为AA和BB类已经加载，静态代码块不会再调用了

        System.out.println("======分割========");
        //如果上面的代码注释了，以下两句分别对应（1）调用静态成员时静态代码块被调用的情况
        // （2）调用子类的静态成员，父类的静态代码块和子类的静态代码块会先后调用
        System.out.println(AA.An);
        System.out.println(BB.Bn);


    }
}

class AA{
    static int An = 4;
    {
        System.out.println("AA 的非静态代码块被调用！");
    }
    static {
        System.out.println("AA 的static代码块被调用！");
    }
}

class BB extends AA{
    static int Bn = 5;
    {
        System.out.println("BB 的非静态代码块被调用！");
    }
    static {
        System.out.println("BB 的static代码块被调用！");
    }
}
