package com.JavaStudy.HspMiddleJavaTest.DesignPatterns;

/**
 * 设计模式之模板设计模式
 * 1、当功能内部一部分实现是确定的，一部分是不确定的，这时候可以把不确定的部分暴露出去让子类实现
 * 2、编写一个抽象的父类，父类提供子类的通用方法，并把一个或多个方法留给其他子类实现，这就是一种模板模式
 */
public class TemplatePattern {
    public static void main(String[] args) {
        JobA jobA = new JobA();
        jobA.calJobRunningTime();

        JobB jobB = new JobB();
        jobB.calJobRunningTime();
    }
}

abstract class tool{
    abstract void job();    //每个类都有一个要完成的任务

    public void calJobRunningTime(){
        long startTime = System.currentTimeMillis();    //以毫秒为单位返回当前时间
        job();
        long endTime = System.currentTimeMillis();
        System.out.println("任务的运行时间为："+(endTime - startTime));

    }

}

class JobA extends tool{
    @Override
    //实现1连乘到100000
    void job() {
        int sum = 1;
        for (int i = 1; i <= 100000; i++) {
            sum*=i;
        }
    }
}

class JobB extends tool{
    @Override
    //实现1连加到800000
    void job() {
        int sum = 0;
        for (int i = 0; i < 800000; i++) {
            sum += i;
        }
    }
}
