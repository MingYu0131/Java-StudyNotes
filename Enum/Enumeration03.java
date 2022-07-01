package com.JavaStudy.HspMiddleJavaTest.Enum;

/**
 * @author mingyu
 * @version 1.0
 * 枚举的两种实现方式：
 * 1) 自定义类实现枚举 2) 使用 enum 关键字实现枚举
 * 使用enum关键字实现枚举的细节，这个方式是主流
 * 使用enum关键字就不能继承其他的类了（因为隐式继承了Enum类），但是可以实现接口
 */
public class Enumeration03{
    public static void main(String[] args) {
        //与自定义类实现枚举一样的访问方式
        System.out.println(Season_2.SPRING);
        System.out.println(Season_2.TEST);
    }
}

//使用enum关键字代替class实现枚举类
//底层，这个类其实是默认继承Enum类，且使用final修饰 -> final class Season_2 extends java.lang.Enum
enum Season_2{
    //public static final Season SPRING = new Season("春天", "温暖") 其实等价于 SPRING("春天", "温暖") 解读： 常量名(实参列表)
    //如果有多个常量对象，使用,间隔即可，最后一个需要使用分号
    //使用enum关键字，要求枚举对象放在枚举类的第一行，不然会报错
    //如果我们使用无参构造器创建常量对象，可以省略()
    SPRING("春天","温暖"),WINTER("冬天","寒冷"),AUTUMN("秋天", "凉爽"), SUMMER("夏天", "炎热"),
    TEST;   //调用无参构造器可以省略括号

    private String name;
    private String desc;    //描述


//    public static final Season SPRING = new Season("春天", "温暖");
//    public static final Season WINTER = new Season("冬天", "寒冷");
//    public static final Season AUTUMN = new Season("秋天", "凉爽");
//    public static final Season SUMMER = new Season("夏天", "炎热");

    //将构造器私有化，防止直接外部new新对象
    private Season_2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //无参构造器
    Season_2() {
    }

    public String getName() {
        return name;
    }

    //去掉set方法，属性只能是只读的
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
