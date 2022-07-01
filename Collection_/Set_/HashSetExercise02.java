package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author mingyu
 * @version 1.0
 * 定义一个员工类，包含name、sal、birthday，其中birthday使用MyDate类型（属性包括year、month、day）
 * 1、创建三个员工对象放入HashSet中
 * 2、当name和birthday相同时，认为是相同员工，不能添加到HashSet中
 */
public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee_("mybb", 1500, new MyDate("1999", "1", "31")));
        hashSet.add(new Employee_("hsp", 1500, new MyDate("1980", "6", "11")));
        hashSet.add(new Employee_("mybb", 1500, new MyDate("1999", "1", "31")));
        System.out.println("HashSet = "+ hashSet);
    }
}

class Employee_{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee_(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_ employee_ = (Employee_) o;
        //这里调用equals比较birthday时，根据动态绑定机制，使用的是MyDate的equals方法，所以MyDate的equals方法也需要重写
        //注意这里的细节，使用的是Objects，不是Object的equals方法，Objects.equals(Object a, Object b)方法会根据两个形参的Object.equals()方法判断
        return Objects.equals(name, employee_.name) && Objects.equals(birthday, employee_.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee_{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate extends Object{
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(year, myDate.year) && Objects.equals(month, myDate.month) && Objects.equals(day, myDate.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
