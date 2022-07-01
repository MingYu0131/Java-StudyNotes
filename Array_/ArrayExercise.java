package com.JavaStudy.HspMiddleJavaTest.Array_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingyu
 * @version 1.0
 * 测试Array。sort（）的定制排序方法，可以对对象数组进行排序
 */
public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("Java从入门到放弃", 500);

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
//                return o1.getPrice() - o2.getPrice(); //按价格从小到大
                return o2.getName().length() - o1.getName().length();       //按书名长度从大到小
            }

        });
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}

class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}