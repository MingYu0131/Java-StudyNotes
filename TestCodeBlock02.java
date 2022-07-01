package com.JavaStudy.HspMiddleJavaTest;

/**
 * 测试创建一个对象时，一个类中的调用顺序，顺序依次如下：
 * 1、调用静态代码块和静态属性初始化（注意：他们两个的优先级一样，若有多个静态代码块和静态属性初始化，按他们在java文件中定义的顺序调用）
 * 2、调用普通代码块和普通属性初始化（具体顺序和上述一样）
 * 3、调用构造方法
 */
public class TestCodeBlock02 {
    public static void main(String[] args) {
        new T();

    }
}

class T {

    {
        System.out.println("T的非静态代码块被调用");
    }

    private int n2 = getN2();   //非静态初始化

    public int getN2() {
        System.out.println("getN2被调用");
        return 5;
    }

    private static int n1 = getN1();    //静态初始化，只能使用静态方法对静态变量初始化

    static {
        System.out.println("T的静态代码块被调用");
    }

    public static int getN1() {
        System.out.println("getN1被调用");
        return 10;
    }

    public T() {
        //注意！！！！！！！！！！在构造方法执行前会先执行以下两项
        //隐藏了super()
        //隐藏了普通代码块与普通属性初始化
        System.out.println("T的无参构造器被调用");
    }
}
