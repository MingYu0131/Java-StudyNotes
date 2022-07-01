package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 测试线程类Thread的一组常用方法
 */
public class ThreadMethods01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        //设置线程名称
        t.setName("小笼包");
        //设置线程的优先级最低
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        System.out.println("默认优先级:"+Thread.currentThread().getPriority());
        //测试Interrupt，不是结束线程，指中断线程的休眠sleep状态，确实意思不像中断类似于一种启动
        Thread.sleep(3000);
        t.interrupt();
    }
}

class T extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                System.out.println("mybb吃包子"+i);
            }
            try {
                System.out.println("mybb休眠中");
                Thread.sleep(20000);//休眠20秒
            } catch (InterruptedException e) {//这里捕获的异常就是被中断时的
                //当线程执行到interrupt方法时就会抛出这个异常，可以在这里加入自己的业务代码
                System.out.println("线程"+Thread.currentThread().getName()+"被interrupt中断");
            }
        }
    }
}
