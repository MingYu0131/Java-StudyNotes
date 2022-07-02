package com.JavaStudy.HspMiddleJavaTest.Reflection_;

/**
 * @author mingyu
 * @version 1.0
 */
public class Student {
    private String name;
    public int age;
    public String hobby;
    private static int level = 99;

    public Student(String name) {
        this.name = name;
    }

    private Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Student(){}

    public void hi(){
        System.out.println("hello!");
    }

    private static String hi(String s, int a){
        s = s + a + " hi!";
        System.out.println(s);
        return s;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
