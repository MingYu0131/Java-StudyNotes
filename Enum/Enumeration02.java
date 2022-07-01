package com.JavaStudy.HspMiddleJavaTest.Enum;

/**
 * @author mingyu
 * @version 1.0
 * 枚举的两种实现方式：
 * 1) 自定义类实现枚举 2) 使用 enum 关键字实现枚举
 * 自定义类实现枚举的细节
 *  （1）不需要提供set方法，因此枚举对象值通常为只读
 *  （2）对枚举类的对象和属性都使用final+static修饰，实现底层优化
 *  （3）枚举对象名通常使用全部大写，这是常量的命名规范
 *  （4）枚举对象根据需要，也可以有多个属性
 *  小结：
 *      1) 构造器私有化
 *      2) 本类内部创建一组对象[四个 春夏秋冬]
 *      3) 对外暴露对象（通过为对象添加 public final static 修饰符）
 *      4) 可以提供 get 方法，但是不要提供 set
 */
public class Enumeration02 {
    public static void main(String[] args) {
        //枚举类的对象是静态的，可以直接通过类名调用
        System.out.println(Season_.AUTUMN);
    }
}

//演示普通类修改为枚举类的步骤
class Season_{
    private String name;
    private String desc;    //描述

    //3、在 Season 内部，直接创建固定的对象，优化，static+final 修饰符
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season SUMMER = new Season("夏天", "炎热");

    //1、将构造器私有化，防止直接外部new新对象
    private Season_(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    //2、去掉set方法，属性只能是只读的
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDesc() {
        return desc;
    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
