package com.JavaStudy.HspMiddleJavaTest.IOStream_.ObjectStream;

import java.io.Serializable;

/**
 * @author mingyu
 * @version 1.0
 */
//实现Serializable接口，可以序列化，注意该接口只是一种标识，实际没有内容
public class Dog_ implements Serializable {
    String name;
    int age;
    //序列化的版本号，如果以后该类有修改，会根据该版本号识别到只是这个类进行了升级而不是一个全新的类
    private static final Long serialVersionUID = 1L;

    public Dog_(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog_{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
