package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author mingyu
 * @version 1.0
 * 定义一个Employee类，该类包含name和age，要求：
 * 1、创建3个Employee对象放入HashSet中
 * 2、当name和age的值相同时，认为是相同员工，不能添加到HashSet集合中
 */
public class HashSetExercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("mybb", 15));
        hashSet.add(new Employee("jj", 18));
        hashSet.add(new Employee("mybb", 15));
    }
}

class Employee extends Object{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
