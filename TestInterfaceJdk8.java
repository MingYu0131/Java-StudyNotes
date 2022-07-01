package com.JavaStudy.HspMiddleJavaTest;

/**
 * 测试JDK8新增的接口特性：接口中定义静态方法和默认方法(JDK8 以后)
 */
public class TestInterfaceJdk8 {
    public static void main(String[] args) {
        bigInterface b = new bigInterface();
        b.make();
        b.defaultMethod();  //即使没实现这个方法，但是接口中默认实现了，也可以调用

        InterfaceTest.staticMethod();   //调用接口的静态方法
    }
}

interface InterfaceTest{
    void make();

    default void defaultMethod(){   //接口中的默认方法：规范方法，建议使用，不用也可以
        System.out.println("InterfaceTest.defaultMethod");
        System.out.println("这是接口中的默认方法！");
        staticMethod(); //在默认方法中可以调用静态方法，因为静态方法是属于类（接口）的
    }

    static void staticMethod(){
        System.out.println("InterfaceTest.staticMethod");
        System.out.println("这是接口中的静态方法！");
//        defaultMethod();    //在静态方法中无法调用默认方法，因为方法是属于对象的
    }
}

class bigInterface implements InterfaceTest{
    @Override
    public void make() {
        System.out.println("I am making");
    }
}
