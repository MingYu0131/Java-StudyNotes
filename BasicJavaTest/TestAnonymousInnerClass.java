package com.JavaStudy.HspMiddleJavaTest.BasicJavaTest;

/**
 * 非常重要的一种内部类：匿名内部类
 * （1）本质是类（2）是一种内部类（3）没有名字（4）同时还是一个对象
 * 说明：匿名内部类定义在外部类的局部位置（方法内、代码块）并且没有类名
 * 语法：
 * new 类或接口(参数列表){
 * 类体
 * };  //注意
 */
public class TestAnonymousInnerClass {
    public static void main(String[] args) {
        new OuterClass().method();
    }
}

class OuterClass {   //外部类

    public void method() {
        //基于接口的匿名内部类
        //需求：想使用IA接口并创建对象，且Tiger和Dog类只使用一次，传统方法：新写一个类，并创建对象
        //可以使用匿名内部类来简化开发
        //Tiger的编译类型？IA
        //Tiger的运行类型？就是匿名内部类：Outer$1
        /**
         * 底层会自动为匿名内部类分配类名 OuterClass$1，等价于如下写法
         * class OuterClass$1 implements IA{
         *     @Override
         *             public void cry() {
         *                 System.out.println("老虎叫唤。。");
         *             }
         * }
         * jdk 底层在创建匿名内部类 OuterClass$1,立即马上就创建了 OuterClass$1 实例，并且把地址返回给了Tiger
         */
        //传统方法
        IA Tiger2 = new Tiger();
        Tiger2.cry();

        //匿名内部类使用了一次就不再使用
        IA Tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤。。");
            }
        };
        System.out.println("Tiger的运行时类：" + Tiger.getClass());
        Tiger.cry();


        //基于类的匿名内部类
        //fa的编译类型？ father
        //fa的运行类型？ OuterClass$2
        /**
         * 底层会自动为匿名内部类分配类名 OuterClass$2，等价于如下写法
         * class OuterClass$2 extends father{
         *     @Override
         *             public void test() {
         *                 System.out.println("匿名内部类重写了test()");
         *             }
         * }
         */
        //注意参数列表("Tom")会传给构造器
        father fa = new father("Tom") {
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test()");
            }
        };
        fa.test();
        System.out.println("fa的运行类型：" + fa.getClass());
        System.out.println("fa的name：" + fa.name);
    }
}

interface IA {
    void cry();
}

//传统方法如下
class Tiger implements IA {
    @Override
    public void cry() {
        System.out.println("老虎叫唤。。");
    }
}

class Dog implements IA {
    @Override
    public void cry() {
        System.out.println("小狗汪汪叫。。");
    }
}

class father {
    public String name;

    public father(String name) {
        this.name = name;
        System.out.println("接受到name = " + name);
    }

    public void test() {
    }
}