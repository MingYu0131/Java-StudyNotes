package com.JavaStudy.HspMiddleJavaTest.Reflection_.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author mingyu
 * @version 1.0
 * 内容：通过反射修改私有成员变量
 * 1、定义privateTest类，有私有name属性，并且属性值为hellokitty
 * 2、提供getName的公共方法
 * 3、创建PrivateTest类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName的方法打印name
 */
public class homework01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> privateClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.homework.PrivateClass");
        Object p = privateClass.newInstance();
        Field name = privateClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "mybb");
        System.out.println(name.get(p));
        Method getName = privateClass.getMethod("getName");
        System.out.println(getName.invoke(p));
    }
}

class PrivateClass{
    private String name = "helloKitty";
    public String getName(){
        return name;
    }
}
