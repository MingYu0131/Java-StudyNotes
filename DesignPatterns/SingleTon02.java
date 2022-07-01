package com.JavaStudy.HspMiddleJavaTest.DesignPatterns;

/**
 * 设计模式之单例模式-饱汉模式
 * 构建饱汉模式的步骤如下：
 * 1、构造器私有化
 * 2、定义一个静态属性对象（但是不new对象，这是饱汉和饿汉的区别,即创建对象的时机不同）
 * 3、提供一个公共的静态方法用于返回对象
 */
public class SingleTon02 {
    public static void main(String[] args) {
        Cat cat = Cat.getCat();
        System.out.println(cat);
    }
}

//需求：只能有一个猫对象（单例）
class Cat{
    private String name;

    //定义一个静态属性对象，但是不new对象
    private static Cat cat;

    //将构造器私有化
    private Cat(String name) {
        this.name = name;
    }

    //定义一个静态方法用于返回对象，注意只有在需要时才会调用方法创建对象，这样不会浪费资源但是会有线程安全问题（即同时有多个线程使用这个方法，可能会创建多个对象）
    public static Cat getCat(){
        if(cat == null){
            cat = new Cat("Tom");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
