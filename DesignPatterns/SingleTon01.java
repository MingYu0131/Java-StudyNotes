package com.JavaStudy.HspMiddleJavaTest.DesignPatterns;

/**
 * java设计模式之单例模式-饿汉模式
 * 构建饿汉单例模式步骤如下：
 * 1、构造器私有化 -> 防止被直接new
 * 2、类的内部创建对象
 * 3、向外暴露一个静态的公共方法用来创建对象
 * 饿汉模式可以满足一个需求：只允许该类拥有一个对象
 */
public class SingleTon01 {
    public static void main(String[] args) {
        girlfriend gf = girlfriend.getGf();
        System.out.println(gf);
    }
}

//规定只能有一个女朋友对象
class girlfriend{

    private String name;

    //类的内部创建对象，注意是饿汉模式，很急，在类加载时就new了对象，可能会造成资源的浪费（创建了对象但是没有使用）
    private static girlfriend gf = new girlfriend("小王");

    //构造器私有化
    private girlfriend(String name) {
        this.name = name;
    }

    //静态方法用来获取对象
    public static girlfriend getGf(){
        return gf;
    }

    @Override
    public String toString() {
        return "girlfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}