package com.JavaStudy.HspMiddleJavaTest.Collection_.Exercise;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author mingyu
 * @version 1.0
 * 题目详情查看p696
 */
public class CollectionsExercise02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Car("宝马", 4000000));
        arrayList.add(new Car("宾利", 50000000));

        System.out.println(arrayList.size());

        for (Object o :arrayList) {
            System.out.println(o);
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);

        }


    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
