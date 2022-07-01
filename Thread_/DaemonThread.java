package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 测试用户线程和守护线程
 * 1、用户线程：也叫工作线程，当线程的任务执行完毕或收到通知就会结束
 * 2、守护线程；一般是为工作线程服务的，当所有的用户线程结束，守护线程就会自动结束，常见的守护线程有垃圾回收机制和监控机制
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread dt = new MyDaemonThread();
        //将dt设置为守护线程，当所有线程结束后，dt也就自动结束
        //如果没有设置，那么即使main线程执行完毕，dt也不会退出
        dt.setDaemon(true);//注意要先设置为守护线程再start，不然会报异常
        dt.start();
        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("宝强在辛苦工作~~~ "+i);
        }
    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆快乐聊天，哈哈哈~~~");
        }
    }
}
