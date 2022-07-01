package com.JavaStudy.HspMiddleJavaTest.Enum;

/**
 * 引出枚举类
 * 1) 枚举对应英文(enumeration, 简写 enum)
 * 2) 枚举是一组常量的集合。
 * 3) 可以这里理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象。
 */
public class Enumeration01 {
    public static void main(String[] args) {
        //需求：季节只有春夏秋冬，不允许再创建别的对象
        Season Spring = new Season("Spring", "温暖");
        Season Summer = new Season("Summer", "炎热");
        Season Autumn = new Season("Autumn", "凉爽");
        Season Winter = new Season("Winter", "寒冷");

        //如下的操作是不合理的，因为只有四个季节
        //按传统的类的设计思路，不能体现出季节是固定的四个对象，因此这样设计不好 -->  引出枚举类，枚举属于一种特殊的类，里面只包含一组有限的特定的对象。
        Season other = new Season("other","未知");
        //只读，不需要修改。这样的操作也是不合理的，可以通过枚举类来优化
        Spring.setDesc("寒冷");

    }
}

class Season{
    private String name;
    private String desc;    //描述

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
