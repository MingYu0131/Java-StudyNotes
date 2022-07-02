package com.JavaStudy.HspMiddleJavaTest.BasicJavaTest;

/**
 * 测试存在继承关系时类的执行顺序（静态代码块、静态属性初始化、普通代码块、普通属性初始化、构造方法）
 * 1、父类的静态代码块和静态属性初始化
 * 2、子类的静态代码块和静态属性初始化
 * 3、父类的普通代码块和普通属性初始化
 * 4、父类的构造方法
 * 5、子类的普通代码块和普通属性初始化
 * 6、子类的构造方法
 */
public class TestCodeBlock03 {
    public static void main(String[] args) {
        new BBB();
    }
}

class AAA{
    {
        System.out.println("AAA的非静态代码块被调用");    //5
    }

    private int n2 = getN2();   //非静态初始化

    public int getN2() {
        System.out.println("AAA的getN2被调用"); //6
        return 5;
    }

    private static int n1 = getN1();    //静态初始化，只能使用静态方法对静态变量初始化

    static {
        System.out.println("AAA的静态代码块被调用"); //2
    }

    public static int getN1() {
        System.out.println("AAA的getN1被调用"); //1
        return 10;
    }

    public AAA() {
        //注意！！！！！！！！！！在构造方法执行前会先执行以下两项
        //隐藏了super()
        //隐藏了普通代码块与普通属性初始化
        System.out.println("AAA的无参构造器被调用"); //7
    }
}

class BBB extends AAA{
    {
        System.out.println("BBB的非静态代码块被调用");    //8
    }

    private int n2 = getN2();   //非静态初始化

    public int getN2() {
        System.out.println("BBB的getN2被调用"); //9
        return 5;
    }

    private static int n1 = getN1();    //静态初始化，只能使用静态方法对静态变量初始化

    static {
        System.out.println("BBB的静态代码块被调用"); //4
    }

    public static int getN1() {
        System.out.println("BBB的getN1被调用"); //3
        return 10;
    }

    public BBB() {
        //注意！！！！！！！！！！在构造方法执行前会先执行以下两项
        //隐藏了super()
        //隐藏了普通代码块与普通属性初始化
        System.out.println("BBB的无参构造器被调用"); //10
    }
}