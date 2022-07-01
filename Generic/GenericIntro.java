package com.JavaStudy.HspMiddleJavaTest.Generic;

/**
 * @author mingyu
 * @version 1.0
 * 对泛型的说明
 * 泛型的好处：1、编译时，检测添加元素的类型，增加了安全性 2、减少了类型转换的次数（例如在增强for循环中），提高了效率
 * 泛型的理解：泛（广泛）型（类型）,和变量类似，变量接受的是数据，泛型接受的是数据类型
 *      1、泛型又称为参数化类型，是jdk5出现的新特性，解决数据类型的安全性问题
 *      2、在类声明或实例化时只要指定好需要的具体类型即可
 *      3、Java泛型可以保证如果在编译时没有发出警告，运行时就不会产生ClassCastException异常，同时代码更加简洁健壮
 *      4、泛型的具体作用是：可以在类声明时通过一个标识表示类中某个属性的类型，或者是某个方法的返回值类型，或者是参数类型（具体看下面举例子）
 */
public class GenericIntro {
    public static void main(String[] args) {
        //注意，特别强调： E 具体的数据类型在定义 Person 对象的时候指定,即在编译期间，就确定 E 是什么类型
        Person<String> mybb = new Person<String>("mybb");
        System.out.println(mybb.getName());
    }
}

class Person<E>{
    private E name; //使用泛型指定属性类型

    public Person(E name) { //使用泛型指定参数类型
        this.name = name;
    }

    public E getName() {    //返回类型使用泛型
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
