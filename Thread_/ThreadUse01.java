package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 讲解基本的线程使用，首先需要理解几个概念
 * 1、进程：指运行中的程序，启动一个进程操作系统就会为其分配内存和CPU等资源
 * 2、进程的本质：是程序的一次执行过程，是动态的，有产生存在和消亡的过程
 * 3、线程：由进程创建，是进程的实体，一个进程可以拥有多个线程
 * 4、单线程：同一个时刻只允许执行一个线程
 * 5、多线程：同一个时刻可以执行多个线程，例如QQ进程可以打开多个聊天，进程迅雷可以进行多个下载任务
 * 6、并发；同一时刻，多个任务交替进行，单核CPU实现多任务就是并发
 * 7、并行：同一时刻，多个任务由多核CPU同时执行
 *
 * 在Java中创建线程使用有两种方法
 * 1、继承Thread类，重写run方法
 * 2、实现Runnable接口，重写run方法
 * 这里使用第一种方法实现案例1：
 *      （1）编写程序，开启一个线程，该线程每隔1秒，在控制台输出“喵喵我是小猫咪”与线程名
 *      （2）当输出100次后结束该线程，并且在main方法中也开启一个线程输出（1，2，3，4....100）
 *      （3）使用JConsole监控线程执行情况（在程序运行时在cmd输入JConsole即可），并画出程序的示意图
 *
 */
public class ThreadUse01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
//        cat.run();//如果直接执行run，就是一个普通方法，会运行在main线程中，不会和main线程交替执行了
        cat.start();//启动线程-> 最终会执行 cat 的 run 方法
        /*
            查看start方法的源码
            （1）public synchronized void start() {
                    start0();
                 }
            （2）start0() 是本地方法，是 JVM 调用, 底层是 c/c++实现
            //真正实现多线程的效果， 是 start0(), 而不是 run
                private native void start0();
         */

        //cat.run();//run 方法就是一个普通的方法, 没有真正的启动一个线程，就会把 run 方法执行完毕，才向下执行
        // 说明: 当 main 线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行
        // 这时 主线程和子线程是交替执行
        //注意这里即使main已经执行完毕，但是因为cat的没有执行完毕，程序不会退出 -> 只要进程里的一个线程没有结束，进程就不会结束
        System.out.println("main线程会继续执行，不会阻塞:"+Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程："+i);
            //让主线程也休眠
            Thread.sleep(1000);
        }


    }
}


//1、当一个类继承了Thread类，该类就可以当作线程使用
//2、我们可以重写run方法写上自己的业务代码
//3、Thread类的run方法实现了Runnable接口的run方法
class Cat extends Thread{
    int times = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("喵喵我是小猫咪"+(++times) + "线程名："+Thread.currentThread().getName());
            try {
                //进程睡眠1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 100){
                break;
            }
        }
    }
}
