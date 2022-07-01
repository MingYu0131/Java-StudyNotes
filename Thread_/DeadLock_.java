package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 分析死锁现象，模拟
 * 死锁：多个线程都占用了对方的锁资源，但是不肯相让，这就导致了死锁
 * 例如：妈妈：你先写完作业我就让你玩手机 小孩：你让我玩完手机我就写作业
 */
public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo d1 = new DeadLockDemo(true);
        DeadLockDemo d2 = new DeadLockDemo(false);
        //两个线程同时执行，死锁
        d1.start();
        d2.start();
    }
}

class DeadLockDemo extends Thread{
    static Object o1 = new Object();// 保证多线程，共享一个对象,这里使用 static
    static Object o2 = new Object();
    private boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    //下面业务逻辑的分析
    // 1. 如果 flag 为 T, 线程 A 就会先得到/持有 o1 对象锁, 然后尝试去获取 o2 对象锁
    // 2. 如果线程 A 得不到 o2 对象锁，就会 Blocked
    // 3. 如果 flag 为 F, 线程 B 就会先得到/持有 o2 对象锁, 然后尝试去获取 o1 对象锁
    // 4. 如果线程 B 得不到 o1 对象锁，就会 Blocked
    @Override
    public void run() {
        if(flag){
            //如果在这里让flag为真时等待一下，让为flag为true的线程先执行，就不会死锁了
            //注意这里Thread.sleep(1000);加的位置不能在同步代码块里面，因为在同步代码块内sleep不会释放锁
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (o1){//加上对象互斥锁
                    System.out.println(Thread.currentThread().getName()+"进入1"+Thread.currentThread().getState());
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"进入2"+Thread.currentThread().getState());
                }
            }
        }else {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"进入3"+Thread.currentThread().getState());
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"进入4"+Thread.currentThread().getState());
                }
            }
        }

    }
}
