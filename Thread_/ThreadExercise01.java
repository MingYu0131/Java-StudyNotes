package com.JavaStudy.HspMiddleJavaTest.Thread_;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

/**
 * @author mingyu
 * @version 1.0
 * 1、在main方法中启动两个线程
 * 2、第1个线程循环随机打印100以内的整数
 * 3、直到第2个线程从键盘读取了“Q”命令
 */
public class ThreadExercise01 {
    public static void main(String[] args) {
        new TTT().start();
        PPP ppp = new PPP();
        //也可以设置守护线程
//        ppp.setDaemon(true);
        ppp.start();


    }
}

class TTT extends Thread{
    private static boolean loop = true;
    @Override
    public void run() {
        while (loop){
            System.out.println("线程"+Thread.currentThread().getName()+"正在打印："+(int) (Math.random()*100));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isLoop() {
        return loop;
    }

    public static void setLoop(boolean loop) {
        TTT.loop = loop;
    }
}

class PPP extends Thread {
    Scanner ms = new Scanner(System.in);
    @Override
    public void run() {
        while (true){
            System.out.println("线程"+Thread.currentThread().getName()+"正在监听，等待输入q或Q结束线程");
            char s = ms.next().toUpperCase().charAt(0);
            if((s == 'Q') || (s == 'q')){
                TTT.setLoop(false);
                break;
            }

        }
    }


}
