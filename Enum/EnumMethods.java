package com.JavaStudy.HspMiddleJavaTest.Enum;

/**
 * @author mingyu
 * @version 1.0
 * 演示Enum类的常用方法
 */
public class EnumMethods {
    public static void main(String[] args) {
        Season_3 autumn = Season_3.AUTUMN;
        //name()：返回枚举常量对象的名称
        System.out.println(autumn.name());
        //ordinal():返回该枚举常量在定义时的序号（从0开始）
        System.out.println(autumn.ordinal());
        //values()：返回改枚举对象的所有枚举常量（使用数组保存）
        Season_3[] season_3 = autumn.values();
        //使用增强for循环遍历返回的Season_3对象数组
        for (Season_3 s : season_3) {
            System.out.println(s);
        }
        //valueOf：将字符串转换成枚举对象，要求字符串必须 为已有的常量名，否则报异常！
        Season_3 autumn_ = Season_3.valueOf("AUTUMN");
        System.out.println("autumn_ = " + autumn_);
        System.out.println(autumn == autumn_);  //其实是一个对象

        //compareTo：比较两个枚举常量，比较的就是编号！
        System.out.println(autumn.compareTo(Season_3.SPRING));
    }
}

enum Season_3 {
    //创建枚举常量
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"), AUTUMN("秋天", "凉爽"), SUMMER("夏天", "炎热");
    private String name;
    private String desc;    //描述

    //将构造器私有化，防止直接外部new新对象
    private Season_3(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //无参构造器
    Season_3() {
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}