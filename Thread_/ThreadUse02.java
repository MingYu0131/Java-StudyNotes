package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 在Java中创建线程使用有两种方法
 *   1、继承Thread类，重写run方法
 *   2、实现Runnable接口，重写run方法
 *   （两种方式没有本质区别，建议使用Runnable接口的方式来实现线程）
 * 现在实现第二种方法
 * 1、java是单继承的，在某些情况下一个类可能已经继承了某个父类，这时就不能使用继承Thread类的方式来创建线程就不可能了
 * 2、java设计者们提供了通过Runnable接口和静态代理模式的方法来创建线程
 * 案例：
 *  编写程序，在控制台输出hi，输出50次后自动退出，使用实现Runnable接口的方式实现
 */
public class ThreadUse02 {
    public static void main(String[] args) {
        //创建两个对象就可以实现多线程了
        Dog dog = new Dog();
        Dog dog2 = new Dog();
//        dog.start();    //此时想通过和继承Thread类一样的方法来启动线程就不行了因为Runnable接口没有start方法
        //此时应该创建Thread 对象，把 dog 对象(实现 Runnable),放入 Thread
        //这里体现了一种设计模式，即代理模式，我们没有start方法，需要一个代理，即thread对象来帮我们调用start方法
        //这种设计模式的核心就是一个可以接受实现了目标接口的构造器
        Thread thread = new Thread(dog);    //启动第一个线程
        Thread thread2 = new Thread(dog2);  //启动第二个线程

        thread.start(); //底层还是使用的start0()来实现调用线程
        thread2.start();
    }
}

class Dog implements Runnable{
    int times = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("小狗hi！"+(++times) + "线程名："+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 50){
                break;
            }
        }

    }
}
