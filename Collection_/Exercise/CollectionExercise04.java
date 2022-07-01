package com.JavaStudy.HspMiddleJavaTest.Collection_.Exercise;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author mingyu
 * @version 1.0
 */
public class CollectionExercise04 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        hashSet.add(p1);
        hashSet.add(p2);
        p1.name = "CC";
        hashSet.remove(p1);
        System.out.println(hashSet);    //输出什么？
        hashSet.add(new Person(1001, "CC"));
        System.out.println(hashSet);//输出什么？
        hashSet.add(new Person(1001, "AA"));
        System.out.println(hashSet);//输出什么？

        /*
            这题主要考察对remove和hashset底层存储机制的理解
            1、在更改p1.name后，p1的hash值就改变了，但是p1在table中存储的index已经在add时就确定了
            2、然后remove操作，其实是根据hash值来删除的，此时他根据p1现在的hash值会找到一个空的index
              （因为Person重写了hashcode方法，不一样的id和name，hashcode一定不一样） ，因此remove会失败
            3、然后hashSet.add(new Person(1001, "CC"));此时插入的元素，计算hash值得到index会发现没有元素占用，因此会直接add成功
            4、hashSet.add(new Person(1001, "AA"));此时add新元素，会得到和p1存储位置相同得index，然后在putVal方法里面，
               检测该元素是否和p1重复（使用equals方法），会发现不重复，然后挂载到p1后面，这个add也会成功
            5、这个案例告诉我们类字段应该尽量设置为私有，用户随意操作可能会导致bug的发生
         */
    }
}

class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}