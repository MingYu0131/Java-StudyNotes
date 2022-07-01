package com.JavaStudy.HspMiddleJavaTest.Generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mingyu
 * @version 1.0
 * 练习泛型与Junit的使用，见p739
 * 1、为什么需要Junit？
 *      （1）一个类有很多功能代码需要测试，为了测试，就需要写入到main中
 *      （2）如果有多个功能代码测试，就需要来回注销，切换很麻烦
 *      （3）如果可以直接运行一个方法，就方便很多，而且可以给出相关信息就好了 -> 引出JUnit
 * 2、JUnit是一个Java语言的单元测试框架
 * 3、多数的java IDE已经集成了JUnit作为单元测试工具
 */
public class GenericExercise03 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.m = new HashMap<>();
        userDAO.save("123456", new User(15,"123456", 21, "mybb"));
        System.out.println(userDAO.get("123456"));
        userDAO.update("123456", new User(10, "789456", 20, "ppi"));
        System.out.println(userDAO);
        System.out.println(userDAO.list());
        userDAO.delete("123456");
        System.out.println(userDAO);
    }
}

class DAO<T>{
    Map<String, T> m;

    public void save(String id, T entity){
        m.put(id, entity);
    }

    @Test
    public T get(String id){
        return m.get(id);
    }

    public void update(String id,T entity){
        m.put(id, entity);
    }

    public List<T> list(){
        List<T> l = new ArrayList<>();
        for (T o :m.values()) {
            l.add(o);
        }
        //或者
//        l.addAll(m.values());
        return l;
    }

    public void delete(String id){
        m.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "m=" + m +
                '}';
    }
}

class User{
    private int n;
    private String id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "n=" + n +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public User(int n, String id, int age, String name) {
        this.n = n;
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
