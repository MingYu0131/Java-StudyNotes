package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 开启三个线程同时开始售票，康康会不会有什么问题
 * 引出通知线程退出
 */
public class TicketSellProblem {
    public static void main(String[] args) throws InterruptedException {
        TicketSeller ticketSeller1 = new TicketSeller();
        TicketSeller ticketSeller2 = new TicketSeller();
        TicketSeller ticketSeller3 = new TicketSeller();

        Thread thread01 = new Thread(ticketSeller1);
        Thread thread02 = new Thread(ticketSeller2);
        Thread thread03 = new Thread(ticketSeller3);



        thread01.start();
        thread02.start();
        thread03.start();
        //线程同步问题，此时会发现出现没有票了还在卖的情况，这是因为三个线程并没有做到对票数的同步，可能出现同时卖票的情况
        //这时引出通知线程退出的概念，线程完成任务后会自动退出，还可以通过在别的线程（例如main）使用变量的方式来控制run方法退出，即通知方式
        //线程同步问题，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，直到该线程完成操作，其他线程才能对该内存地址进行操作
        //真正完全解决这个问题需要用到锁
        Thread.sleep(10 * TicketSeller.getTicketNum());
        TicketSeller.setFlag(false);//在别的线程中关闭线程，这个操作就称为通知线程退出


    }
}

class TicketSeller implements Runnable{
    private static int ticketNum = 10; //100张票，三个线程同时销售
    private static boolean flag = true;

    public static int getTicketNum() {
        return ticketNum;
    }

    public static void setTicketNum(int ticketNum) {
        TicketSeller.ticketNum = ticketNum;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        TicketSeller.flag = flag;
    }

    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(10);   //每隔10毫秒就休眠
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在售票,还剩"+(--ticketNum));
        }


    }
}
