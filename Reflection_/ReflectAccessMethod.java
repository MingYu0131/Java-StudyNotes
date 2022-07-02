package com.JavaStudy.HspMiddleJavaTest.Reflection_;

import java.lang.reflect.Method;

/**
 * @author mingyu
 * @version 1.0
 * 内容：测试反射操作方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.Student");
        Object student = studentClass.newInstance();
        //1、获取public方法
        Method hi = studentClass.getMethod("hi");
        hi.invoke(student);
        //2、调用private static方法
        Method staticHi = studentClass.getDeclaredMethod("hi", String.class, int.class);
        //反射暴破
        staticHi.setAccessible(true);
        staticHi.invoke(student, "hi!", 15);
        //因为是静态方法，目标实例可以填null
        //3、 在反射中，如果方法有返回值，统一返回 Object , 但是他运行类型和方法定义的返回类型一致
        Object invoke = staticHi.invoke(null, "hi!", 20);
        System.out.println(invoke);
    }
}
