package com.JavaStudy.HspMiddleJavaTest.Reflection_.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author mingyu
 * @version 1.0
 * 内容1、利用Class类的forName得到File的Class对象
 * 2、在控制台打印File类的所有构造器
 * 3、通过newInstance创建File对象，并创建E:\mynew.txt文件
 */
public class homework02 {
    public static void main(String[] args) throws Exception {
        Class<?> fileClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor<?> constructor = fileClass.getConstructor(String.class);
        Object o = constructor.newInstance("E:\\mynew.txt");
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}
