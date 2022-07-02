package com.JavaStudy.HspMiddleJavaTest.Reflection_;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author mingyu
 * @version 1.0
 * 内容：介绍获取Class对象类信息的常用方法
 */
public class ReflectionClass_02 {
    @Test
    public void api_01() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.person");
        //1、getName获取全类名
        String fullName = personClass.getName();
        System.out.println(fullName);
        //2、getSimpleName获取简单类名
        String simpleName = personClass.getSimpleName();
        System.out.println(simpleName);
        //3、getFields获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println("Person的public属性：" + field);
        }
        //4、getDeclared获取本类所有的声明属性，不包括父类
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("Person的全部属性：" + declaredField.getName() );
        }
        //5、getMethods获取所有public修饰的方法，包含本类以及父类
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("person和其父类的public方法" + method);
        }
        //6、getDeclaredMethods获取所有方法，不包含父类
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("person的全部方法：" + declaredMethod);
        }
        //7、getConstructors获取本类的所有public修饰的构造器
        //8、getDeclaredConstructors获取本类的所有构造器
        //9、getSuperClass以Class信息返回父类信息
        Class<?> superclass = personClass.getSuperclass();
        System.out.println(superclass.getName());
        //10、getInterfaces以Class[]形式返回接口信息
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("Person实现的接口：" + anInterface);
        }
        //11、getAnnotations以Annotation[]形式返回注解信息
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Person的注解：" + annotation);
        }
    }

    @Test
    public void api_02() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.person");
        //getDeclared获取本类所有的声明属性，不包括父类
        //getModifiers():返回int类型的字段的访问修饰符，规定：默认是0，public是1，protected是4，static是8，final是16，如果组合就是缝合
        //getType():返回属性的类型
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("Person的全部属性：" + declaredField.getName() + " 修饰符：" + declaredField.getModifiers() +
            " 类型为：" + declaredField.getType());
        }
        //getMethods获取所有public修饰的方法，包含本类以及父类
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("person和其父类的public方法:" + method.getName() + " 修饰符：" + method.getModifiers() +
                    " 返回值类型：" + method.getReturnType().getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("形参列表：" + parameterType.getName());
            }
        }
    }

}

interface A {
}

interface B {
}

@SuppressWarnings({"all"})
class person implements A, B {
    public int age;
    protected String name;
    double salary;
    private int sex;

    @Deprecated
    public void m1(String s, int w, double salary) {
    }

    protected String m2() {
        return null;
    }

    void m3() {
    }

    private void m4() {
    }

}
