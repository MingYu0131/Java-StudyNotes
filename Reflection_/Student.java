package com.JavaStudy.HspMiddleJavaTest.Reflection_;

/**
 * @author mingyu
 * @version 1.0
 */
public class Student {
    private String name;
    public int age;
    public String hobby;

    public Student(String name) {
        this.name = name;
    }

    public Student(){}

    public void hi(){
        System.out.println("hello!");
    }
}
