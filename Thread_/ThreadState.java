package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 介绍线程的七种状态
 * New,Runnable(Running,Ready),TimedWaiting,Waiting,Blocked,Terminated
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        //通过如下代码可以看到test线程的状态变化过程，具体见p798
        Test test = new Test();
        System.out.println(test.getState());
        test.start();
        while (test.getState() != Thread.State.TERMINATED){
            System.out.println(test.getState());
            Thread.sleep(100);
        }
        System.out.println(test.getState());

    }
}

class Test extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 10; i++) {
                System.out.println("线程"+Thread.currentThread().getName()+"执行中"+i);
                try {
                    //线程在被sleep后，会是TIMED_WAITING，直到sleep结束进入RUNNABLE
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
