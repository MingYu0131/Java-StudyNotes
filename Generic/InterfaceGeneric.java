package com.JavaStudy.HspMiddleJavaTest.Generic;

/**
 * @author mingyu
 * @version 1.0
 * 演示自定义接口泛型与注意事项
 * 1、接口中，静态成员也不能使用泛型
 * 2、泛型接口的类型，在实现接口和继承接口时实现
 * 3、没有指定类型默认是Object
 */
public class InterfaceGeneric {
}

//也可以直接implements接口定义泛型
class T0 implements IUsb<Double,Boolean>{

    @Override
    public Boolean get(Double aDouble) {
        return null;
    }
    @Override
    public void hi(Boolean aBoolean) {
    }
    @Override
    public void run(Boolean r1, Boolean r2, Double u1, Double u2) {
    }
}

//类实现会根据接口继承时指定的泛型决定泛型类型
class T1 implements IEx{

    @Override
    public Integer get(String s) {
        return null;
    }
    @Override
    public void hi(Integer integer) {
    }
    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {
    }
}

//在接口继承中实现泛型
interface IEx extends IUsb<String, Integer>{}

interface IUsb<U,R>{
    int n = 10;
    //注意：接口的属性不能使用泛型，因为接口默认是final static修饰的，静态常量在类加载时已经确定，不能使用泛型
//    U name;

    //普通方法中可以使用泛型
    R get(U u);

    void hi (R r);

    void run(R r1, R r2, U u1, U u2);

    //jdk8中，可以在接口中使用默认方法，也是可以使用泛型
    default R methodR(U u){return null;}
}