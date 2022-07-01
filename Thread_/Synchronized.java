package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 讲解Synchronized关键字，底层使用的是互斥锁，来保证共享数据操作的完整性
 * 1、每个对象都对应一个可称为“互斥锁”的标记，这个标记限制了在任意时刻只能有一个线程访问该对象
 * 2、同步的局限性：会导致程序的执行效率变低
 * 3、同步方法（非静态的）的锁可以是this，也可以是其他对象（但是必须要求各个线程面对的是同一个对象）
 * 4、同步方法（静态的）的锁为当前类本身
 * 5、一定要注意多线程锁的对象要是同一个对象！（不要出现类似synchronized(new Object())的操作，这样每个线程锁对象就不一样）
 */
public class Synchronized {
    public static void main(String[] args) {
        TicketSeller_ ticketSeller1 = new TicketSeller_();
        TicketSeller_ ticketSeller2 = new TicketSeller_();
        TicketSeller_ ticketSeller3 = new TicketSeller_();

        Thread thread01 = new Thread(ticketSeller1);
        Thread thread02 = new Thread(ticketSeller2);
        Thread thread03 = new Thread(ticketSeller3);

        thread01.start();
        thread02.start();
        thread03.start();
    }
}

class TicketSeller_ implements Runnable{
    private static int ticketNum = 20; //100张票，三个线程同时销售
    private static boolean flag = true;
    Object o = new Object();//创建一个用于互斥锁的对象

    //注意区别不同情况下锁加在什么上
    //同步方法（静态的）的锁为当前类本身
    //锁是加在TicketSeller_.class上
    public synchronized static void test1(){}

    //如果在静态方法中实现同步
    public static void test2(){
        synchronized (TicketSeller_.class){ //此时会发现static方法中没有this，应该使用类名.class
        }
    }
    public synchronized static void test3(){//直接使用synchronized关键词，锁也是加在类名.class上
    }



    public static int getTicketNum() {
        return ticketNum;
    }

    public static void setTicketNum(int ticketNum) {
        TicketSeller_.ticketNum = ticketNum;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        TicketSeller_.flag = flag;
    }

    //被synchronized关键字修饰的方法，同一时刻只能被一个线程执行
    //使用synchronized关键字解决售票问题
    //这是在普通方法中实现同步，锁是默认加在this上，也可以通过synchronized()选择别的对象作为锁
    public synchronized void sell(){
//        try {
//            Thread.sleep(50);   //每隔10毫秒就休眠
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName()+"正在售票,还剩"+(--ticketNum));
        if(getTicketNum() <= 0){
            setFlag(false);
        }

    }

    @Override
    public void run() {
        while (flag){
           sell();
        }


    }
}
