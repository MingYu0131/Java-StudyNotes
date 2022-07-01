package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 测试Thread的两个方法
 * join()和yield()
 * 1、yield，线程的礼让，让出CPU让其他线程先执行，但是礼让的时间不确定，具体的情况要依据CPU内核态来根据资源的情况决定，不一定礼让成功
 *    如果CPU发现资源很充足完全可以一起执行那么就会礼让失败
 * 2、join，线程的插队，插队的线程一旦插队成功，则肯定先执行完插入的线程的所有任务（也可能由于CPU资源紧张导致插队失败）
 */
public class ThreadMethods02 {
    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();//启动子线程
        tt.start();
        for (int i = 1; i < 100; i++) {
            Thread.sleep(100);
            System.out.println("主线程（小弟）"+Thread.currentThread().getName()+"正在吃第"+i+"个包子");
            if(i == 10){
                System.out.println("小弟让大哥先吃");
                //让大哥线程插队，先执行完大哥线程才会继续执行main线程
                tt.join();
//                tt.yield();
            }
        }
    }
}

class TT extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程（老大）"+Thread.currentThread().getName()+"正在吃第"+i+"个包子");
        }
    }
}
