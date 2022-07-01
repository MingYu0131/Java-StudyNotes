package com.JavaStudy.HspMiddleJavaTest.Reflection_.Class_;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author mingyu
 * @version 1.0
 * 内容：反射机制是java成为动态语言的关键
 *      类加载的分类：1、静态加载
 *                  2、动态加载
 *      类加载的时机：1、当创建对象时（静态加载）
 *                  2、当子类被加载时，父类也被加载（静态加载）
 *                  3、调用类的静态成员（静态加载）
 *                  4、通过反射（动态加载）
 */
public class ClassLoad01 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        switch (key){
            case "1":
                //静态加载，依赖性很强
                //在编译阶段就会检查类加载是否出错，即使可能不会执行到这个语句
                //如果发现错误会直接报ERROR
                Dog dog = new Dog();
                dog.cry();
            case "2":
                //反射->动态加载，依赖性很弱
                //只有在执行到时才会判断是否可以加载成功类，不行就抛出异常
                Class<?> person = Class.forName("Person");
                Method hi = person.getMethod("hi");
                hi.invoke(person);
        }
    }
}

class Dog{
    public void cry(){}
}
