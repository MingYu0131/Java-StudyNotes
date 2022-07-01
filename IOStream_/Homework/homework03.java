package com.JavaStudy.HspMiddleJavaTest.IOStream_.Homework;

import java.io.*;
import java.util.Properties;

/**
 * @author mingyu
 * @version 1.0
 * 1、编写一个dog.properties
 * name=tom age=5 color=red
 * 2、编写Dog类（name、age、color）创建一个dog对象，读取dog。properties用相应的内容完成属性初始化并输出
 * 3、将创建的Dog对象，序列化到文件dog.dat
 */
public class homework03 {
    public static void main(String[] args) throws IOException {
        createProperties();
        Properties properties = new Properties();
        properties.load(new FileReader("e:\\dog.properties"));
        Dog dog = new Dog();
        dog.setName(properties.getProperty("name"));
        dog.setAge(Integer.parseInt(properties.getProperty("age")));
        dog.setColor(properties.getProperty("color"));
        System.out.println(dog);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:\\dog.data"));
        oos.writeObject(dog);
        System.out.println("Dog对象序列化成功！");
        oos.close();
    }

    public static void createProperties() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name","tom");
        properties.setProperty("age","5");
        properties.setProperty("color","red");
        properties.store(new FileWriter("e:\\dog.properties"), null);
    }
}
class Dog implements Serializable{
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public Dog(){}

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
