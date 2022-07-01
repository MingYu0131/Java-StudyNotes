package com.JavaStudy.HspMiddleJavaTest.Generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author mingyu
 * @version 1.0
 * 定义Emp类
 * 1、包含私有属性name、sal、birth，其中birth为MyDate类对象
 * 2、MyDate包含年月日
 * 3、创建该类的三个对象，并把这些对象放入ArrayList集合中（使用泛型），对集合中的元素进行排序并遍历输出
 * 4、排序方式：调用ArrayList的sort方法，传入比较器对象（使用泛型），先按照name的自然顺序排序，如果name相同，按生日日期降序排序
 */
public class GenericExercise02 {
    public static void main(String[] args) {
        Emp tom = new Emp("Tom", 1500, new MyDate(1999, 1, 31));
        Emp jack = new Emp("Jack", 2500, new MyDate(1981, 11, 1));
        Emp mary = new Emp("Mary", 5500, new MyDate(1981, 11, 22));
        Emp mary2 = new Emp("Mary", 500, new MyDate(1981, 11, 21));
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(tom);
        emps.add(jack);
        emps.add(mary);
        emps.add(mary2);
        emps.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
//                if(!o1.getName().equals(o2.getName())){
//                    return o1.getName().compareTo(o2.getName());
//                }else{
//                    return o1.getBirthday().compareTo(o2.getBirthday());
//                }
                //使用三元运算符更简洁，但是可读性差
                return !o1.getName().equals(o2.getName())?o1.getName().compareTo(o2.getName()):o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        for (Emp e :emps) {
            System.out.println(e);
        }

    }
}
class Emp{
    private String name;
    private int sal;
    private MyDate birthday;

    public Emp(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        if(this.year != o.year)
            return this.year - o.year;
        else if(this.month != o.month)
            return this.month - o.month;
        else
            return this.day - o.day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}