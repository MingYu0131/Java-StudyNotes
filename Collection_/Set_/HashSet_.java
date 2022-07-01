package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.HashSet;

/**
 * @author mingyu
 * @version 1.0
 * （1）HashSet实现了Set接口
 * （2）HashSet实际上底层是HashMap
 * （3）可以存放null，但是只能有一个（Set不重复）
 */
public class HashSet_ {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("mybb");
        hashSet.add("mybb");//加入不了，重复了
        hashSet.add(new Dog("Tom"));
        hashSet.add(new Dog("Tom"));    //因为是两个不同的对象，可以重复

        //看一个有意思的现象，String特殊的存储机制，导致不能重复存放
        hashSet.add(new String("my"));
        hashSet.add(new String("my"));  //不能重复存放

    }
}

class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
