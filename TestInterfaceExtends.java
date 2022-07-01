package com.JavaStudy.HspMiddleJavaTest;
/**
 * 测试接口的多继承特性，注意Java中类只有单继承，接口可以多继承
 */
public class TestInterfaceExtends {

    public static void main(String[] args) {
        Test t = new Test();
        t.TestA();
        t.TestB();
        t.TestC();
    }
}

interface A{
    void TestA();
}

interface B{
    void TestB();
}

interface C extends A,B{    //接口的多继承

    @Override
    void TestA();

    @Override
    void TestB();

    void TestC();
}

class Test implements C{    //继承于C接口，但是也要实现A和B接口的特性
    public Test() {
        super();
    }

    @Override
    public void TestA() {
        System.out.println("Test.TestA");
    }

    @Override
    public void TestB() {
        System.out.println("Test.TestB");
    }

    @Override
    public void TestC() {
        System.out.println("Test.TestC");
    }
}